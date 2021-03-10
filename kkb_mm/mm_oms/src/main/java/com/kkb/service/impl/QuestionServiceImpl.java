package com.kkb.service.impl;

import com.github.pagehelper.PageHelper;
import com.kkb.mapper.TQuestionMapper;
import com.kkb.page.QueryPageBean;
import com.kkb.pojo.TQuestion;
import com.kkb.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class QuestionServiceImpl implements QuestionService {
    @Autowired
    private TQuestionMapper questionMapper;

    @Override
    public List<TQuestion> findListByPage(QueryPageBean queryPageBean) {
        Map map = queryPageBean.getQueryParams();
        if (map == null) {
            map = new HashMap();
        }

        map.put("isClassic", 0);
        PageHelper.startPage(queryPageBean.getPageNum(), queryPageBean.getPageSize());
        List<TQuestion> questions = questionMapper.selectIsClassicByPage(map);
        return questions;
    }
}
