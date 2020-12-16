package com.javaee;

import org.junit.Test;

import javax.swing.plaf.nimbus.State;
import java.sql.*;

public class JDBCDemo {
    @Test
    public void testJDBC() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");

        String url = "jdbc:mysql://localhost:3306/test_kkb";
        Connection conn = DriverManager.getConnection(url, "root", "root");
        System.out.println("conn = " + conn);

        Statement stat = conn.createStatement();
        String sql = "SELECT * FROM category";
        ResultSet rs = stat.executeQuery(sql);
        System.out.println("rs = " + rs);

        while (rs.next()) {
            int cid = rs.getInt("cid");
            String cname = rs.getString("cname");
            System.out.println("cid = " + cid + ", cname = " + cname);
        }

        rs.close();
        stat.close();
        conn.close();
    }

    @Test
    public void testJDBC2() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/test_kkb";
        Connection conn = DriverManager.getConnection(url, "root", "root");
        Statement stat = conn.createStatement();

        String sql = "INSERT INTO category(cname) VALUES('测试')";
        int result = stat.executeUpdate(sql);
        System.out.println("result = " + result);

        stat.close();
        conn.close();
    }

    @Test
    public void testJDBC3() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/test_kkb";
        Connection conn = DriverManager.getConnection(url, "root", "root");
        Statement stat = conn.createStatement();
        String sql = "UPDATE category SET cname = '测试2' WHERE cid = 4";
        int result = stat.executeUpdate(sql);
        System.out.println("result = " + result);

        stat.close();
        conn.close();
    }

    @Test
    public void testJDBC4() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/test_kkb";
        Connection conn = DriverManager.getConnection(url, "root","root");
        Statement stat = conn.createStatement();
        String sql = "DELETE FROM category WHERE cid = 4";
        int result = stat.executeUpdate(sql);
        System.out.println("result = " + result);
        stat.close();
        conn.close();
    }

    @Test
    public void testJDBC5() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/test_kkb";
        Connection conn = DriverManager.getConnection(url, "root", "root");
        Statement stat = conn.createStatement();
        String sql = "SELECT * FROM category WHERE cid = 3";
        ResultSet rs = stat.executeQuery(sql);

        while (rs.next()) {
            int cid = rs.getInt("cid");
            String cname = rs.getString("cname");
            System.out.println("cid = " + cid + ", cname = " + cname);
        }

        rs.close();
        stat.close();
        conn.close();
    }

    @Test
    public void testJDBC6() throws SQLException {
        Connection conn = JDBCUtils.getConnection();
        Statement stat = conn.createStatement();
        ResultSet rs = stat.executeQuery("SELECT * FROM category");
        while (rs.next()) {
            int cid = rs.getInt("cid");
            String cname = rs.getString("cname");
            System.out.println("cid = " + cid + ", cname = " + cname);
        }
        JDBCUtils.close(rs, stat, conn);
    }

    @Test
    public void testPreparedQuery() throws SQLException {
        Connection conn = JDBCUtils.getConnection();
        String sql = "SELECT * FROM users WHERE username=? AND password=?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, "admin");
        pstmt.setString(2, "1234");
        ResultSet rs = pstmt.executeQuery();
        while (rs.next()) {
            int uid = rs.getInt("uid");
            String username = rs.getString("username");
            String password = rs.getString("password");
            System.out.println(uid + username + password);
        }
        JDBCUtils.close(rs, pstmt, conn);
    }

    @Test
    public void testPreparedInsert() throws SQLException {
        Connection conn = JDBCUtils.getConnection();
        String sql = "INSERT INTO users(username, password) VALUES(?, ?)";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, "lisi");
        pstmt.setString(2, "1234");
        int result = pstmt.executeUpdate();
        System.out.println(result);
        JDBCUtils.close(null, pstmt, conn);
    }
}
