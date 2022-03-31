/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.tashima42.apimanager.repositories;

import com.tashima42.apimanager.entities.Team;
import java.util.ArrayList;

/**
 *
 * @author tashima
 */
public interface ITeamRepository {
    Team getByName(String teamName);
    ArrayList<Team> getAll();
    ArrayList<String> getNames();
    ArrayList<Integer> getIds();
}
