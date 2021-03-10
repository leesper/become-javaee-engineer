package com.kkb.service;

import com.kkb.page.QueryPageBean;
import com.kkb.pojo.TQuestion;

import java.util.List;

public interface QuestionService {
    List<TQuestion> findListByPage(QueryPageBean queryPageBean);
}
