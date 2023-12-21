package com.example.layeredarchitecture.dao.custom;

import com.example.layeredarchitecture.util.CrudUtil;
import com.example.layeredarchitecture.model.CustomerDTO;

import java.sql.SQLException;

public interface CustomerDAO extends CrudUtil<CustomerDTO> {
    CustomerDTO search(String id) throws SQLException, ClassNotFoundException;
}
