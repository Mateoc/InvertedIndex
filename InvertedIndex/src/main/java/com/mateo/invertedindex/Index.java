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
    private final int FRASE_INDEX;
    private final int POS_INDEX;
    public Index(int frase, int pos){
        this.FRASE_INDEX = frase;
        this.POS_INDEX = pos;
    }
    /**
     * @return the frase
     */
    public int getFrase() {
        return FRASE_INDEX;
    }

    /**
     * @return the pos
     */
    public int getPos() {
        return POS_INDEX;
    }
    
}
