/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tcc.pcv_ejb;

import com.tcc.pcv_ejb.cities_info.Cidade;
import java.util.ArrayList;

/**
 *
 * @author Ken
 */
public class GerenciadorTour {
    
    // Holds our cities
    private ArrayList cidades = new ArrayList<Cidade>();

    // Adds a destination city
    public void addCidade(Cidade city) {
        cidades.add(city);
    }
    
    // Get a city
    public Cidade getCidade(int index){
        return (Cidade) cidades.get(index);
    }
    
    // Get the number of destination cities
    public int qtdCidades(){
        return cidades.size();
    }
    
}
