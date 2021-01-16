package com.mybatis.dao;

import com.mybatis.pojo.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface UserDao {
    @Select("SELECT * FROM user WHERE id=#{ids}")
    User findById(@Param("ids") Integer id);

    @Insert("INSERT INTO user VALUES(#{id}, #{username}, #{sex}, #{address})")
    @SelectKey(keyProperty = "id", resultType = Integer.class,
            statement = "SELECT last_insert_id()", before = false)
    void save(User user);

    @Delete("DELETE FROM user WHERE id=#{id}")
    void deleteById(Integer id);

    @Update("UPDATE user SET username=#{username}, sex=#{sex}, address=#{address} WHERE id=#{id}")
    void update(User user);

    @Select("SELECT * FROM user")
    List<User> findAll();

    @Select("SELECT * FROM user WHERE username LIKE CONCAT('%', #{username}, '%')")
    List<User> findByName(String name);

    @Select("SELECT * FROM user WHERE username=#{username} AND address=#{address}")
    List<User> findByNameAndAddress(@Param("username") String name, @Param("address") String address);


}
