package com.mybatis.dao;

import com.mybatis.pojo.RoleUsers;
import com.mybatis.pojo.User;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

public interface RoleUsersDao {
    @Select("SELECT * FROM role")
    @Results(value = {
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "name", column = "rolename"),
            @Result(property = "users",
                    javaType = List.class,
                    column = "id",
                    many = @Many(fetchType = FetchType.LAZY,
                            select = "com.mybatis.dao.RoleUsersDao.findByRoleid"))
    })
    List<RoleUsers> findAll();

    @Select("SELECT id, username, sex, address FROM user u JOIN user_role ur ON u.id = ur.userid WHERE ur.roleid = #{roleid}")
    List<User> findByRoleid(Integer roleid);
}
