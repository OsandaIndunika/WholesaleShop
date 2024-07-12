/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ijse.layered.dao.custom.impl;

import edu.ijse.layered.dao.CrudUtil;
import edu.ijse.layered.dao.custom.ItemDao;
import edu.ijse.layered.entity.ItemEntity;
import java.util.ArrayList;
import java.sql.ResultSet;


/**
 *
 * @author osandaindunika
 */
public class ItemDaoImpl implements ItemDao {
    
     @Override
    public String save(ItemEntity entity) throws Exception {
        boolean isSaved = CrudUtil.executeUpdate("INSERT INTO item VALUES(?,?,?,?,?)",
                entity.getItemCode(), entity.getDescription(), entity.getPackSize(),
                entity.getUnitPrice(), entity.getQoh());
        return isSaved ? "Success" : "Fail";
    }

    @Override
    public String update(ItemEntity entity) throws Exception {
        boolean isUpdated = CrudUtil.executeUpdate("UPDATE item SET Description=?, PackSize=?, UnitPrice = ?, QtyOnHand=? WHERE ItemCode =?",
                entity.getDescription(), entity.getPackSize(),
                entity.getUnitPrice(), entity.getQoh(), entity.getItemCode());
        return isUpdated ? "Success" : "Fail";
    }


    @Override
    public ArrayList<ItemEntity> getAll() throws Exception {
        ArrayList<ItemEntity> itemEntitys = new ArrayList<>();
        ResultSet rst = CrudUtil.executeQuery("SELECT * FROM Item");
        while (rst.next()) {
            ItemEntity entity = new ItemEntity(rst.getString("ItemCode"), rst.getString("Description"),
                    rst.getString("PackSize"), rst.getDouble("UnitPrice"), rst.getInt("QtyOnHand"));
            itemEntitys.add(entity);
        }

        return itemEntitys;
    }

    @Override
    public String delete(String id) throws Exception {
        boolean isDeleted = CrudUtil.executeUpdate("DELETE FROM item WHERE ItemCode =?", id);
        return isDeleted ? "Success" : "Fail";
    }

    @Override
    public ItemEntity get(String id) throws Exception {
        ResultSet rst = CrudUtil.executeQuery("SELECT * FROM item WHERE ItemCode =?", id);
        if (rst.next()) {
            return new ItemEntity(rst.getString("ItemCode"), rst.getString("Description"),
                    rst.getString("PackSize"), rst.getDouble("UnitPrice"), rst.getInt("QtyOnHand"));
        }
        return null;
    }
}
