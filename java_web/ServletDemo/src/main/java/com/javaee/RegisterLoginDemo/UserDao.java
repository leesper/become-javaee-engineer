package com.javaee.RegisterLoginDemo;

import com.javaee.ServletDemo.DruidUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.SQLException;

public class UserDao {
    public void register(User user) {
        QueryRunner qr = new QueryRunner(DruidUtils.getDataSource());
        String sql = "INSERT INTO user(`username`, `password`, `email`, `name`, `gender`, `birthday`) VALUES(?, ?, ?, ?, ?, ?)";
        try {
            qr.update(sql,
                    user.getUsername(),
                    user.getPassword(),
                    user.getEmail(),
                    user.getName(),
                    user.getGender(),
                    user.getBirthday());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public User login(String username, String password) {
        QueryRunner qr = new QueryRunner(DruidUtils.getDataSource());
        String sql = "SELECT * FROM user WHERE username=? AND password=?";
        Object[] params = {username, password};
        User user = null;
        try {
            user = qr.query(sql, new BeanHandler<User>(User.class), params);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return user;
    }
}
