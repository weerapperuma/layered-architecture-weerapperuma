package com.example.layeredarchitecture.dao.custom;

import com.example.layeredarchitecture.model.OrderDetailDTO;

import java.sql.SQLException;

public interface OrderDetailsDAO {
    boolean save(String orderId, OrderDetailDTO detailDTO) throws SQLException, ClassNotFoundException;
}
