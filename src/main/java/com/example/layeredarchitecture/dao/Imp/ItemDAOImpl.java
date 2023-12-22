package com.example.layeredarchitecture.dao.Imp;

import com.example.layeredarchitecture.model.CustomerDTO;
import com.example.layeredarchitecture.util.SQLUtil;
import com.example.layeredarchitecture.dao.custom.ItemDAO;
import com.example.layeredarchitecture.db.DBConnection;
import com.example.layeredarchitecture.model.ItemDTO;

import java.sql.*;
import java.util.ArrayList;

public class ItemDAOImpl implements ItemDAO {
    @Override
    public ArrayList<ItemDTO> getAll() throws SQLException, ClassNotFoundException {

        ResultSet rst= SQLUtil.execute("SELECT * FROM item");
        ArrayList<ItemDTO> dto=new ArrayList<>();
        while(rst.next()){
            ItemDTO itemDTO=new ItemDTO(
                    rst.getString(1),
                    rst.getString(2),
                    rst.getBigDecimal(3),
                    rst.getInt(4)
            );
            dto.add(itemDTO);
        }
        return dto;
    }
    @Override
    public boolean save(ItemDTO dto) throws SQLException, ClassNotFoundException {

        return SQLUtil.execute("INSERT INTO item(code,description,qtyOnHand,unitPrice) VALUES(?,?,?,?)",dto.getCode(),dto.getDescription(),dto.getQtyOnHand(),dto.getUnitPrice());

    }

    @Override
    public boolean update(ItemDTO dto) throws SQLException, ClassNotFoundException {

        return SQLUtil.execute("UPDATE Item SET description=?, unitPrice=?, qtyOnHand=? WHERE code=?",dto.getDescription(),dto.getQtyOnHand(),dto.getUnitPrice(),dto.getCode());
    }

    @Override
    public boolean exist(String id) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {

        return SQLUtil.execute("DELETE FROM item WHERE id=?",id);
    }

    @Override
    public String generateID() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public ItemDTO search(String newItemCode) throws SQLException, ClassNotFoundException {
        ResultSet rst = SQLUtil.execute("SELECT * FROM Item WHERE code=?",(newItemCode+""));
        if(rst.next()){
            return new ItemDTO( rst.getString(1), rst.getString(2), rst.getBigDecimal(3), rst.getInt(4));
        }
        return null;

    }
}
