/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mateo.invertedindex;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import static org.junit.Assert.*;

/**
 *
 * @author Mateo
 */
public class InvertedIndexTest {
    
    public InvertedIndexTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of get method, of class InvertedIndex with only one frase.
     */
    @org.junit.Test
    public void testGetOneFrase() {
        String find = "brilliant";
        String[] frase = {"A brilliant, festive study of JS Bach uses literature and painting to illuminate his 'dance-impregnated' music, writes Peter Conrad"};
        InvertedIndex instance = new InvertedIndex(frase);
        String[] expResult = {"A brilliant, festive study of JS Bach uses literature and painting to illuminate his 'dance-impregnated' music, writes Peter Conrad"};
        String[] result = instance.get(find);
        assertArrayEquals(expResult, result);   
    }

    /**
     * Test of get method, of class InvertedIndex.
     */
    @org.junit.Test
    public void testGet() {
        String find = "music";
        String[] frase = new String[]{ 
            "A brilliant, festive study of JS Bach uses literature and painting to illuminate his 'dance-impregnated' music, writes Peter Conrad", 
            "Fatima Bhutto on Malala Yousafzai's fearless and still-controversial memoir", 
            "Grisham's sequel to A Time to Kill is a solid courtroom drama about racial prejudice marred by a flawless white hero, writes John O'Connell", 
            "This strange repackaging of bits and pieces does the Man Booker winner no favours, says Sam Leith", 
            "Another book with music related content" 
        }; 
        InvertedIndex instance = new InvertedIndex(frase);
        String[] expResult = {
            "A brilliant, festive study of JS Bach uses literature and painting to illuminate his 'dance-impregnated' music, writes Peter Conrad",
            "Another book with music related content" 
        };
        String[] result = instance.get(find);
        assertArrayEquals(expResult, result);   
    }
    
    /**
     * Test of get method, of class InvertedIndex, with a word that isn't presnt.
     */
    @org.junit.Test
    public void testGetNotPresent() {
        String find = "between";
        String[] frase = new String[]{ 
            "A brilliant, festive study of JS Bach uses literature and painting to illuminate his 'dance-impregnated' music, writes Peter Conrad", 
            "Fatima Bhutto on Malala Yousafzai's fearless and still-controversial memoir", 
            "Grisham's sequel to A Time to Kill is a solid courtroom drama about racial prejudice marred by a flawless white hero, writes John O'Connell", 
            "This strange repackaging of bits and pieces does the Man Booker winner no favours, says Sam Leith", 
            "Another book with music related content" 
        }; 
        InvertedIndex instance = new InvertedIndex(frase);
        String[] expResult = null;
        String[] result = instance.get(find);
        assertArrayEquals(expResult, result);   
    }
    /**
     * Test of get method, of class InvertedIndex, with null.
     */
    @org.junit.Test
    public void testGetNull() {
        String find = null;
        String[] frase = new String[]{ 
            "A brilliant, festive study of JS Bach uses literature and painting to illuminate his 'dance-impregnated' music, writes Peter Conrad", 
            "Fatima Bhutto on Malala Yousafzai's fearless and still-controversial memoir", 
            "Grisham's sequel to A Time to Kill is a solid courtroom drama about racial prejudice marred by a flawless white hero, writes John O'Connell", 
            "This strange repackaging of bits and pieces does the Man Booker winner no favours, says Sam Leith", 
            "Another book with music related content" 
        }; 
        InvertedIndex instance = new InvertedIndex(frase);
        String[] expResult = null;
        String[] result = instance.get(find);
        assertArrayEquals(expResult, result);   
    }
    
    /**
     * Test of get method, of class InvertedIndex, with multiple words.
     */
    @org.junit.Test
    public void testGetMultiple() {
        String[] find = {"Fatima","brilliant"};
        String[] frase = new String[]{ 
            "A brilliant, festive study of JS Bach uses literature and painting to illuminate his 'dance-impregnated' music, writes Peter Conrad", 
            "Fatima Bhutto on Malala Yousafzai's fearless and still-controversial memoir", 
            "Grisham's sequel to A Time to Kill is a solid courtroom drama about racial prejudice marred by a flawless white hero, writes John O'Connell", 
            "This strange repackaging of bits and pieces does the Man Booker winner no favours, says Sam Leith", 
            "Another book with music related content" 
        }; 
        InvertedIndex instance = new InvertedIndex(frase);
        String[] expResult ={
            "Fatima Bhutto on Malala Yousafzai's fearless and still-controversial memoir",
           "A brilliant, festive study of JS Bach uses literature and painting to illuminate his 'dance-impregnated' music, writes Peter Conrad"
        };
        String[] result = instance.get(find);
        assertArrayEquals(expResult, result);   
    }
}
