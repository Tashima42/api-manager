/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tashima42.apimanager.main;

/**
 *
 * @author tashima
 */
public class Team {
    private String name;
    private User owner;
    
    public Team(String name, User owner) {
        this.name = name;
        this.owner = owner;
    }

    public String getName() {
        return this.name;
    }

    public User getOwner() {
        return this.owner;
    }
}
