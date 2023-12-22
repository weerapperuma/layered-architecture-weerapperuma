package com.example.layeredarchitecture.dao.custom;

import java.sql.SQLException;

public interface OrdersDAO {
    public String generateNewId() throws SQLException, ClassNotFoundException;
}
