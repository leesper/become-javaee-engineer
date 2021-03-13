package com.kkb.service.impl;

import com.kkb.mapper.TCompanyMapper;
import com.kkb.pojo.TCompany;
import com.kkb.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyServiceImpl implements CompanyService {
    @Autowired
    private TCompanyMapper companyMapper;

    @Override
    public List<TCompany> findAllList() {
        List<TCompany> companyList = companyMapper.selectListAll();
        return companyList;
    }
}
