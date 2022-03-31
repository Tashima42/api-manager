/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tashima42.apimanager.entities;

/**
 *
 * @author tashima
 */
public class Team {
    private String name;
    private String description;
    private Employee manager;
    private Integer id;
    
    
    public Team(String name, String description, Employee manager, Integer id) {
        this.name = name;
        this.description = description;
        this.manager = manager;
        this.id = id;
    }

    public String getName() {
        return this.name;
    }
    public String getDescription() {
        return this.description;
    }
    public Employee getManager() {
        return this.manager;
    }
    public Integer getId() {
        return this.id;
    }
}
