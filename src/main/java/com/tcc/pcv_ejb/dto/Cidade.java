/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tcc.pcv_ejb.dto;

/**
 *
 * @author Ken
 */
public class Cidade {
    
    Long id;

    Float x;
    
    Float y;
    
    CidadeType type;
    
    int categoriaNLoop;
    
    public Cidade(Long id, Float x, Float y) {
        this.x = x;
        this.y = y;
        this.id = id;
    }
    
    public Cidade(Long id, Float x, Float y, CidadeType type, int categoriaNLoop) {
        this.x = x;
        this.y = y;
        this.id = id;
        this.type = type;
        this.categoriaNLoop = categoriaNLoop;
    }
    
    public int getCategoria(){
        return categoriaNLoop;
    }

    public CidadeType getType() {
        return type;
    }
    
    public Float getX(){
        return this.x;
    }
    
    public Float getY(){
        return y;
    }
    
    public Long getId(){
        return id;
    }
    
    @Override
    public String toString(){
        return getX()+", "+getY();
    }
    
}
