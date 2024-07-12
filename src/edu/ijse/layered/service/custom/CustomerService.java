/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package edu.ijse.layered.service.custom;

import edu.ijse.layered.dto.CustomerDto;
import edu.ijse.layered.service.SuperService;
import java.util.ArrayList;

/**
 *
 * @author osandaindunika
 */
public interface CustomerService extends SuperService {

    public String save(CustomerDto customerDto) throws Exception;
    public String update(CustomerDto customerDto) throws Exception;
    public String delete(String custId) throws Exception;
    public CustomerDto getCustomer(String custId) throws Exception;
    public ArrayList<CustomerDto> getAll() throws Exception;
    
}
