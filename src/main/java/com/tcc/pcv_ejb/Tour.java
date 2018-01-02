/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tcc.pcv_ejb;

import com.tcc.pcv_ejb.dto.Cidade;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author Ken
 */
public class Tour {
    
    // Holds our tour of cities
    private ArrayList<Cidade> tour = new ArrayList<Cidade>();
    // Cache
    private double fitness = 0;
    private double peso = 0.0;
    
    private final PCVStrategy strat;
    
    // Constructs a blank tour
    public Tour(PCVStrategy strat){
        this.strat = strat;
        for (int i = 0; i < strat.getQtdCategorias(); i++) {
            tour.add(null);
        }
    }
    
    public Tour(ArrayList tour, PCVStrategy strat){
        this.strat = strat;
        this.tour = tour;
    }
    
    public Tour copy() {
      return new Tour(tour, strat);
    }

    // Gets a cidade from the tour
    public Cidade getCidade(int tourPosition) {
        return (Cidade)tour.get(tourPosition);
    }

    // Sets a cidade in a certain position within a tour
    public void setCidade(int tourPosition, Cidade cidade) {
        tour.set(tourPosition, cidade);
        // If the tours been altered we need to reset the fitness and peso
        fitness = 0;
        peso = 0;
    }
    
    public void addCidade(Cidade c) {
      tour.add(c);
    }
    
    // Creates a random individual
    public void geraIndividuo() {
        tour = strat.getGeradorIndividuo().geraIndividuo();
    }

    
    // Gets the tours fitness
    public double getFitness() {
        if (fitness == 0) {
            fitness = 1/(double)getPeso();
        }
        return fitness;
    }
    
    // Gets the total peso of the tour
    public double getPeso(){
        if (peso == 0) {
            peso = strat.getCalculadorPeso().calculaPeso(tour);
        }
        return peso;
    }

    // Get number of cities on our tour
    public int tourSize() {
        return tour.size();
    }
    
    // Check if the tour contains a cidade
    public boolean containsCidade(Cidade cidade){
        return tour.contains(cidade);
    }
    
    @Override
    public String toString() {
        String geneString = "|";
        for (int i = 0; i < tourSize(); i++) {
            geneString += getCidade(i)+"|";
        }
        return geneString;
    }
    
    Cidade getCidadeFromCategoria(int c){
      for(int i = 0; i < tourSize(); i++) {
        if(tour.get(i).getCategoria() == c) {
          return tour.get(i);
        }
      }
      return null;
    }
    
    public void shuffle(){
        Collections.shuffle(tour);
    }
    
    public List<Long> getCitiesAsIdsList(){
        List<Long> returnList = new ArrayList<>();
        for (Cidade city : tour) {
            returnList.add(city.getId());
        }
        return returnList;
    }
}
