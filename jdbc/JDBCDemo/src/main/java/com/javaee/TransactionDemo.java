package com.javaee;

import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TransactionDemo {
    @Test
    public void testChangeMoneyInTrans() {
        Connection conn = null;
        try {
            conn = DruidUtils.getConnection();
            conn.setAutoCommit(false);

            PreparedStatement pstmt1 = conn
                    .prepareStatement("UPDATE account SET money=money-? WHERE name=?");
            pstmt1.setDouble(1, 1000.0);
            pstmt1.setString(2, "jack");
            pstmt1.executeUpdate();

            PreparedStatement pstmt2 = conn
                    .prepareStatement("UPDATE account SET money=money+? WHERE name=?");
            pstmt2.setDouble(1, 1000.0);
            pstmt2.setString(2, "rose");
            pstmt2.executeUpdate();

            conn.rollback();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    @Test
    public void testChangeMoneyDBUtils() {
        try {
            Connection conn = DruidUtils.getConnection();
            conn.setAutoCommit(false);

            QueryRunner qr = new QueryRunner();
            qr.update(conn,"UPDATE account SET money=money-? WHERE name=?",
                    1000.0, "jack");
            qr.update(conn,"UPDATE account SET money=money+? WHERE name=?",
                    1000.0, "rose");

            DbUtils.rollbackAndCloseQuietly(conn);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
}
