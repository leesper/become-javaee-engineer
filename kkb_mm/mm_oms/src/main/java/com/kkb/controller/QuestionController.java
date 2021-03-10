package com.kkb.controller;

import com.kkb.page.QueryPageBean;
import com.kkb.page.TableDataInfo;
import com.kkb.pojo.TQuestion;
import com.kkb.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class QuestionController extends BaseController{
    @Autowired
    private QuestionService questionService;

    @PostMapping("question/findListByPage")
    @ResponseBody
    public TableDataInfo findListByPage(@RequestBody QueryPageBean queryPageBean) {
        try {
            List<TQuestion> questions = questionService.findListByPage(queryPageBean);
            return getDataTable(questions);
        } catch (Exception e) {
            logger.error(e.getMessage());
            TableDataInfo tableDataInfo = getDataTable(new ArrayList<>());
            tableDataInfo.setCode(500);
            tableDataInfo.setMsg(e.getMessage());
            return tableDataInfo;
        }
    }
}
