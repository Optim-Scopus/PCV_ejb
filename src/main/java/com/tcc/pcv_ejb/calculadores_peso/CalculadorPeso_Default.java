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
    
    @Override
    int calculaDistancia(Cidade c1, Cidade c2){
        int xDistance = Math.abs(c1.getX() - c2.getX());
        int yDistance = Math.abs(c1.getY() - c2.getY());
        return (int) Math.sqrt((xDistance*xDistance) + (yDistance*yDistance));
    }
    
    @Override
    double calculaEsperaEmSeg(Cidade c1, int timeArrival){
        return 0;
    }

    @Override
    public Double[] getThetaByRestaurantId(Long id) {
        return new Double[0];
    }
}
