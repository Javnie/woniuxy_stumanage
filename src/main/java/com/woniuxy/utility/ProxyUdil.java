package com.woniuxy.utility;

import java.lang.reflect.Proxy;

public class ProxyUdil {
    public static <T> T getProxy(Class<T> c) {
        T t = null;
        T o = null;
        try {
            //此处的c为接口的实例类
            t = c.newInstance();
            MyInvocationHandler<T> myInvocationHandler = new MyInvocationHandler<>(t);
            o = (T) Proxy.newProxyInstance(ProxyUdil.class.getClassLoader(), new Class[]{t.getClass()}, myInvocationHandler);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return o;
    }
}
