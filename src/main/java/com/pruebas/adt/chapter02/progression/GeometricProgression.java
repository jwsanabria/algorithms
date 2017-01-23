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
public class GeometricProgression extends Progression{

    protected long base;

    public GeometricProgression() {
        this(2,1);
    }

    public GeometricProgression(long base) {
        this(base,1);
    }

    public GeometricProgression(long base, long start) {
        super(start);
        this.base = base;
    }
    
    protected void advance(){
        current *=base;
    }
}
