package com.example.layeredarchitecture.dao;

import com.example.layeredarchitecture.model.CustomerDTO;

import java.sql.SQLException;
import java.util.ArrayList;


public interface CrudDAO <T>{

    public ArrayList<T> getAll() throws SQLException, ClassNotFoundException;
    public boolean save(T dto) throws SQLException, ClassNotFoundException;

    public boolean update(T dto) throws SQLException, ClassNotFoundException;
    public boolean exist(String id) throws SQLException, ClassNotFoundException;
    public boolean delete(T dto) throws SQLException, ClassNotFoundException;
    public String generateID() throws SQLException, ClassNotFoundException;

}