/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tcc.pcv_ejb.geradores_individuos;

import com.tcc.pcv_ejb.GerenciadorTour;
import com.tcc.pcv_ejb.PCVStrategy;

/**
 *
 * @author Ken
 */
public class GeradorIndividuo_Default extends GeradorIndividuo{
    
    public GeradorIndividuo_Default(int qtdCidades, GerenciadorTour gt) {
        super(qtdCidades, gt);
    }
    
}
