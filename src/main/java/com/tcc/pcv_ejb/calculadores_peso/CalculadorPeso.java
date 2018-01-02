/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tcc.pcv_ejb.calculadores_peso;

import com.tcc.pcv_ejb.dto.Cidade;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Ken
 */
public abstract class CalculadorPeso {
    
    Map<Long, List<Double>> thetas;
    private final double timeArrival;
    
    private final Cidade c0;
    
    public CalculadorPeso(double timeArrival, Cidade c0) {
        this.timeArrival = timeArrival;
        this.c0 = c0;
    }
                    
    public double calculaPeso(List<Cidade> t){
        double peso = calculaDistancia(c0, t.get(0));
        double now = timeArrival;
        for(int i = 0; i < t.size() - 1; i++){
            double waitTime = calculaEsperaEmSeg(t.get(i), now);
            now += waitTime;
            peso += calculaDistancia(t.get(i), t.get(i + 1)) + waitTime;
        }
        return peso;
    }
    
    abstract double calculaDistancia(Cidade c1, Cidade c2);
    
    abstract double calculaEsperaEmSeg(Cidade c1, double timeArrivalSOD);
    
}
