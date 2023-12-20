package com.example.layeredarchitecture.dao.Imp;

import com.example.layeredarchitecture.dao.SQLUtil;
import com.example.layeredarchitecture.dao.custom.ItemDAO;
import com.example.layeredarchitecture.db.DBConnection;
import com.example.layeredarchitecture.model.ItemDTO;

import java.sql.*;
import java.util.ArrayList;

public class ItemDAOImpl implements ItemDAO {
    @Override
    public ArrayList<ItemDTO> getAll() throws SQLException, ClassNotFoundException {
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
    public boolean save(ItemDTO dto) throws SQLException, ClassNotFoundException {
        Connection connection=DBConnection.getDbConnection().getConnection();
        PreparedStatement pstm= connection.prepareStatement("Insert INTO item (code,description,qtyOnHand,unitPrice)");
        pstm.setString(1,dto.getCode());
        pstm.setString(2,dto.getDescription());
        pstm.setString(3, String.valueOf(dto.getQtyOnHand()));
        pstm.setString(4, String.valueOf(dto.getUnitPrice()));
        int i = pstm.executeUpdate();
        return (i>0);

    }

    @Override
    public boolean update(ItemDTO dto) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean exist(String id) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {

        return SQLUtil.execute("DELETE FROM Customer WHERE id=?",id);
    }

    @Override
    public String generateID() throws SQLException, ClassNotFoundException {
        return null;
    }
}
