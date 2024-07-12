/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package edu.ijse.layered.dao;

import java.util.ArrayList;

/**
 *
 * @author osandaindunika
 */
public interface CrudDao<T, ID> extends SuperDao{
    String save(T t) throws Exception;
    String update(T t) throws Exception;
    String delete(ID id) throws Exception;
    T get(ID id) throws Exception;
    ArrayList<T> getAll() throws Exception;
}
