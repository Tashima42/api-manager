/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tashima42.apimanager.views;

import com.tashima42.apimanager.main.Api;
import com.tashima42.apimanager.repositories.Sqlite.ApiRepository;
import java.util.ArrayList;

/**
 *
 * @author tashima
 */
public class ApiList {
  private final ApiRepository apiRepository;

    public ApiList() {
        this.apiRepository = new ApiRepository();
    }
  
  public ArrayList<Api> getAllTable() {
      ArrayList<Api> apis = apiRepository.getAll();
      return apis;
  }
}
