/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ijse.layered.dao.custom.impl;

import edu.ijse.layered.dao.CrudUtil;
import edu.ijse.layered.dao.custom.OrderDao;
import edu.ijse.layered.entity.OrderEntity;
import java.util.ArrayList;


/**
 *
 * @author osandaindunika
 */
public class OrderDaoImpl implements OrderDao {
    
    @Override
    public String save(OrderEntity t) throws Exception {
        boolean isOrderSaved = CrudUtil.executeUpdate("INSERT INTO orders VALUES (?,?,?)", t.getOrderId(), t.getDate(), t.getCustId());
        return isOrderSaved? "Success" : "Fail";
    }

    @Override
    public String update(OrderEntity t) throws Exception {
        return null;
    }

    @Override
    public String delete(String id) throws Exception {
        return null;
    }

    @Override
    public OrderEntity get(String id) throws Exception {
       return null;
    }

    @Override
    public ArrayList<OrderEntity> getAll() throws Exception {
        return null;
    }

}
