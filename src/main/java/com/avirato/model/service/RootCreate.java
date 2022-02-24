/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.avirato.model.service;

/**
 *
 * @author Cristian
 */
public class RootCreate {
    private String name;
    private String job;
    
    public RootCreate(String name) {
        this.name = name;
    }
    
    public RootCreate(String name, String job) {
        this.name = name;
        this.job = job;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the job
     */
    public String getJob() {
        return job;
    }

    /**
     * @param job the job to set
     */
    public void setJob(String job) {
        this.job = job;
    }

    
    
}
