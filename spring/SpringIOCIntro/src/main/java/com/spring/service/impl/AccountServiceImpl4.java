package com.spring.service.impl;

import com.spring.service.AccountService;

import java.util.*;

public class AccountServiceImpl4 implements AccountService {
    private String[] myStrs;
    private List<String> myList;
    private Set<String> mySet;
    private Map<String,String> myMap;
    private Properties myProps;

    @Override
    public void saveAccount() {
        System.out.println("myStrs ====" + Arrays.toString(myStrs));
        System.out.println("myList ====" + myList);
        System.out.println("mySet ====" + mySet);
        System.out.println("myMap ====" + myMap);
        System.out.println("myProps ====" + myProps);
    }

    public void setMyStrs(String[] myStrs) {
        this.myStrs = myStrs;
    }

    public void setMyList(List<String> myList) {
        this.myList = myList;
    }

    public void setMySet(Set<String> mySet) {
        this.mySet = mySet;
    }

    public void setMyMap(Map<String, String> myMap) {
        this.myMap = myMap;
    }

    public void setMyProps(Properties myProps) {
        this.myProps = myProps;
    }
}
