package com.mybatis.intro;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class Demo {
    @Test
    public void testFindAll() throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        List<User> userList = sqlSession.selectList("userMapper.findAll");
        for (User user: userList) {
            System.out.println("user=" + user);
        }
        sqlSession.close();
    }

    @Test
    public void testInsert() throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        User user = new User();
        user.setUsername("jack");
        user.setSex("男");
        user.setAddress("北京");

        int count = sqlSession.insert("userMapper.insert", user);
        System.out.println("affected rows: " + count);
        System.out.println("user id: " + user.getId());

        sqlSession.commit();

        sqlSession.close();
    }

    @Test
    public void testDelete() throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        int count = sqlSession.delete("userMapper.delete", 8);
        System.out.println("affected rows: " + count);

        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testUpdate() throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        User user = new User();
        user.setId(4);
        user.setUsername("rock");
        user.setSex("男");
        user.setAddress("美国");

        sqlSession.update("userMapper.update", user);

        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testFindById() throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        User user = sqlSession.selectOne("userMapper.findById", 2);
        System.out.println(user);

        sqlSession.close();
    }

    @Test
    public void testFindByName() throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        List<User> userList = sqlSession.selectList("userMapper.findByName", "j");
        for (User user : userList) {
            System.out.println("user=" + user);
        }

        sqlSession.close();
    }
}
