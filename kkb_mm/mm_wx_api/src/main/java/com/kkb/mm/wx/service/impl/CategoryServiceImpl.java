package com.kkb.mm.wx.service.impl;

import com.kkb.constant.QuestionConst;
import com.kkb.mapper.TCatalogMapper;
import com.kkb.mapper.TCompanyMapper;
import com.kkb.mapper.TIndustryMapper;
import com.kkb.mm.wx.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private TCatalogMapper catalogMapper;

    @Autowired
    private TCompanyMapper companyMapper;

    @Autowired
    private TIndustryMapper industryMapper;

    @Override
    public List<Map> findCategory(Map<String, Object> data) {
        Integer categoryKind = (Integer)data.get("categoryKind");
        List<Map> mapList = new ArrayList<>();

        if (categoryKind == QuestionConst.CategoryKind.CATALOG.getId()) {
            mapList = catalogMapper.selectCategoryList(data);
        } else if (categoryKind == QuestionConst.CategoryKind.COMPANY.getId()) {
            mapList = companyMapper.selectCategoryList(data);
        } else if (categoryKind == QuestionConst.CategoryKind.INDUSTRY.getId()) {
            mapList = industryMapper.selectCategoryList(data);
        }

        return mapList;
    }
}
