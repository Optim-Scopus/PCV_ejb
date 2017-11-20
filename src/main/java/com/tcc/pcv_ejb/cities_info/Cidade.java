/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tcc.pcv_ejb.cities_info;

/**
 *
 * @author Ken
 */
public class Cidade {
    
    Long id;

    int x;
    
    int y;
    
    CidadeType type;
    
    private int dow;
    
    private int groupSize;
    
    private int groceriesSize;
    
    private int task;
    
    private int issue;
    
    private int specialDate;
    
    public Cidade(Long id, CidadeType type, int x, int y, int dow, int groupSize, int issue, int specialDate) {
        this.x = x;
        this.y = y;
        this.id = id;
        this.type = type;
        this.dow = dow;
        this.groupSize = groupSize;
        this.issue = issue;
        this.specialDate = specialDate;
    }
    
    public Cidade(Long id, CidadeType type, int x, int y, int dow, int groceriesSize, int issue) {
        this.x = x;
        this.y = y;
        this.id = id;
        this.type = type;
        this.dow = dow;
        this.groupSize = groceriesSize;
        this.issue = issue;
    }
    
    public Cidade(Long id, CidadeType type, int x, int y, int dow, int task, int issue, boolean isBank) {
        this.x = x;
        this.y = y;
        this.id = id;
        this.type = type;
        this.dow = dow;
        this.groupSize = task;
        this.issue = issue;
    }

    public CidadeType getType() {
        return type;
    }
    
    public int getX(){
        return this.x;
    }
    
    public int getY(){
        return this.y;
    }
    
    public Long getId(){
        return this.id;
    }

    public int getDow() {
        return dow;
    }

    public void setDow(int dow) {
        this.dow = dow;
    }

    public int getGroupSize() {
        return groupSize;
    }

    public void setGroupSize(int groupSize) {
        this.groupSize = groupSize;
    }

    public int getGroceriesSize() {
        return groceriesSize;
    }

    public void setGroceriesSize(int groceriesSize) {
        this.groceriesSize = groceriesSize;
    }

    public int getTask() {
        return task;
    }

    public void setTask(int task) {
        this.task = task;
    }

    public int getIssue() {
        return issue;
    }

    public void setIssue(int issue) {
        this.issue = issue;
    }

    public int getSpecialDate() {
        return specialDate;
    }

    public void setSpecialDate(int specialDate) {
        this.specialDate = specialDate;
    }
    
    @Override
    public String toString(){
        return getX()+", "+getY();
    }
    
}
