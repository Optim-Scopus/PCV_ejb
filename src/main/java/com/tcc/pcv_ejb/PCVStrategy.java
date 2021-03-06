/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tcc.pcv_ejb;

import com.tcc.pcv_ejb.calculadores_peso.CalculadorPeso;
import com.tcc.pcv_ejb.geradores_individuos.GeradorIndividuo;
import com.tcc.pcv_ejb.geradores_crossover.GeradorCrossover;
import com.tcc.pcv_ejb.mutadores.Mutador;

/**
 *
 * @author Ken
 */
public class PCVStrategy {
    
    private final Mutador m;
    private final CalculadorPeso cp;
    private final GeradorIndividuo gi;
    private final GeradorCrossover gp;
    private final int qtdCategorias;
    
    public PCVStrategy(Mutador m, CalculadorPeso cp, GeradorIndividuo gi, GeradorCrossover gp, int qtdCategorias){
        this.m = m;
        this.cp = cp;
        this.gi = gi;
        this.gp = gp;
        this.qtdCategorias = qtdCategorias;
    }

    public int getQtdCategorias() {
        return qtdCategorias;
    }
    
    public Mutador getMutador(){
        return m;
    }
    
    public CalculadorPeso getCalculadorPeso(){
        return cp;
    }
    
    public GeradorIndividuo getGeradorIndividuo(){
        return gi;
    }
    
    public GeradorCrossover getGeradorPopulacao(){
        return gp;
    }
    
}
