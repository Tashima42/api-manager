/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.tashima42.apimanager.repositories;

import com.tashima42.apimanager.entities.Maintenance;
import java.util.ArrayList;

/**
 *
 * @author tashima
 */
public interface IMaintenanceRepository {
    ArrayList<Maintenance> getAll();
    /*
    ArrayList<String> getNames();
    ArrayList<Integer> getIds();
    void removeTeam(Integer id);
    void update(Maintenance maintenance);
    void addTeam(Maintenance maintenance);
*/
}
