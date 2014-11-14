/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mateo.invertedindex;

/**
 *
 * @author Mateo
 */
public class Index {
    private int frase;
    private int pos;
    public Index(int frase, int pos){
        this.frase = frase;
        this.pos = pos;
    }
    /**
     * @return the frase
     */
    public int getFrase() {
        return frase;
    }

    /**
     * @return the pos
     */
    public int getPos() {
        return pos;
    }
    
}
