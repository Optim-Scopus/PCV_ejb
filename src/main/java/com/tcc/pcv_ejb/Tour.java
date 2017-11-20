/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tcc.pcv_ejb;

import com.tcc.pcv_ejb.cities_info.Cidade;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Ken
 */
public class Tour {
    
    // Holds our tour of cities
    private List<Cidade> tour = new ArrayList<>();
    // Cache
    private double fitness = 0;
    private int peso = 0;
    
    private final PCVStrategy strat;
    
    // Constructs a blank tour
    public Tour(PCVStrategy strat){
        this.strat = strat;
        for (int i = 0; i < strat.getQtdCidades(); i++) {
            tour.add(null);
        }
    }
    
    public Tour(PCVStrategy strat, ArrayList tour){
        this.strat = strat;
        this.tour = tour;
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
    public int getPeso(){
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
    
    public List<Long> getCitiesAsIdsList(){
        List<Long> returnList = new ArrayList<>();
        for (Cidade city : tour) {
            returnList.add(city.getId());
        }
        return returnList;
    }
    
    @Override
    public String toString() {
        String geneString = "|";
        for (int i = 0; i < tourSize(); i++) {
            geneString += getCidade(i)+"|";
        }
        return geneString;
    }
}
