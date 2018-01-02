/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tcc.pcv_ejb.calculadores_peso;

import com.tcc.pcv_ejb.dto.Cidade;

/**
 *
 * @author Ken
 */
public class CalculadorPeso_Default extends CalculadorPeso {

    public CalculadorPeso_Default(long timeArrival, Cidade c0) {
        super(timeArrival, c0);
    }
    
    @Override
    double calculaDistancia(Cidade c1, Cidade c2){
        float xDistance = Math.abs(c1.getX() - c2.getX());
        float yDistance = Math.abs(c1.getY() - c2.getY());
        return (int) Math.sqrt((xDistance*xDistance) + (yDistance*yDistance));
    }
    
    @Override
    double calculaEsperaEmSeg(Cidade c1, double timeArrival){
        return 0;
    }
}
