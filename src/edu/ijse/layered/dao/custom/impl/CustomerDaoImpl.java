/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ijse.layered.dao.custom.impl;

import edu.ijse.layered.dao.CrudUtil;
import edu.ijse.layered.dao.custom.CustomerDao;
import edu.ijse.layered.entity.CustomerEntity;
import java.util.ArrayList;
import java.sql.ResultSet;


/**
 *
 * @author osandaindunika
 */
public class CustomerDaoImpl implements CustomerDao{

    @Override
    public String save(CustomerEntity t) throws Exception {
        return null;
    }

    @Override
    public String update(CustomerEntity t) throws Exception {
        return null;
    }

    @Override
    public String delete(String id) throws Exception {
        return null;
    }

    @Override
    public CustomerEntity get(String id) throws Exception {
        ResultSet rst = CrudUtil.executeQuery("SELECT * FROM customer WHERE CustID = ?", id);
        if(rst.next()){
            return new CustomerEntity(rst.getString("CustID"),
                    rst.getString("CustTitle"), 
                    rst.getString("CustName"), 
                    rst.getString("DOB"), 
                    rst.getDouble("salary"), 
                    rst.getString("CustAddress"),
                    rst.getString("City"), 
                    rst.getString("Province"), 
                    rst.getString("PostalCode"));
        }
        return null;
    }

    @Override
    public ArrayList<CustomerEntity> getAll() throws Exception {
         return null;
    }
    
    
    
}
