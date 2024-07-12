/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ijse.layered.service.custom.impl;

import edu.ijse.layered.dao.DaoFactory;
import edu.ijse.layered.dao.custom.ItemDao;
import edu.ijse.layered.dto.ItemDto;
import edu.ijse.layered.entity.ItemEntity;
import edu.ijse.layered.service.custom.ItemService;
import java.util.ArrayList;

/**
 *
 * @author osandaindunika
 */
public class ItemServiceImpl implements ItemService {
    
    private ItemDao itemDao = (ItemDao) DaoFactory.getInstance().getDao(DaoFactory.DaoTypes.ITEM);

    @Override
    public String save(ItemDto dto) throws Exception {
        ItemEntity entity = new ItemEntity(dto.getCode(), dto.getDescription(),
                dto.getPack(), dto.getUnitPrice(), dto.getQoh());
        return itemDao.save(entity);
    }

     @Override
    public String update(ItemDto dto) throws Exception {
        ItemEntity entity = getItemEntity(dto);
        return itemDao.update(entity);
    }

    @Override
    public String delete(String code) throws Exception {
        return itemDao.delete(code);
    }

    @Override
    public ItemDto get(String code) throws Exception {
        ItemEntity entity = itemDao.get(code);
        return getItemDto(entity);
    }

    @Override
    public ArrayList<ItemDto> getAll() throws Exception {
        ArrayList<ItemDto> itemDtos = new ArrayList<>();
        ArrayList<ItemEntity> itemEntitys = itemDao.getAll();
        for (ItemEntity itemEntity : itemEntitys) {
            ItemDto dto = getItemDto(itemEntity);
            itemDtos.add(dto);
        }
        return itemDtos;
    }
    
    private ItemDto getItemDto(ItemEntity entity){
        ItemDto itemDto = new ItemDto(entity.getItemCode(),
                entity.getDescription(),
                entity.getPackSize(), entity.getQoh(), entity.getUnitPrice());
        return itemDto;
    }
    
    private ItemEntity getItemEntity(ItemDto dto){
         ItemEntity entity = new ItemEntity(dto.getCode(), dto.getDescription(),
                dto.getPack(), dto.getUnitPrice(), dto.getQoh());
         return entity;
    }
    
    
}
