/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.tashima42.apimanager.repositories;

import com.tashima42.apimanager.entities.Employee;
import java.util.ArrayList;

/**
 *
 * @author tashima
 */
public interface IEmployeeRepository {
    Employee findByName(String name);
    ArrayList<Employee> getAll();
}
