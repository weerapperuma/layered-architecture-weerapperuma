package com.example.layeredarchitecture.util;

import com.example.layeredarchitecture.db.DBConnection;

import java.sql.Connection;
import java.sql.SQLException;

public class TransactionUtil {
    static Connection connection;
    static {
        try {
            connection= DBConnection.getDbConnection().getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    public static void rollBack() throws SQLException {
        connection.rollback();
    }
    public static Connection getConnection(){
        return connection;
    }
    public static void startTransaction() throws SQLException {
        connection.setAutoCommit(false);
    }
    public static void endTransaction() throws SQLException {
        connection.commit();
        connection.setAutoCommit(true);
    }
    public TransactionUtil() throws SQLException, ClassNotFoundException {
    }
}
