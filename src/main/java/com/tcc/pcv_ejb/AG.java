/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tcc.pcv_ejb;

import com.tcc.pcv_ejb.cities_info.Cidade;

/**
 *
 * @author Ken
 */
public class AG {
    
    /* GA parameters */
    private static final double mutationRate = 0.015;
    private static final int tournamentSize = 5;
    private static final boolean elitism = true;

    // Evolves a population over one generation
    public static Populacao evolvePopulacao(PCVStrategy strat, Populacao pop) {
        Populacao newPopulacao = new Populacao(pop.tamanhoPop(), false, strat);

        // Keep our best individual if elitism is enabled
        int elitismOffset = 0;
        if (elitism) {
            newPopulacao.saveTour(0, pop.getFittest());
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

    // Applies crossover to a set of parents and creates offspring
    public static Tour crossover(Tour parent1, Tour parent2, PCVStrategy strat) {
        // Create new child tour
        Tour child = new Tour(strat);

        // Get start and end sub tour positions for parent1's tour
        int startPos = (int) (Math.random() * parent1.tourSize());
        int endPos = (int) (Math.random() * parent1.tourSize());

        // Loop and add the sub tour from parent1 to our child
        for (int i = 0; i < child.tourSize(); i++) {
            // If our start position is less than the end position
            if (startPos < endPos && i > startPos && i < endPos) {
                child.setCidade(i, parent1.getCidade(i));
            } // If our start position is larger
            else if (startPos > endPos) {
                if (!(i < startPos && i > endPos)) {
                    child.setCidade(i, parent1.getCidade(i));
                }
            }
        }

        // Loop through parent2's city tour
        for (int i = 0; i < parent2.tourSize(); i++) {
            // If child doesn't have the city add it
            if (!child.containsCidade(parent2.getCidade(i))) {
                // Loop to find a spare position in the child's tour
                for (int ii = 0; ii < child.tourSize(); ii++) {
                    // Spare position found, add city
                    if (child.getCidade(ii) == null) {
                        child.setCidade(ii, parent2.getCidade(i));
                        break;
                    }
                }
            }
        }
        return child;
    }

    // Mutate a tour using swap mutation
    private static void mutate(Tour tour) {
        // Loop through tour cities
        for(int tourPos1=0; tourPos1 < tour.tourSize(); tourPos1++){
            // Apply mutation rate
            if(Math.random() < mutationRate){
                // Get a second random position in the tour
                int tourPos2 = (int) (tour.tourSize() * Math.random());

                // Get the cities at target position in tour
                Cidade city1 = tour.getCidade(tourPos1);
                Cidade city2 = tour.getCidade(tourPos2);

                // Swap them around
                tour.setCidade(tourPos2, city1);
                tour.setCidade(tourPos1, city2);
            }
        }
    }

    // Selects candidate tour for crossover
    private static Tour tournamentSelection(Populacao pop, PCVStrategy strat) {
        // Create a tournament population
        Populacao tournament = new Populacao(tournamentSize, false, strat);
        // For each place in the tournament get a random candidate tour and
        // add it
        for (int i = 0; i < tournamentSize; i++) {
            int randomId = (int) (Math.random() * pop.tamanhoPop());
            tournament.saveTour(i, pop.getTour(randomId));
        }
        // Get the fittest tour
        Tour fittest = tournament.getFittest();
        return fittest;
    }
}
