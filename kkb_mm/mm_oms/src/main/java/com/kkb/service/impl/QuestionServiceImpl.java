package com.kkb.service.impl;

import com.github.pagehelper.PageHelper;
import com.kkb.constant.QuestionConst;
import com.kkb.mapper.*;
import com.kkb.page.QueryPageBean;
import com.kkb.pojo.*;
import com.kkb.service.QuestionService;
import com.kkb.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.kkb.constant.QuestionConst.ClassicStatus.CLASSIC_STATUS_NO;

@Service
public class QuestionServiceImpl implements QuestionService {
    @Autowired
    private TQuestionMapper questionMapper;

    @Autowired
    private TQuestionItemMapper questionItemMapper;

    @Autowired
    private TrQuestionTagMapper questionTagMapper;

    @Autowired
    private TCompanyMapper companyMapper;

    @Autowired
    TrCompanyIndustryMapper companyIndustryMapper;

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

    @Override
    @Transactional
    public int addOrUpdate(TQuestion question) {
        System.out.println("service add or update: " + question);

        // save question info
        int res = updateQuestion(question);

        // save question item info
        res = updateQuestionItem(question);
        System.out.println("updated items: " + res);

        // save relationship of question and its tags
        res = updateQuestionTag(question);
        System.out.println("updated tags: " + res);

        // update company info with its industry relationship
        res = updateCompany(question);
        System.out.println("updated industries: " + res);

        return res;
    }

    private int updateQuestion(TQuestion question) {
        question.setIsClassic(QuestionConst.ClassicStatus.CLASSIC_STATUS_NO.ordinal());
        question.setStatus(QuestionConst.Status.PRE_PUBLISH.ordinal());
        question.setReviewStatus(QuestionConst.ReviewStatus.PRE_REVIEW.ordinal());
        question.setCreateDate(new Date());
        if (question.getId() == 0) {
            int res = questionMapper.insert(question);
            System.out.println("inserted ID: " + question.getId());
            return res;
        } else {
            return questionMapper.updateByPrimaryKeySelective(question);
        }
    }

    private int updateQuestionItem(TQuestion question) {
        int i = 0;
        for (TQuestionItem questionItem : question.getQuestionItemList()) {
            questionItem.setQuestionId(question.getId());
            if (StringUtils.isNull(questionItem.getContent()) || StringUtils.isEmpty(questionItem.getContent())) {
                if (StringUtils.isNull(questionItem.getImgUrl()) || StringUtils.isEmpty(questionItem.getImgUrl())) {
                    continue;
                }
            }
            if (questionItem.getId() == 0) {
                questionItemMapper.insert(questionItem);
                i++;
            } else {
                questionItemMapper.updateByPrimaryKeySelective(questionItem);
                i++;
            }
        }
        return i;
    }

    private int updateQuestionTag(TQuestion question) {
        int i = 0;
        TrQuestionTagExample example = new TrQuestionTagExample();
        TrQuestionTagExample.Criteria criteria = example.createCriteria();
        criteria.andQuestionIdEqualTo(question.getId());
        questionTagMapper.deleteByExample(example);

        for (TTag tag : question.getTagList()) {
            TrQuestionTagKey questionTagKey = new TrQuestionTagKey();
            questionTagKey.setQuestionId(question.getId());
            questionTagKey.setTagId(tag.getId());
            questionTagMapper.insert(questionTagKey);
            i++;
        }
        return i ;
    }

    private int updateCompany(TQuestion question) {
        int i = 0;
        TCompany company = question.getCompany();
        company.setUserId(question.getUserId());
        companyMapper.updateByPrimaryKeySelective(company);

        TrCompanyIndustryExample example = new TrCompanyIndustryExample();
        TrCompanyIndustryExample.Criteria criteria = example.createCriteria();
        criteria.andCompanyIdEqualTo(company.getId());
        companyIndustryMapper.deleteByExample(example);

        for (TIndustry industry : company.getIndustryList()) {
            TrCompanyIndustryKey companyIndustryKey = new TrCompanyIndustryKey();
            companyIndustryKey.setCompanyId(company.getId());
            companyIndustryKey.setIndustryId(industry.getId());
            companyIndustryMapper.insert(companyIndustryKey);
            i++;
        }
        return i;
    }
}
