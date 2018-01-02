/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tcc.pcv_ejb.calculadores_peso;

import com.tcc.pcv_ejb.dto.Cidade;
import com.tcc.pcv_ejb.dto.RegressorInputDto;
import com.tcc.pcv_ejb.proxyWs.RegressorWsProxy;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author luiz
 */
public class CalculadorPeso_Regressao extends CalculadorPeso {
    
    private RegressorWsProxy regressorProxy = new RegressorWsProxy();
    private final static double SPEED = 50.0;
    
    public CalculadorPeso_Regressao(double timeArrival, Cidade c0) {
        super(timeArrival, c0);
        thetas = new HashMap<>();
    }
    
    @Override
    double calculaDistancia(Cidade c1, Cidade c2){
        float xDistance = Math.abs(c1.getX() - c2.getX());
        float yDistance = Math.abs(c1.getY() - c2.getY());
        return (Math.sqrt((xDistance*xDistance) + (yDistance*yDistance))/SPEED);
    }
    
    @Override
    double calculaEsperaEmSeg(Cidade c1, double timeArrival){
        List<Double> theta = thetas.get(c1.getId());
        
        //Logger.getLogger(CalculadorPeso_Regressao.class.getName()).log(Level.SEVERE, "Fucking hey");
        
        double result = 0.0;
        
        switch (c1.getType()) {
            case Restaurant:
                if (theta == null) theta = regressorProxy.getThetaAsVectorForRestaurant(c1.getId());
                result = calculaEsperaRestaurant(theta, timeArrival);
                break;
            case Bank:
                if (theta == null) theta = regressorProxy.getThetaAsVectorForBank(c1.getId());
                result = calculaEsperaBank(theta, timeArrival);
                break;
            case Groceries:
                if (theta == null) theta = regressorProxy.getThetaAsVectorForGrocery(c1.getId());
                result = calculaEsperaGroceries(theta, timeArrival);
                break;
            default:
                break;
        }
        synchronized(this) {
            thetas.put(c1.getId(), theta);
        }
        return result;
    }
    
    private double calculaEsperaRestaurant(List<Double> theta, double timeArrival) {
        RegressorInputDto dto = RegressorInputDto.getDto();
        double result;
        result = theta.get(0);
        result += theta.get(1) * dto.getDow();
        result += theta.get(2) * timeArrival;
        result += theta.get(3) * dto.getGroupSize();
        result += theta.get(4) * dto.getIssue();
        result += theta.get(5) * dto.getSpecialDate();
        
        return result;
    }
    
    private double calculaEsperaBank(List<Double> theta, double timeArrival) {
        RegressorInputDto dto = RegressorInputDto.getDto();
        double result;
        result = theta.get(0);
        result += theta.get(1) * dto.getDow();
        result += theta.get(2) * timeArrival;
        result += theta.get(3) * dto.getTask();
        result += theta.get(4) * dto.getIssue();
        
        return result;
    }
    
    private double calculaEsperaGroceries(List<Double> theta, double timeArrival) {
        RegressorInputDto dto = RegressorInputDto.getDto();
        double result;
        result = theta.get(0);
        result += theta.get(1) * dto.getDow();
        result += theta.get(2) * timeArrival;
        result += theta.get(3) * dto.getGroceriesSize();
        result += theta.get(4) * dto.getIssue();
        
        return result;
    }

}
