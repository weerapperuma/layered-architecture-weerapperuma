package com.example.layeredarchitecture.dao.Imp;

import com.example.layeredarchitecture.dao.custom.OrderDetailsDAO;
import com.example.layeredarchitecture.model.OrderDetailDTO;
import com.example.layeredarchitecture.util.SQLUtil;

import java.sql.SQLException;

public class OrderDetailsImpl implements OrderDetailsDAO {
    @Override
    public boolean save(String orderId, OrderDetailDTO detailDTO) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("INSERT INTO OrderDetails (oid, itemCode, unitPrice, qty) VALUES (?,?,?,?)",
                orderId,
                detailDTO.getItemCode(),
                detailDTO.getUnitPrice(),
                detailDTO.getQty());
    }
}
