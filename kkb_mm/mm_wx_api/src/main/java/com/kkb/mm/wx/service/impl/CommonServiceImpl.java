package com.kkb.mm.wx.service.impl;

import com.kkb.mapper.TDictMapper;
import com.kkb.mm.wx.service.CommonService;
import com.kkb.pojo.TDict;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommonServiceImpl implements CommonService {
    @Autowired
    private TDictMapper dictMapper;

    @Override
    public TDict findDictByCityName(String cityName) {
        return dictMapper.selectByCityName(cityName);
    }

    @Override
    public List<TDict> findDictListByFs(Integer fs) {
        return dictMapper.selectCityListByTag(fs);
    }
}
