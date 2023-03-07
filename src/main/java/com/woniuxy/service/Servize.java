package com.woniuxy.service;

import com.woniuxy.utility.DbHelper;

import java.sql.Connection;
import java.sql.SQLException;

public interface Servize {
    public default void falseAutoCommit() {
        Connection connection = DbHelper.getConnection();
        try {
            connection.setAutoCommit(false);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public default void doCommit() {
        Connection connection = DbHelper.getConnection();
        try {
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DbHelper.closeConnection();
        }
    }
}
