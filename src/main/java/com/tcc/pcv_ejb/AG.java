/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tcc.pcv_ejb;

import com.tcc.pcv_ejb.dto.Cidade;
import com.tcc.pcv_ejb.mutadores.Mutador;

/**
 *
 * @author Ken
 */
public class AG {    
    /* GA parameters */
    private static final double mutationRate = 0.015;
    private static final int tournamentSize = 5;
    private static final boolean elitism = true;
    
    public static Populacao evolvePopulacao(Populacao pop, PCVStrategy strat) {
        Populacao newPopulacao = new Populacao(pop.tamanhoPop(), false, strat);

        // Keep our best individual if elitism is enabled
        int elitismOffset = 0;
        if (elitism) {
            newPopulacao.saveTour(0, pop.getFittest());
            newPopulacao.saveTour(1, pop.getFittest().copy());
            elitismOffset = 1;
        }

        // Crossover population
        // Loop over the new population's size and create individuals from
        // Current population

        for (int i = elitismOffset; i < newPopulacao.tamanhoPop(); i++) {
            // Select parents
            Tour parent1 = tournamentSelection(pop, strat);
            Tour parent2 = tournamentSelection(pop, strat);
            // Crossover parents
            Tour child = crossover(parent1, parent2, strat);
            // Add child to new population
            newPopulacao.saveTour(i, child);
        }

        // Mutate the new population a bit to add some new genetic material
        for (int i = elitismOffset; i < newPopulacao.tamanhoPop(); i++) {
            mutate(newPopulacao.getTour(i));
        }

        return newPopulacao;
    }
    
    public static Tour crossover(Tour t1, Tour t2, PCVStrategy strat) {
        Tour filho = new Tour(strat);

        for(int i = 0; i < t1.tourSize(); i++){
          if(Math.random() < 0.5){
            filho.setCidade(i, t1.getCidadeFromCategoria(i));
          } else {
            filho.setCidade(i, t2.getCidadeFromCategoria(i));
          }
        }

        filho.shuffle();

        return filho;
      }
    
    public static void mutate(Tour t) {
        // Loop through tour cities
        for(int i = 0; i < t.tourSize(); i++){
          // Apply mutation rate
          if(Math.random() < mutationRate){
              // Get a second random position in the tour
              int tourPos2 = (int) (t.tourSize() * Math.random());

              // Get the cities at target position in tour
              Cidade city1 = t.getCidade(i);
              Cidade city2 = t.getCidade(tourPos2);

              // Swap them around
              t.setCidade(tourPos2, city1);
              t.setCidade(i, city2);
          }
        }
    }
    
    public static Tour tournamentSelection(Populacao p, PCVStrategy strat) {
        // Criamos uma população de torneio vazia
        Populacao torneio = new Populacao(tournamentSize, false, strat);
        // Preenchemos cada posição do torneio com um indivíduo aleatório da população testada
        for (int i = 0; i < tournamentSize; i++) {
            torneio.saveTour(i, p.getTour((int) (Math.random() * p.tamanhoPop())));
        }
        // Retornamos o fittest desse torneio
        return torneio.getFittest();
  }
}
