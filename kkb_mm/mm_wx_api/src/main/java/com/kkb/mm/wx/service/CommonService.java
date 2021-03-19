package com.kkb.mm.wx.service;

import com.kkb.pojo.TDict;

import java.util.List;

public interface CommonService {
    TDict findDictByCityName(String cityName);

    List<TDict> findDictListByFs(Integer fs);
}
