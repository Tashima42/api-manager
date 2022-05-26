/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tashima42.apimanager.views;

import com.tashima42.apimanager.entities.Api;
import com.tashima42.apimanager.entities.Employee;
import com.tashima42.apimanager.entities.Team;
import com.tashima42.apimanager.repositories.Sqlite.ApiRepository;
import com.tashima42.apimanager.repositories.Sqlite.EmployeeRepository;
import com.tashima42.apimanager.repositories.Sqlite.TeamRepository;
import java.util.ArrayList;

/**
 *
 * @author tashima
 */
public class Main {

    private final ApiRepository apiRepository;
    private final EmployeeRepository employeeRepository;
    private final TeamRepository teamRepository;

    public Main() {
        this.apiRepository = new ApiRepository();
        this.employeeRepository = new EmployeeRepository();
        this.teamRepository = new TeamRepository();
    }

    public Object[][] getApisInfo() {
        ArrayList<Api> apis = apiRepository.getAll();
        Object[][] apisTableInfo = new Object[apis.size()][7];

        for (int i = 0; i < apis.size(); i++) {
            Api api = apis.get(i);
            
            apisTableInfo[i][0] = api.getId();
            apisTableInfo[i][1] = api.getName();
            apisTableInfo[i][2] = api.getDescription();
            apisTableInfo[i][3] = api.getTeam().getName();
            apisTableInfo[i][4] = api.getOwner().getName();
            apisTableInfo[i][5] = api.getOwner();
            apisTableInfo[i][6] = api.getTeam();
        }

        return apisTableInfo;
    }

    public Object[][] getTeamsInfo() {
        ArrayList<Team> teams = teamRepository.getAll();
        Object[][] teamsTableInfo = new Object[teams.size()][5];

        for (int i = 0; i < teams.size(); i++) {
            Team team = teams.get(i);

            teamsTableInfo[i][0] = team.getId();
            teamsTableInfo[i][1] = team.getName();
            teamsTableInfo[i][2] = team.getDescription();
            teamsTableInfo[i][3] = team.getManager().getName();
            teamsTableInfo[i][4] = team.getManager();
        }

        return teamsTableInfo;
    }

    public Object[][] getEmployeesInfo() {
        ArrayList<Employee> employees = employeeRepository.getAll();
        Object[][] employeesTableInfo = new Object[employees.size()][5];

        for (int i = 0; i < employees.size(); i++) {
            Employee employee = employees.get(i);

            employeesTableInfo[i][0] = employee.getId();
            employeesTableInfo[i][1] = employee.getName();
            employeesTableInfo[i][2] = employee.getDescription();
            employeesTableInfo[i][3] = employee.getRole();
            employeesTableInfo[i][4] = employee.getPassword();
        }

        return employeesTableInfo;
    }
    
    
    public String[] getTeamNames() {
        ArrayList<String> namesList = teamRepository.getNames();
        String[] names = new String[namesList.size()];
        namesList.toArray(names);
        return names;
    }
    
    public String[] getEmployeeNames() {
        ArrayList<String> namesList = employeeRepository.getNames();
        String[] names = new String[namesList.size()];
        namesList.toArray(names);
        return names;
    }
    
    public Integer[] getApiIds() {
        ArrayList<Integer> idsList = apiRepository.getIds();
        Integer[] ids = new Integer[idsList.size()];
        idsList.toArray(ids);
        
        return ids;
    }
    
    public void updateApiInfo(Api api) {
         apiRepository.update(api);
    }
    
    public Employee getEmployeeByName(String name) {
        return employeeRepository.getByName(name);
    }
    
    public Team getTeamByName(String name) {
        return teamRepository.getByName(name);
    }
    
    public void addApi(Api api) {
        apiRepository.addApi(api);
    }
    
    public void removeApi(Integer id) {
        apiRepository.removeApi(id);
    }
    
    public void removeTeam(Integer id) {
        teamRepository.removeTeam(id);
    }
    
    public void updateTeamInfo(Team team) {
        teamRepository.update(team);
    }
    
    public void addTeam(Team team) {
        teamRepository.addTeam(team);
    }
    
    public void updateEmployeeInfo(Employee employee) {
        employeeRepository.update(employee);
    }
    
    public void addEmployee(Employee employee) {
        employeeRepository.addEmployee(employee);
    }
    
    public void removeEmployee(Integer id) {
        employeeRepository.removeEmployee(id);
    }
}
