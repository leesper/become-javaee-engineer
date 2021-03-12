package com.kkb.service.impl;

import com.kkb.mapper.TIndustryMapper;
import com.kkb.pojo.TIndustry;
import com.kkb.pojo.TIndustryExample;
import com.kkb.service.IndustryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IndustryServiceImpl implements IndustryService {
    @Autowired
    TIndustryMapper industryMapper;

    @Override
    public List<TIndustry> findListAll() {
        TIndustryExample example = new TIndustryExample();
        List<TIndustry> industries = industryMapper.selectByExample(example);
        return industries;
    }
}
