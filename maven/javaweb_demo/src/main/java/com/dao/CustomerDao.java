package com.dao;

import com.pojo.Customer;
import com.utils.DruidUtils;
import org.apache.commons.dbutils.QueryRunner;

import java.sql.SQLException;

public class CustomerDao {
    public void register(Customer customer) throws SQLException {
        QueryRunner qr = new QueryRunner(DruidUtils.getDataSource());
        String sql = "INSERT INTO cst_customer VALUES(?,?,?,?,?,?,?)";
        Object[] params = {
                customer.getCust_id(),
                customer.getCust_name(),
                customer.getCust_source(),
                customer.getCust_industry(),
                customer.getCust_level(),
                customer.getCust_phone(),
                customer.getCust_mobile()
        };
        qr.update(sql, params);
    }
}
