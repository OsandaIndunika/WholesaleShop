/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ijse.layered.service.custom.impl;

import edu.ijse.layered.dao.DaoFactory;
import edu.ijse.layered.dao.custom.CustomerDao;
import edu.ijse.layered.dto.CustomerDto;
import edu.ijse.layered.entity.CustomerEntity;
import edu.ijse.layered.service.custom.CustomerService;
import java.util.ArrayList;

/**
 *
 * @author osandaindunika
 */
public class CustomerServiceImpl implements CustomerService{
    
     private CustomerDao customerDao = (CustomerDao) DaoFactory.getInstance().getDao(DaoFactory.DaoTypes.CUSTOMER);

    @Override
    public String save(CustomerDto customerDto) throws Exception {
        return null;
    }

    @Override
    public String update(CustomerDto customerDto) throws Exception {
        return null;
    }

    @Override
    public String delete(String custId) throws Exception {
        return null;
    }

    @Override
    public CustomerDto getCustomer(String custId) throws Exception {
        CustomerEntity customerEntity = customerDao.get(custId);
        if(customerEntity != null){
            return new CustomerDto(customerEntity.getCustId(),
                    customerEntity.getTitle(), customerEntity.getName(),
                    customerEntity.getDob(), customerEntity.getSalary(),
                    customerEntity.getAddress(), customerEntity.getCity(),
                    customerEntity.getProvince(), customerEntity.getZip());
        }
        return null;
    }

    @Override
    public ArrayList<CustomerDto> getAll() throws Exception {
        return null;
    }
}
