/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ijse.layered.service.custom.impl;

import edu.ijse.layered.dao.DaoFactory;
import edu.ijse.layered.dao.custom.ItemDao;
import edu.ijse.layered.dao.custom.OrderDao;
import edu.ijse.layered.dao.custom.OrderDetailDao;
import edu.ijse.layered.db.DBConnection;
import edu.ijse.layered.dto.OrderDetailDto;
import edu.ijse.layered.dto.OrderDto;
import edu.ijse.layered.entity.ItemEntity;
import edu.ijse.layered.entity.OrderDetailEntity;
import edu.ijse.layered.entity.OrderEntity;
import edu.ijse.layered.service.custom.OrderService;
import java.sql.Connection;

/**
 *
 * @author osandaindunika
 */
public class OrderServiceImpl implements OrderService {
    
    private OrderDao orderDao = (OrderDao) DaoFactory.getInstance().getDao(DaoFactory.DaoTypes.ORDER);
    private OrderDetailDao orderDetailDao = (OrderDetailDao) DaoFactory.getInstance().getDao(DaoFactory.DaoTypes.ORDER_DETAIL);
    private ItemDao itemDao = (ItemDao) DaoFactory.getInstance().getDao(DaoFactory.DaoTypes.ITEM);
    
    @Override
    public String placeOrder(OrderDto orderDto) throws Exception {
        Connection connection = DBConnection.getInstance().getConnection();
        try {
            connection.setAutoCommit(false);
            
            OrderEntity orderEntity = new OrderEntity(orderDto.getOrderId(), orderDto.getDate(), orderDto.getCustId());
            
            String resp = orderDao.save(orderEntity);
            if(resp.equals("Success")){
                
                boolean isOrderDetailSave = true;
                
                for (OrderDetailDto orderDetailDto : orderDto.getOrderDetailDtos()) {
                    OrderDetailEntity orderDetailEntity = new OrderDetailEntity(orderDto.getOrderId(),
                            orderDetailDto.getItemCode(), orderDetailDto.getQty(),
                            orderDetailDto.getDiscount());
                    String odResp = orderDetailDao.save(orderDetailEntity);
                    if(!odResp.equals("Success")){
                        isOrderDetailSave = false;
                    }
                }
                
                if(isOrderDetailSave){
                    boolean isItemUpdated = true;
                    
                    for (OrderDetailDto orderDetailDto : orderDto.getOrderDetailDtos()) {
                        ItemEntity itemEntity = itemDao.get(orderDetailDto.getItemCode());
                        itemEntity.setQoh(itemEntity.getQoh() - orderDetailDto.getQty());
                        String itemResp = itemDao.update(itemEntity);
                        if(!itemResp.equals("Success")){
                            isItemUpdated = false;
                        }
                    }
                    
                    if(isItemUpdated){
                        connection.commit();
                        return "Success";
                    } else {
                        connection.rollback();
                        return "Item update Error";
                    }
                    
                } else{
                    connection.rollback();
                    return "Order Detail Save Error";
                }
                
            } else {
                connection.rollback();
                return "Order Save Error";
            }
            
        } catch (Exception e) {
           connection.rollback();
           e.printStackTrace();
           return "Server Error";
        } finally {
            connection.setAutoCommit(true);
        }
    }
}
