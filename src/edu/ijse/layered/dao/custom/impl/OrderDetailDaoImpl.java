/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ijse.layered.dao.custom.impl;

import edu.ijse.layered.dao.CrudUtil;
import edu.ijse.layered.dao.custom.OrderDetailDao;
import edu.ijse.layered.entity.OrderDetailEntity;
import java.util.ArrayList;

/**
 *
 * @author osandaindunika
 */
public class OrderDetailDaoImpl implements OrderDetailDao {
    
    @Override
    public String save(OrderDetailEntity t) throws Exception {
        boolean isOrderDetailSaved = CrudUtil.executeUpdate("INSERT INTO Orderdetail VALUES (?,?,?,?)", t.getOrderId(), t.getItemCode(), t.getQty(), t.getDiscount());
        return isOrderDetailSaved ? "Success" : "Fail";
    }

    @Override
    public String update(OrderDetailEntity t) throws Exception {
        return null;}

    @Override
    public String delete(Object id) throws Exception {
        return null;
    }

    @Override
    public OrderDetailEntity get(Object id) throws Exception {
        return null;
    }

    @Override
    public ArrayList<OrderDetailEntity> getAll() throws Exception { 
        return null;
    }
}
