package com.mybatis;

import com.mybatis.dao.*;
import com.mybatis.pojo.*;
import com.mybatis.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class UserDaoTest {
    @Test
    public void testSave() {
        SqlSession sqlSession = SqlSessionUtils.openSession();
        UserDao userDao = sqlSession.getMapper(UserDao.class);

        User user = new User();
        user.setUsername("花花22");
        user.setSex("女");
        user.setAddress("上海");
        userDao.save(user);

        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testDeleteById() {
        SqlSession sqlSession = SqlSessionUtils.openSession();
        UserDao userDao = sqlSession.getMapper(UserDao.class);

        userDao.deleteById(5);

        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testUpdate() {
        SqlSession sqlSession = SqlSessionUtils.openSession();
        UserDao userDao = sqlSession.getMapper(UserDao.class);

        User user = new User();
        user.setId(4);
        user.setUsername("Jerry");
        user.setSex("⼥");
        user.setAddress("上海");
        userDao.update(user);

        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testFindAll() {
        SqlSession sqlSession = SqlSessionUtils.openSession();
        UserDao userDao = sqlSession.getMapper(UserDao.class);

        List<User> userList = userDao.findAll();
        for (User user : userList) {
            System.out.println("user = " + user);
        }

        sqlSession.close();
    }

    @Test
    public void testFindById() {
        SqlSession sqlSession = SqlSessionUtils.openSession();
        UserDao userDao = sqlSession.getMapper(UserDao.class);

        User user = userDao.findById(3);

        System.out.println("user = " + user);
        sqlSession.close();
    }

    @Test
    public void testFindByName() {
        SqlSession sqlSession = SqlSessionUtils.openSession();
        UserDao userDao = sqlSession.getMapper(UserDao.class);

        List<User> userList = userDao.findByName("o");
        for (User user : userList) {
            System.out.println("user = " + user);
        }

        sqlSession.close();
    }

    @Test
    public void testFindByNameAndAddress() {
        SqlSession sqlSession = SqlSessionUtils.openSession();
        UserDao userDao = sqlSession.getMapper(UserDao.class);

        List<User> userList = userDao.findByNameAndAddress("Tom", "北京");
        for (User user : userList) {
            System.out.println("user = " + user);
        }

        sqlSession.close();
    }

    @Test
    public void testFindAllOrderUsers() {
        SqlSession sqlSession = SqlSessionUtils.openSession();
        OrderUsersDao orderUsersDao = sqlSession.getMapper(OrderUsersDao.class);

        List<OrderUsers> orderUsers = orderUsersDao.findAll();
        for (OrderUsers orderUser : orderUsers) {
            System.out.println("orderUser=" + orderUser);
        }
    }

    @Test
    public void testFindAllUserOrders() {
        SqlSession sqlSession = SqlSessionUtils.openSession();
        UserOrdersDao userOrdersDao = sqlSession.getMapper(UserOrdersDao.class);

        List<UserOrders> userOrders = userOrdersDao.findAll();
        for (UserOrders userOrder : userOrders) {
            System.out.println("userOrder=" + userOrder);
        }
    }

    @Test
    public void testFindAllUserRoles() {
        SqlSession sqlSession = SqlSessionUtils.openSession();
        UserRolesDao userRolesDao = sqlSession.getMapper(UserRolesDao.class);

        List<UserRoles> userRoles = userRolesDao.findAll();
        for (UserRoles userRole : userRoles) {
            System.out.println("userRole=" + userRole);
        }
    }

    @Test
    public void testFindAllRoleUsers() {
        SqlSession sqlSession = SqlSessionUtils.openSession();
        RoleUsersDao roleUsersDao = sqlSession.getMapper(RoleUsersDao.class);

        List<RoleUsers> roleUsers = roleUsersDao.findAll();
        for (RoleUsers roleUser : roleUsers) {
            System.out.println("roleUser=" + roleUser);
        }
    }
}
