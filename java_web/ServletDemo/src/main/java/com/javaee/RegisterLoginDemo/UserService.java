package com.javaee.RegisterLoginDemo;

public class UserService {
    private static UserDao userDao = new UserDao();

    public void register(User user) {
        userDao.register(user);
    }

    public User login(String username, String password) {
        return userDao.login(username, password);
    }
}
