package com.mybatis;

import com.mybatis.dao.OrdersDao;
import com.mybatis.pojo.*;
import com.mybatis.utils.SqlSessionUtils;
import com.sun.tools.corba.se.idl.constExpr.Or;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class Demo {
    @Test
    public void testFindByOrdersWithUser() {
        SqlSession sqlSession = SqlSessionUtils.openSession();
        OrdersDao ordersDao = sqlSession.getMapper(OrdersDao.class);
        List<OrderUsers> orderUsers = ordersDao.findByOrdersWithUser();
        for (OrderUsers orderUser : orderUsers) {
            System.out.println("orderUser=" + orderUser);
        }
        sqlSession.close();
    }

    @Test
    public void testFindByUserWithOrders() {
        SqlSession sqlSession = SqlSessionUtils.openSession();
        OrdersDao ordersDao = sqlSession.getMapper(OrdersDao.class);
        List<UserOrders> userOrders = ordersDao.findByUserWithOrders();
        for (UserOrders userOrder : userOrders) {
            System.out.println("userOrder=" + userOrder);
        }
        sqlSession.close();
    }

    @Test
    public void testFindByUserWithRoles() {
        SqlSession sqlSession = SqlSessionUtils.openSession();
        OrdersDao ordersDao = sqlSession.getMapper(OrdersDao.class);
        List<UserRoles> userRoles = ordersDao.findByUserWithRoles();
        for (UserRoles userRole : userRoles) {
            System.out.println("userRole=" + userRole);
        }
        sqlSession.close();
    }

    @Test
    public void testFindByRoleWithUsers() {
        SqlSession sqlSession = SqlSessionUtils.openSession();
        OrdersDao ordersDao = sqlSession.getMapper(OrdersDao.class);
        List<RoleUsers> roleUsers = ordersDao.findByRoleWithUsers();
        for (RoleUsers roleUser : roleUsers) {
            System.out.println("roleUser=" + roleUser);
        }
        sqlSession.close();
    }
}
