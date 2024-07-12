/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package edu.ijse.layered.service.custom;

import edu.ijse.layered.dto.ItemDto;
import edu.ijse.layered.service.SuperService;
import java.util.ArrayList;

/**
 *
 * @author osandaindunika
 */
public interface ItemService extends SuperService {
    public String save(ItemDto dto) throws Exception;
    public String update(ItemDto dto) throws Exception;
    public String delete(String code) throws Exception;
    public ItemDto get(String code) throws Exception;
    public ArrayList<ItemDto> getAll() throws Exception;
    
}
