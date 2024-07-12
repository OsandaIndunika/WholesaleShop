/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ijse.layered.service;

import edu.ijse.layered.service.custom.impl.CustomerServiceImpl;
import edu.ijse.layered.service.custom.impl.ItemServiceImpl;
import edu.ijse.layered.service.custom.impl.OrderServiceImpl;

/**
 *
 * @author osandaindunika
 */
public class ServiceFactory {
    private static ServiceFactory serviceFactory;
    
    private ServiceFactory(){
    }
    
    public static ServiceFactory getInstance(){
        if(serviceFactory == null){
            serviceFactory = new ServiceFactory();
        }
        return serviceFactory;
    }
    
     public SuperService getService(ServiceType type){
        switch (type) {
            case ITEM:
                return new ItemServiceImpl();
            case CUSTOMER:
                return new CustomerServiceImpl();
            case ORDER:
                return new OrderServiceImpl();
            default:
                return null;
        }
    }
    
     public enum ServiceType{
        ITEM, CUSTOMER, ORDER
    }
}
