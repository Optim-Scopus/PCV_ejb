/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tcc.pcv_ejb.geradores_individuos;

import com.tcc.pcv_ejb.GerenciadorCategoria;
import com.tcc.pcv_ejb.dto.Cidade;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author Ken
 */
public class GeradorIndividuo_Default implements GeradorIndividuo{
    
    private int qtdCategorias;
    private GerenciadorCategoria gc;
    
    public GeradorIndividuo_Default(int qtdCategorias, GerenciadorCategoria gc) {
        this.qtdCategorias = qtdCategorias;
        this.gc = gc;
    }
    
    @Override
    public ArrayList<Cidade> geraIndividuo() {
        ArrayList<Cidade> tour = new ArrayList<Cidade>();
        // Itera por todas as categorias e pega uma cidade de cada
        for (int i = 0; i < qtdCategorias; i++) {
          tour.add(gc.getCategoria(i).getRandomCidade());
        }
        // Embaralha aleatoriamente
        Collections.shuffle(tour);
        return tour;
    }
}
