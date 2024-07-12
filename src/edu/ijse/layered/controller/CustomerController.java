/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ijse.layered.controller;

import edu.ijse.layered.dto.CustomerDto;
import edu.ijse.layered.service.ServiceFactory;
import edu.ijse.layered.service.custom.CustomerService;

/**
 *
 * @author osandaindunika
 */
public class CustomerController {
    
     CustomerService customerService = (CustomerService) ServiceFactory.getInstance().getService(ServiceFactory.ServiceType.CUSTOMER);
    
    public CustomerDto searchCustomer(String custId) throws Exception{
        return customerService.getCustomer(custId);
    }
}
