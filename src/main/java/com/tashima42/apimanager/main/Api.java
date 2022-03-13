/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tashima42.apimanager.main;

/**
 *
 * @author tashima
 */
public class Api {
    private String name;
    private String description;
    private User owner;
    private Team team;
    
    public Api(String name, String description, User owner, Team team) {
        this.name = name;
        this.description = description;
        this.owner = owner;
        this.team = team;
    }
}
