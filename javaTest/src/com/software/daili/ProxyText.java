package com.software.daili;

public class ProxyText {

    public static void main(String[] args) {
        //静态代理
//        UserDao userDao=new UserDaoImpl();
//        UserDao userDaoProxy=new UserDaoProxy(userDao);
//        userDaoProxy.save();
        UserDao target = new UserDaoImpl();
        // 【原始的类型 class cn.itcast.b_dynamic.UserDao】
        System.out.println(target.getClass());
        // 给目标对象，创建代理对象
        UserDao proxy = (UserDao) new ProxyFactry<UserDao>(target).getProxyInstance();
        // class $Proxy0   内存中动态生成的代理对象
        proxy.save();
        System.out.println(proxy.getClass());
    }
}
