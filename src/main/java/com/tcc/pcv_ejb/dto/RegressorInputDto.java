/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tcc.pcv_ejb.dto;

/**
 *
 * @author luiz
 */
public class RegressorInputDto {
    
    private int dow;

    private int groupSize;

    private int groceriesSize;

    private int task;

    private int issue;

    private int specialDate;
    
    private static RegressorInputDto dto;
    
    private RegressorInputDto(){}
    
    public static RegressorInputDto getDto(){
        if (dto == null){
            dto = new RegressorInputDto();
        }
        return dto;
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
}
