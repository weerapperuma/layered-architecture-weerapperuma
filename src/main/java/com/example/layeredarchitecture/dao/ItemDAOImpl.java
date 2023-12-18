package com.example.layeredarchitecture.dao;

import com.example.layeredarchitecture.db.DBConnection;
import com.example.layeredarchitecture.model.ItemDTO;

import java.sql.*;
import java.util.ArrayList;

public class ItemDAOImpl implements ItemDAO{
    @Override
    public ArrayList<ItemDTO> getAllItems() throws SQLException, ClassNotFoundException {
        Connection connection= DBConnection.getDbConnection().getConnection();
        Statement statement=connection.createStatement();
        ResultSet rst = statement.executeQuery("SELECT * FROM item");

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
    public boolean saveItem(ItemDTO dto) throws SQLException, ClassNotFoundException {
        Connection connection=DBConnection.getDbConnection().getConnection();
        PreparedStatement pstm= connection.prepareStatement("Insert INTO item (code,description,qtyOnHand,unitPrice)");
        pstm.setString(1,dto.getCode());
        pstm.setString(2,dto.getDescription());
        pstm.setString(3, String.valueOf(dto.getQtyOnHand()));
        pstm.setString(4, String.valueOf(dto.getUnitPrice()));
        int i = pstm.executeUpdate();
        return (i>0);

    }
}
