package com.example.layeredarchitecture.dao;

import com.example.layeredarchitecture.db.DBConnection;
import com.example.layeredarchitecture.model.CustomerDTO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class CustomerDaoImp implements CustomerDao{
    public ArrayList<CustomerDTO> getAllCustomer() throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getDbConnection().getConnection();
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery("SELECT * FROM Customer");

        ArrayList<CustomerDTO> dto=new ArrayList<>();
        while (rst.next()){
            CustomerDTO customerDTO=new CustomerDTO(
                    rst.getString(1),
                    rst.getString(2),
                    rst.getString(3)
            );
            dto.add(customerDTO);
        }

        return dto;
    }
}
