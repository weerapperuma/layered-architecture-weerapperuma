package com.example.layeredarchitecture.dao.Imp;

import com.example.layeredarchitecture.dao.custom.OrdersDAO;
import com.example.layeredarchitecture.util.SQLUtil;

import java.sql.ResultSet;
import java.sql.SQLException;

public class OrdersDAOImpl implements OrdersDAO {
    public String generateNewId() throws SQLException, ClassNotFoundException {
        ResultSet rst = SQLUtil.execute("SELECT oid FROM `Orders` ORDER BY oid DESC LIMIT 1;");

        if(rst.next()) return rst.getString(1);
        return null;
    }
}
