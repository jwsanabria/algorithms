/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pruebas.adt.chapter02.progression;

/**
 * Generates a simple progression.  By default: 0, 1, 2, ...
 * @author William
 */
public class Progression {
    
    
    //instance variable
    protected long current;

    /** Constructs a progression starting at zero */
    public Progression() {
        
    }

    /** Contructs a progression with given start value */
    public Progression(long start) {
        this.current = start;
    }
    
    /** Returns the next value of the progression */
    public long nextValue(){
        long answer = current;
        advance();
        return answer;
    }
    
    /** Advances the current value to the next value of the progression */
    protected void advance(){
        current++;
    }
    
    /** Prints the next n values of the progression, separated by spaces */
    public void printProgression(int n){
        System.out.print(nextValue());
        for(int j=1; j<n; j++){
            System.out.print(" " + nextValue());
        }
        System.out.println();
    }
    
    
    
}
