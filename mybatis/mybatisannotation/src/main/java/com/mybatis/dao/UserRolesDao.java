package com.mybatis.dao;

import com.mybatis.pojo.Role;
import com.mybatis.pojo.UserRoles;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

public interface UserRolesDao {
    @Select("SELECT * FROM user")
    @Results(value = {
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "username", column = "username"),
            @Result(property = "sex", column = "sex"),
            @Result(property = "address", column = "address"),
            @Result(property = "roles",
                    javaType = List.class,
                    column = "id",
                    many = @Many(fetchType = FetchType.LAZY,
                            select = "com.mybatis.dao.UserRolesDao.findByUserid"))
    })
    List<UserRoles> findAll();

    @Select("SELECT id, rolename FROM role r JOIN user_role ur ON r.id=ur.roleid WHERE userid=#{userid}")
    @Results(value = {
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "name", column = "rolename")
    })
    List<Role> findByUserid(Integer userid);
}
