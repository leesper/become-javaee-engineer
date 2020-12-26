package com.javaee;

import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ColumnListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;

public class DBUtilsDemo {
    @Test
    public void testInsert() throws SQLException {
        QueryRunner qr = new QueryRunner(DruidUtils.getDataSource());
        String sql = "INSERT INTO product VALUES(?,?,?,?)";
        int res = qr.update(sql, 14, "康师傅方便面", 5, "c005");
        System.out.println(res);
    }

    @Test
    public void testUpdate() throws SQLException {
        QueryRunner qr = new QueryRunner(DruidUtils.getDataSource());
        String sql = "UPDATE product SET pname = ?, price = ? WHERE pid = ?";
        int res = qr.update(sql, "统一方便面", 4.5, 14);
        System.out.println(res);
    }

    @Test
    public void testDelete() throws SQLException {
        QueryRunner qr = new QueryRunner(DruidUtils.getDataSource());
        String sql = "DELETE FROM product WHERE pid = ?";
        int res = qr.update(sql, 14);
        System.out.println(res);
    }

    @Test
    public void testQueryBeanHandler() throws SQLException {
        QueryRunner qr = new QueryRunner(DruidUtils.getDataSource());
        String sql = "SELECT * FROM product WHERE pid = ?";
        Object[] params = {6};
        Product product = qr.query(sql, new BeanHandler<Product>(Product.class), params);
        System.out.println(product);
    }

    @Test
    public void testQueryBeanListHander() throws SQLException {
        QueryRunner qr = new QueryRunner(DruidUtils.getDataSource());
        String sql = "SELECT * FROM product";
        Object[] params = {};
        List<Product> products = qr.query(sql, new BeanListHandler<Product>(Product.class), params);
        for(Product product : products) {
            System.out.println(product);
        }
    }

    @Test
    public void testQueryScalarHandler() throws SQLException {
        QueryRunner qr = new QueryRunner(DruidUtils.getDataSource());
        String sql = "SELECT COUNT(*) FROM product";
        Long count = qr.query(sql, new ScalarHandler<Long>());
        System.out.println(count);
    }

    @Test
    public void testQueryColumnListHandler() throws SQLException {
        QueryRunner qr = new QueryRunner(DruidUtils.getDataSource());
        String sql = "SELECT * FROM product";
        List<String> names = qr.query(sql, new ColumnListHandler<String>("pname"));
        System.out.println(names);
    }
}
