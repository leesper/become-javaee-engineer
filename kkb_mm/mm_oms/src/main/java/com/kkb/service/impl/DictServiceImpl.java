package com.kkb.service.impl;

import com.kkb.mapper.TDictMapper;
import com.kkb.pojo.TDict;
import com.kkb.service.DictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DictServiceImpl implements DictService {
    @Autowired
    private TDictMapper dictMapper;

    @Override
    public List<TDict> findListAll() {
        return dictMapper.selectDictSubList();
    }
}
