package com.software.daili;

public class UserDaoProxy implements UserDao {
    private UserDao userDao;

    public UserDaoProxy(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void save() {
        System.out.println("----开始----");
        userDao.save();
        System.out.println("----结束----");
    }
}
