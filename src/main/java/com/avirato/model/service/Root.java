/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.avirato.model.service;

import java.util.ArrayList;

/**
 *
 * @author Cristian
 */
public class Root {
    
        private int page;
        private int per_page;
        private int total;
        private int total_pages;
        private ArrayList<Datum> data;
        private Support support;

    /**
     * @return the page
     */
    public int getPage() {
        return page;
    }

    /**
     * @param page the page to set
     */
    public void setPage(int page) {
        this.page = page;
    }

    /**
     * @return the per_page
     */
    public int getPer_page() {
        return per_page;
    }

    /**
     * @param per_page the per_page to set
     */
    public void setPer_page(int per_page) {
        this.per_page = per_page;
    }

    /**
     * @return the total
     */
    public int getTotal() {
        return total;
    }

    /**
     * @param total the total to set
     */
    public void setTotal(int total) {
        this.total = total;
    }

    /**
     * @return the total_pages
     */
    public int getTotal_pages() {
        return total_pages;
    }

    /**
     * @param total_pages the total_pages to set
     */
    public void setTotal_pages(int total_pages) {
        this.total_pages = total_pages;
    }

    /**
     * @return the data
     */
    public ArrayList<Datum> getData() {
        return data;
    }

    /**
     * @param data the data to set
     */
    public void setData(ArrayList<Datum> data) {
        this.data = data;
    }

    /**
     * @return the support
     */
    public Support getSupport() {
        return support;
    }

    /**
     * @param support the support to set
     */
    public void setSupport(Support support) {
        this.support = support;
    }
        
                
}
