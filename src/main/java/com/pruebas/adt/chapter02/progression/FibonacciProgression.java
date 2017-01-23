/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pruebas.adt.chapter02.progression;

/**
 *
 * @author William
 */
public class FibonacciProgression extends Progression{
    
    protected long prev;

    public FibonacciProgression() {
        this(0,1);
    }


    public FibonacciProgression(long first, long second) {
        super(first);
        this.prev = second - first;
    }
    
    

    @Override
    protected void advance() {
        long temp = prev;
        prev = current;
        current += temp;
    }
    
    
    
}
