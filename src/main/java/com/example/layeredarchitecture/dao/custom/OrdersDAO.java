package com.example.layeredarchitecture.dao.custom;

import com.example.layeredarchitecture.model.OrderDTO;

import java.sql.SQLException;

public interface OrdersDAO {
    public String generateNewId() throws SQLException, ClassNotFoundException;

    boolean save(OrderDTO orderDTO) throws SQLException, ClassNotFoundException;

    public boolean isExists(String id) throws SQLException, ClassNotFoundException;
}
