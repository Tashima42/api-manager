/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tashima42.apimanager.entities;

/**
 *
 * @author tashima
 */
public class Maintenance {
    private String description;
    private Employee owner;
    private Api api;
    private Integer id;
    
    public Maintenance(String description, Employee owner, Api api, Integer id) {
        this.description = description;
        this.owner = owner;
        this.api = api;
        this.id = id;
    }
    
    public String getDescription() {
        return this.description;
    }
    public Employee getOwner() {
        return this.owner;
    }
    public Api getApi() {
        return this.api;
    }
    public Integer getId() {
        return this.id;
    }
}
