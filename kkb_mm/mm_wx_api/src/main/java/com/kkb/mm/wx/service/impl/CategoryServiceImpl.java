package com.kkb.mm.wx.service.impl;

import com.alibaba.fastjson.JSON;
import com.kkb.constant.QuestionConst;
import com.kkb.mapper.*;
import com.kkb.mm.wx.service.CategoryService;
import com.kkb.pojo.TQuestionForWx;
import com.kkb.pojo.TrMemberQuestion;
import com.kkb.pojo.TrMemberQuestionExample;
import com.kkb.utils.StringUtils;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private TCatalogMapper catalogMapper;

    @Autowired
    private TCompanyMapper companyMapper;

    @Autowired
    private TIndustryMapper industryMapper;

    @Autowired
    private TQuestionForWxMapper questionForWxMapper;

    @Autowired
    private TrMemberQuestionMapper memberQuestionMapper;

    @Autowired
    private TWxMemberMapper wxMemberMapper;

    @Override
    public List<Map> findCategory(Map<String, Object> data) {
        Integer categoryKind = (Integer)data.get("categoryKind");
        List<Map> mapList = new ArrayList<>();

        if (categoryKind == QuestionConst.CategoryKind.CATALOG.getId()) {
            mapList = catalogMapper.selectCategoryList(data);
        } else if (categoryKind == QuestionConst.CategoryKind.COMPANY.getId()) {
            mapList = companyMapper.selectCategoryList(data);
        } else if (categoryKind == QuestionConst.CategoryKind.INDUSTRY.getId()) {
            mapList = industryMapper.selectCategoryList(data);
        }

        return mapList;
    }

    @Override
    public Map<String, Object> findCategoryQuestionList(Map<String, Object> data) {
        Integer categoryKind = (Integer) data.get("categoryKind");
        Map result = null;
        System.out.println("DATA: " + data);
        if (categoryKind == QuestionConst.CategoryKind.CATALOG.getId()) {
            // get basic info of catalog
            List<Map> mapList = catalogMapper.selectCategoryList(data);
            if (StringUtils.isNotNull(mapList) && StringUtils.isNotEmpty(mapList)) {
                result = mapList.get(0);
            }
            // get question list from catalog
            List<TQuestionForWx> questionForWxList = questionForWxMapper.selectQuestionByQueryParams(data);
            result.put("items", questionForWxList);
        } else if (categoryKind == QuestionConst.CategoryKind.COMPANY.getId()) {
            // get basic info of company
            List<Map> mapList = companyMapper.selectCategoryList(data);
            if (StringUtils.isNotNull(mapList) && StringUtils.isNotEmpty(mapList)) {
                result = mapList.get(0);
            }
            // get question list from company
            List<TQuestionForWx> questionForWxList = questionForWxMapper.selectQuestionByQueryParams(data);
            result.put("items", questionForWxList);
        } else if (categoryKind == QuestionConst.CategoryKind.INDUSTRY.getId()) {
            // get basic info of industry
            List<Map> mapList = industryMapper.selectCategoryList(data);
            if (StringUtils.isNotNull(mapList) && StringUtils.isNotEmpty(mapList)) {
                result = mapList.get(0);
            }
            // get question list from industry
            List<TQuestionForWx> questionForWxList = questionForWxMapper.selectQuestionByIndustry(data);
            result.put("items", questionForWxList);
        }
        return result;
    }

    @Override
    public int commitQuestion(Map<String, Object> data) {
        TrMemberQuestion memberQuestion = new TrMemberQuestion();
        Integer type = (Integer) data.get("type");
        // 单选或多选
        Boolean answerIsRight = (Boolean) data.get("answerIsRight");
        if (type == QuestionConst.Type.SINGLE.getId() || type == QuestionConst.Type.MULTIPLE.getId()) {
            if (answerIsRight) {
                memberQuestion.setTag(QuestionConst.AnswerTag.PERFECT.ordinal());
            } else {
                memberQuestion.setTag(QuestionConst.AnswerTag.WRONG.ordinal());
            }
            String answerResult = JSON.toJSONString(data.get(data.get("answerResult")));
            memberQuestion.setAnswerresult(answerResult);
        } else if (type == QuestionConst.Type.SIMPLE.getId()){
            if (answerIsRight) {
                memberQuestion.setTag(QuestionConst.AnswerTag.GOOD.ordinal());
            } else {
                memberQuestion.setTag(QuestionConst.AnswerTag.BAD.ordinal());
            }
        }

        if (data.get("isFavorite") != null) {
            Boolean isFavorite = (Boolean) data.get("isFavorite");
            memberQuestion.setIsFavorite(isFavorite ? 1 : 0);
        } else {
            memberQuestion.setIsFavorite(0);
        }
        Integer memberId = (Integer) data.get("memberId");
        Integer questionId = (Integer) data.get("id");

        TrMemberQuestionExample example = new TrMemberQuestionExample();
        TrMemberQuestionExample.Criteria criteria = example.createCriteria();
        criteria.andMemberIdEqualTo(memberId);
        criteria.andQuestionIdEqualTo(questionId);
        int result = memberQuestionMapper.updateByExampleSelective(memberQuestion, example);
        if (result == 0) {
            memberQuestion.setMemberId(memberId);
            memberQuestion.setQuestionId(questionId);
            result = memberQuestionMapper.insert(memberQuestion);
        }

        // update member info
        wxMemberMapper.updateMemberLastAnswer(data);

        return result;
    }
}
