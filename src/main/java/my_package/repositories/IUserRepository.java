/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package my_package.repositories;

import my_package.User;

/**
 *
 * @author tashima
 */
public interface IUserRepository {
    User findByName(String name);
}
