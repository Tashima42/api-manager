/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tashima42.apimanager.entities;

/**
 *
 * @author tashima
 */
public class Api {
    private String name;
    private String description;
    private Employee owner;
    private Team team;
    
    public Api(String name, String description, Employee owner, Team team) {
        this.name = name;
        this.description = description;
        this.owner = owner;
        this.team = team;
    }
    
    public String getName() {
        return this.name;
    }
    public String getDescription() {
        return this.description;
    }
    public Employee getOwner() {
        return this.owner;
    }
    public Team getTeam() {
        return this.team;
    }
}
