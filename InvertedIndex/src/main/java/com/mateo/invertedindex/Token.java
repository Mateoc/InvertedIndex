/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mateo.invertedindex;

import java.util.ArrayList;

/**
 *
 * @author Mateo
 */
public class Token implements Comparable<Token> {
    //palabra
    private String token;
    //lista conteniendo diccionarios donde el key es la frase y el value es la posicion 
    private ArrayList<Index> indexs;
    
    public Token(String token, int frase, int pos){
        this.token = token;
        indexs = new ArrayList<Index>();
        indexs.add(new Index(frase,pos));
    }
    
    public void addIndex(int frase, int pos){
        indexs.add(new Index(frase, pos));
    }

    /**
     * @return the token
     */
    public String getToken() {
        return token;
    }

    /**
     * @return the indexs
     */
    public ArrayList<Index> getIndexs() {
        return indexs;
    }

    @Override
    public int compareTo(Token tok) {
        return token.compareTo(tok.getToken()); 
    }
    
}
