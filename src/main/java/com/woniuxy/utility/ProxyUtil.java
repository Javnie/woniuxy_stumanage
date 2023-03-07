package com.woniuxy.utility;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.SQLException;

public class ProxyUtil<T> {
    public <T> T getProxy(Class<T> c) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(c);
        enhancer.setCallback(new MethodInterceptor() {
            @Override
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                Connection connection = DbHelper.getConnection();
                Object r = null;
                try {
                    connection.setAutoCommit(false);
                    r = methodProxy.invokeSuper(o, objects);
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
        });

        return (T) enhancer.create();
    }
}
