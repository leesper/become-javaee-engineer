package com.kkb.mapper;

import com.kkb.pojo.TQuestionForWx;

import java.util.List;
import java.util.Map;

public interface TQuestionForWxMapper {
    List<TQuestionForWx> selectQuestionByQueryParams(Map<String, Object> data);
}