/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tcc.pcv_ejb.calculadores_peso;

import com.tcc.pcv_ejb.cities_info.Cidade;
import com.tcc.regressao_ejb.Regressor;
import com.tcc.regressao_ejb.RegressorRemote;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import javax.ejb.Stateless;

/**
 *
 * @author luiz
 */
@Stateless
public class CalculadorPeso_Regressao extends CalculadorPeso {
    
    private RegressorRemote regressor = new Regressor();
    
    public CalculadorPeso_Regressao() {
        thetas = new HashMap<>();
    }
    
    @Override
    int calculaDistancia(Cidade c1, Cidade c2){
        int xDistance = Math.abs(c1.getX() - c2.getX());
        int yDistance = Math.abs(c1.getY() - c2.getY());
        return (int) Math.sqrt((xDistance*xDistance) + (yDistance*yDistance));
    }
    
    @Override
    double calculaEspera(Cidade c1, int timeArrival){
        Double[] theta = thetas.get(c1.getId());
        
        //Logger.getLogger(CalculadorPeso_Regressao.class.getName()).log(Level.SEVERE, "Fucking hey");
        
        double result = 0.0;
        
        switch (c1.getType()) {
            case Restaurant:
                if (theta == null) theta = regressor.getThetaAsVectorForRestaurant(c1.getId());
                result = calculaEsperaRestaurant(c1, theta, timeArrival);
                break;
            case Bank:
                // TODO
                //if (theta == null) theta = regressor.getThetaAsVectorForBankHistory(c1.getId());
                //result = calculaEsperaBank(c1, theta, timeArrival);
                break;
            case Groceries:
                // TODO
                //if (theta == null) theta = regressor.getThetaAsVectorForGroceryHistory(c1.getId());
                //result = calculaEsperaGroceries(c1, theta, timeArrival);
                break;
            default:
                break;
        }
        synchronized(this) {
            thetas.put(c1.getId(), theta);
        }
        return result;
    }
    
    private double calculaEsperaRestaurant(Cidade c1, Double[] theta, int timeArrival) {
        double result;
        result = theta[0] * c1.getDow();
        result += theta[1] * timeArrival;
        result += theta[2] * c1.getGroupSize();
        result += theta[3] * c1.getIssue();
        result += theta[4] * c1.getSpecialDate();
        
        return result;
    }
    
    private double calculaEsperaBank(Cidade c1, Double[] theta, int timeArrival) {
        double result = 0.0;
        
        return result;
    }
    
    private double calculaEsperaGroceries(Cidade c1, Double[] theta, int timeArrival) {
        double result = 0.0;
        
        return result;
    }
}
