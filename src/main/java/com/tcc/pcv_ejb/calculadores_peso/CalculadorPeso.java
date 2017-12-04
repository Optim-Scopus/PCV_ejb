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
    
    Map<Long, Double[]> thetas;
                    
    public int calculaPeso(List<Cidade> t){
        int peso = 0;
        for(int i = 0; i < t.size() - 1; i++){
            peso += calculaDistancia(t.get(i), t.get(i + 1)) + calculaEsperaEmSeg(t.get(i), 0);
        }
        return peso;
    }
    
    public abstract Double[] getThetaByRestaurantId(Long id);
    
    abstract int calculaDistancia(Cidade c1, Cidade c2);
    
    abstract double calculaEsperaEmSeg(Cidade c1, int timeArrivalSOD);
    
}
