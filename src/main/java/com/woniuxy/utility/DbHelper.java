package com.woniuxy.utility;

import java.lang.reflect.Field;
import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class DbHelper {
    private static ThreadLocal<Connection> conns = new ThreadLocal<>();

    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        Connection connection = conns.get();
        if (connection == null) {
            try {
                connection = DriverManager.getConnection("jdbc:mysql://61.139.65.143:46750/day021", "root", "123456");
                conns.set(connection);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return connection;
    }

    public static void executeSQL(String sql, Object... params) {
        PreparedStatement pstmt = null;
        try {
            pstmt = getConnection().prepareStatement(sql);
            for (int i = 0; i < params.length; i++) {
                pstmt.setObject(i + 1, params[i]);
            }
            pstmt.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static <T> T executeSQL(Class<T> c, String sql, int id) {
        ResultSet resultSet = null;
        T t = null;
        Field[] f = c.getDeclaredFields();
        try {
            PreparedStatement pstmt = getConnection().prepareStatement(sql);
            pstmt.setObject(1, id);
            resultSet = pstmt.executeQuery();
            if (resultSet.next()) {
                t = c.newInstance();
                for (Field field : f) {
                    field.setAccessible(true);
                    if (field.getType().equals(LocalDate.class)) {
                        String msg = resultSet.getString(field.getName());
                        LocalDate date = LocalDate.parse(msg, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
                        field.set(t, date);
                    } else {
                        field.set(t, resultSet.getObject(field.getName()));
                    }
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
        return t;
    }

    public static <T> List<T> executeSQL(Class<T> c, String sql, Object... params) {
        ResultSet resultSet = null;
        List<T> resultList = null;
        Field[] f = c.getDeclaredFields();
        try {
            PreparedStatement pstmt = getConnection().prepareStatement(sql);
            for (int i = 0; i < params.length; i++) {
                pstmt.setObject(i + 1, params[i]);
            }
            resultSet = pstmt.executeQuery();
            resultList = new ArrayList<>();
            while (resultSet.next()) {
                T t = c.newInstance();
                for (Field field : f) {
                    field.setAccessible(true);
                    if (field.getType() == LocalDate.class) {
                        String msg = resultSet.getString(field.getName());
                        LocalDate date = LocalDate.parse(msg, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
                        field.set(t, date);
                    } else {
                        field.set(t, resultSet.getObject(field.getName()));
                    }
                }
                resultList.add(t);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
        return resultList;
    }

    public static int getScalar(String sql, Object... params) {
        Connection connection = getConnection();
        try {
            PreparedStatement pstmt = connection.prepareStatement(sql);
            for (int i = 0; i < params.length; i++) {
                pstmt.setObject(i + 1, params[i]);
            }
            ResultSet rs = pstmt.executeQuery();
            rs.next();
            return rs.getInt(1);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    public static void closeConnection() {
        try {
            if (!getConnection().isClosed()) {
                getConnection().close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}