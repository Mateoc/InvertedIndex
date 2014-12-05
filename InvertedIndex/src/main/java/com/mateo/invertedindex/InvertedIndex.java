/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mateo.invertedindex;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.TreeMap;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;

/**
 *
 * @author Mateo
 */
public class InvertedIndex {
    //TODO: cambiar por arbolb
	CacheManager manager;
	private Cache cache; 
    private TreeMap<String,Token> tokens;
    
    private String[] data;
    
    public InvertedIndex(String[] data){
        this.data = data;
        tokens = new TreeMap<String,Token>();
        for(int i = 0; i < data.length; i++){
            StringTokenizer st = new StringTokenizer(data[i],"  ,.:;");
            //String[] tokens = data[i].split("");
            int j = 0;
            while (st.hasMoreTokens()) {
                String word = st.nextToken().toLowerCase();
                Token token = new Token(word, i, j);
                boolean exist = tokens.containsKey(word);
                if(exist){
                    tokens.get(word).addIndex(i, j);
                }else{
                    tokens.put(word, token);
                }
                j++;
            }
        }
        
        manager = CacheManager.create();
        if(!manager.cacheExists("cache")){
        	manager.addCache("cache");
        }
        cache = manager.getCache("cache");
    }
    
    public String[] get(String find){
        if(find==null){
            return null;
        }
        find = find.toLowerCase(); 
        Element element = cache.get(find);
        if(element!= null){
        	return (String[])element.getObjectValue();
        }
        String[] results = null;
        if(tokens.containsKey(find)){
            ArrayList<Index> index = tokens.get(find).getIndexs();
            results = new String[index.size()];
            for(int i = 0; i < index.size(); i++){
                results[i]=(data[index.get(i).getFrase()]);
            }
        }
        cache.put(new Element(find,results));
        simulateSlowSearch();
        return results;
    } 
    
    public String[] get(String[] find){
        if(find==null){
            return null;
        }
        ArrayList<String> results = new ArrayList<String>();
        for(String pfind : find){
            String[] res = get(pfind);
            if(res != null){
                results.addAll(Arrays.asList(res));
            }
        }
        if(results.size()==0){
            return null;
        }
        String [] aResults = new String[results.size()];
        int i = 0;
        for(String result : results){
            aResults[i] = result;
            i++;
        }
        return aResults; 
    }
    
    private void simulateSlowSearch() {
        try {
            long time = 3000L;
            Thread.sleep( time );
        } catch (InterruptedException e) {
            throw new IllegalStateException( e );
        }
    }
    
    public static void main(String args[]) {
        String[] data = new String[]{ 
            "A brilliant, festive study of JS Bach uses literature and painting to illuminate his 'dance-impregnated' music, writes Peter Conrad", 
            "Fatima Bhutto on Malala Yousafzai's fearless and still-controversial memoir", 
            "Grisham's sequel to A Time to Kill is a solid courtroom drama about racial prejudice marred by a flawless white hero, writes John O'Connell", 
            "This strange repackaging of bits and pieces does the Man Booker winner no favours, says Sam Leith", 
            "Another book with music related content" 
        }; 
        InvertedIndex invertedIndex= new InvertedIndex(data);
        String[] results = invertedIndex.get("music");
        System.out.println(results[0]);
        String[] results1 = invertedIndex.get("music");
        System.out.println(results1[0]);
        
    }

}
