package com.mybatis.dao;


import com.mybatis.pojo.OrderUsers;
import com.mybatis.pojo.RoleUsers;
import com.mybatis.pojo.UserOrders;
import com.mybatis.pojo.UserRoles;

import java.util.List;

public interface OrdersDao {
    List<OrderUsers> findByOrdersWithUser();
    List<UserOrders> findByUserWithOrders();
    List<UserRoles> findByUserWithRoles();
    List<RoleUsers> findByRoleWithUsers();
}
