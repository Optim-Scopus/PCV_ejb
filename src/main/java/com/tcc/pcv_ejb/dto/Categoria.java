/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tcc.pcv_ejb.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author luiz
 */
public class Categoria {
    private List<Cidade> cidades = new ArrayList<>();
    private String name = "";

    public Categoria() {
    }
    
    public Categoria(String name) {
        this.name = name;
    }

    public void addCidade(Cidade c) {
        cidades.add(c);
    }
    
    public void addCidades(List<Cidade> list) {
        cidades.addAll(list);
    }

    public Cidade getCidade(int i) {
        return cidades.get(i);
    }

    public Cidade getRandomCidade() {
        Random random = new Random(System.currentTimeMillis());
        return cidades.get(random.nextInt(cidades.size()));
    }

    public int getSize() {
        return cidades.size();
    }

    public String getName() {
        return name;
    }
    
    @Override
    public String toString() {
        String str = "";
        for (Cidade city : cidades) {
            str += city.id + ", ";
        }
        
        return "Categorie: " + name + ": {" + str + "}";
    }
}
