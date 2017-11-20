/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tcc.pcv_ejb.geradores_individuos;

import java.util.ArrayList;
import java.util.Collections;
import com.tcc.pcv_ejb.cities_info.Cidade;
import com.tcc.pcv_ejb.GerenciadorTour;
import com.tcc.pcv_ejb.PCVStrategy;

/**
 *
 * @author Ken
 */
public abstract class GeradorIndividuo {
    
    private final int qtdCidades;
    private final GerenciadorTour gt;
    
    public GeradorIndividuo(int qtdCidades, GerenciadorTour gt) {
        this.qtdCidades = qtdCidades;
        this.gt = gt;
    }
    
    public ArrayList<Cidade> geraIndividuo(){
        ArrayList<Cidade> tour = new ArrayList<Cidade>();
        // Loop through all our destination cities and add them to our tour
        for (int i = 0; i < qtdCidades; i++) {
          tour.add(gt.getCidade(i));
        }
        // Randomly reorder the tour
        Collections.shuffle(tour);
        return tour;
    }
}
