package com.woniuxy.utility;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.SQLException;

public class MyInvocationHandler<T> implements InvocationHandler {
    private T t;

    public MyInvocationHandler(T t) {
        this.t = t;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Connection connection = DbHelper.getConnection();
        Object r = null;
        try {
            connection.setAutoCommit(false);
            r = method.invoke(t, args);
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
            try {
                connection.rollback();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        } finally {
            DbHelper.closeConnection();
        }
        return r;
    }
}

