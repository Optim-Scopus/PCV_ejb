/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tcc.pcv_ejb;

/**
 *
 * @author Ken
 */
public class Populacao {
    // Holds populacao of tours
    Tour[] tours;
    
    private final PCVStrategy strat;
    
    // Construct a populacao
    public Populacao(int tamanhoPop, boolean init, PCVStrategy strat) {
        this.strat = strat;
        tours = new Tour[tamanhoPop];
        // If we need to init a populacao of tours do so
        if (init) {
            // Loop and create individuals
            for (int i = 0; i < tamanhoPop(); i++) {
                Tour novoTour = new Tour(strat, strat.getGeradorIndividuo().geraIndividuo());
                saveTour(i, novoTour);
            }
        }
    }
    
    // Saves a tour
    public void saveTour(int index, Tour tour) {
        tours[index] = tour;
    }
    
    // Gets a tour from populacao
    public Tour getTour(int index) {
        return tours[index];
    }

    // Gets the best tour in the populacao
    public Tour getFittest() {
        Tour fittest = tours[0];
        // Loop through individuals to find fittest
        for (int i = 1; i < tamanhoPop(); i++) {
            if (fittest.getFitness() <= getTour(i).getFitness()) {
                fittest = getTour(i);
            }
        }
        return fittest;
    }

    // Gets populacao size
    public int tamanhoPop() {
        return tours.length;
    }
}
