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

    private Tour[] tours;

    public Populacao(int tamanhoPop, boolean init, PCVStrategy strat) {
        tours = new Tour[tamanhoPop];
        // Se não queremos o Tour vazio, inicializamos
        if (init) {
            // Loop and create individuals
            for (int i = 0; i < tours.length; i++) {
                Tour novoTour = new Tour(strat.getGeradorIndividuo().geraIndividuo(), strat);
                saveTour(i, novoTour);
            }
        }
    }
    
    Tour[] getTours(){
      return tours;
    }
    
    void setTours(Tour[] tours) {
      this.tours = tours;
    }
    
    // Salva um tour
    public void saveTour(int index, Tour tour) {
        tours[index] = tour;
    }
    
    // Pega um Tour da População
    public Tour getTour(int index) {
        return tours[index];
    }

    // Pega o Tour de menor custo
    public Tour getFittest() {
        Tour fittest = tours[0];
        // Loop through individuals to find fittest
        for (int i = 0; i < tamanhoPop(); i++) {
            if (fittest.getFitness() <= getTour(i).getFitness()) {
                fittest = getTour(i);
            }
        }
        return fittest;
    }

    // Retorna o tamanho da população
    public int tamanhoPop() {
        return tours.length;
    }
}
