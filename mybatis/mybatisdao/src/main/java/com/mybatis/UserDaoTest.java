package com.mybatis;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mybatis.dao.UserDao;
import com.mybatis.pojo.User;
import com.mybatis.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class UserDaoTest {
    @Test
    public void testSave() {
        SqlSession sqlSession = SqlSessionUtils.openSession();
        UserDao userDao = sqlSession.getMapper(UserDao.class);

        User user = new User();
        user.setUsername("花花");
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
        userDao.deleteById(9);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testUpdate() {
        SqlSession sqlSession = SqlSessionUtils.openSession();
        UserDao userDao = sqlSession.getMapper(UserDao.class);

        User user = new User();
        user.setId(7);
        user.setUsername("花花");
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

        List<User> users = userDao.findAll();
        for (User user : users) {
            System.out.println("user=" + user);
        }

        sqlSession.close();
    }

    @Test
    public void testFindById() {
        SqlSession sqlSession = SqlSessionUtils.openSession();
        UserDao userDao = sqlSession.getMapper(UserDao.class);

        User user = userDao.findById(3);
        System.out.println("user=" + user);

        sqlSession.close();
    }

    @Test
    public void testFindByName() {
        SqlSession sqlSession = SqlSessionUtils.openSession();
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        List<User> userList = userDao.findByName("o");
        for (User user : userList) {
            System.out.println("user=" + user);
        }
        sqlSession.close();
    }

    @Test
    public void testFindByCondition() {
        SqlSession sqlSession = SqlSessionUtils.openSession();
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        User user = new User();
        user.setSex("男");
        user.setAddress("北京");

        List<User> users = userDao.findByCondition(user);
        for (User u : users) {
            System.out.println("user="+u);
        }

        sqlSession.close();
    }

    @Test
    public void testFindByIds() {
        SqlSession sqlSession = SqlSessionUtils.openSession();
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        List<Integer> ids = new ArrayList<>();
        ids.add(1);
        ids.add(2);

        List<User> users = userDao.findByIds(ids);
        for (User u : users) {
            System.out.println("user="+u);
        }

        sqlSession.close();
    }

    @Test
    public void testPageHelper() {
        PageHelper.startPage(1, 2);
        SqlSession sqlSession = SqlSessionUtils.openSession();
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        List<User> userList = userDao.findAll();
        for (User user : userList) {
            System.out.println("user=" + user);
        }
        PageInfo<User> pageInfo = new PageInfo<>(userList);
        System.out.println("总条数：" + pageInfo.getTotal());
        System.out.println("总页数：" + pageInfo.getPages());
        System.out.println("当前页：" + pageInfo.getPageNum());
        System.out.println("每页显示长度：" + pageInfo.getPageSize());
        System.out.println("是否第一页：" + pageInfo.isIsFirstPage());
        System.out.println("是否最后一页："+ pageInfo.isIsLastPage());

        Page page = (Page) userList;
        System.out.println("总条数：" + page.getTotal());
        System.out.println("总页数：" + page.getPages());
        List<User> result = page.getResult();
        for (User user : result) {
            System.out.println("user=" + user);
        }
    }
}
