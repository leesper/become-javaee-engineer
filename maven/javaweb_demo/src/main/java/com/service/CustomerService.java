package com.service;

import com.dao.CustomerDao;
import com.pojo.Customer;

public class CustomerService {
    public void register(Customer customer) {
        CustomerDao customerDao = new CustomerDao();
        try {
            customerDao.register(customer);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
