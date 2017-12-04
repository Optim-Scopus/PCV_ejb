/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tcc.pcv_ejb.geradores_individuos;

import java.util.ArrayList;
import com.tcc.pcv_ejb.dto.Cidade;

/**
 *
 * @author Ken
 */
public interface GeradorIndividuo {
    
    public ArrayList<Cidade> geraIndividuo();
}
