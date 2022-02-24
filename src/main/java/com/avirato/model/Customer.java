/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.avirato.model;


/**
 *
 * @author Cristian
 */
public class Customer {
    
    private int id;
    String first_name;
    String last_name;
    String avatar;
    String email;
    //int phone;
    //String birthDate;

    public Customer() {
    }
    
    public Customer(String first_name, String last_name, String avatar, String email) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.avatar = avatar;
        this.email = email;
    }
    
    public Customer(int id, String first_name, String last_name, String avatar, String email) {
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.avatar = avatar;
        this.email = email;
    }

    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

       Object Id() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    
}
