package com.kkb.controller;

import com.kkb.domain.AjaxResult;
import com.kkb.page.QueryPageBean;
import com.kkb.page.TableDataInfo;
import com.kkb.pojo.TQuestion;
import com.kkb.pojo.TUser;
import com.kkb.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

import static com.kkb.constant.GlobalConst.SESSION_KEY_USER;

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

    @GetMapping("questionEditor")
    public String questionEditor(int questionId, int is_classic) {
        return "pages/questionEditor";
    }

    @PostMapping("question/addOrUpdate")
    @ResponseBody
    public AjaxResult addOrUpdate(@RequestBody TQuestion question) {
        try {
            TUser user = getSessionUser(SESSION_KEY_USER);
            question.setUserId(user != null ? user.getId() : 1);
            logger.debug("Question: " + question);
            int res = questionService.addOrUpdate(question);
            return toAjax(res);
        } catch (Exception e) {
            logger.error(e.getMessage());
            return AjaxResult.error(e.getMessage());
        }
    }
}
