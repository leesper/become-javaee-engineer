package com.kkb.mm.wx.service;

import java.util.List;
import java.util.Map;

public interface CategoryService {
    List<Map> findCategory(Map<String, Object> data);
}
