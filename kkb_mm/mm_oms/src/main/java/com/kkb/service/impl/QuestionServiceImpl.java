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

import java.util.*;

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
    private TrCompanyIndustryMapper companyIndustryMapper;

    @Autowired
    private TReviewLogMapper reviewLogMapper;

    @Autowired
    private TCatalogMapper catalogMapper;

    @Autowired
    private TTagMapper tagMapper;

    @Autowired
    private TIndustryMapper industryMapper;

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

    @Override
    public List<TQuestion> findClassicByPage(QueryPageBean queryPageBean) {
        Map params = queryPageBean.getQueryParams();
        if (params == null) {
            params = new HashMap();
        }

        params.put("isClassic", 1);
        PageHelper.startPage(queryPageBean.getPageNum(), queryPageBean.getPageSize());
        List<TQuestion> questionList = questionMapper.selectIsClassicByPage(params);

        for(TQuestion question : questionList) {
            TReviewLog reviewLog = reviewLogMapper.selectLastByQuestionId(question.getId());
            if (StringUtils.isNull(reviewLog)) {
                reviewLog = new TReviewLog();
                reviewLog.setStatus(QuestionConst.ReviewStatus.PRE_REVIEW.ordinal());
                reviewLog.setComments("");
                reviewLog.setReviewer("");
                reviewLog.setCreateDate(null);
            }
            question.setReviewLog(reviewLog);
        }
        return questionList;
    }

    @Override
    public TQuestion findById(int questionId) {
        System.out.println("question id: " + questionId);

        // query question basic info with its options
        TQuestion question = questionMapper.selectById(questionId);

        // query course with its catalog
        initQuestionCatalog(question);

        // query tags
        initQuestionTag(question);

        // query company info
        initQuestionCompany(question);

        return question;
    }

    @Override
    @Transactional
    public int deleteById(int questionId) {
        TQuestion question = questionMapper.selectById(questionId);
        deleteQuestionItems(question);
        deleteQuestionTag(question);
        deleteQuestionReview(question);
        int res = questionMapper.deleteByPrimaryKey(questionId);
        return res;
    }

    @Override
    public int updateById(int questionId) {
        TQuestion question = questionMapper.selectByPrimaryKey(questionId);

        if (QuestionConst.Status.PRE_PUBLISH.ordinal() == question.getStatus()) {
            return 0;
        }

        question.setStatus(QuestionConst.Status.PUBLISHED_OFFLINE.ordinal());
        question.setReviewStatus(QuestionConst.ReviewStatus.REVIEWED.ordinal());
        int res = questionMapper.updateByPrimaryKeySelective(question);
        return res;
    }

    private void deleteQuestionReview(TQuestion question) {
        TReviewLogExample example = new TReviewLogExample();
        TReviewLogExample.Criteria criteria = example.createCriteria();
        criteria.andQuestionIdEqualTo(question.getId());

        reviewLogMapper.deleteByExample(example);
    }

    private void deleteQuestionItems(TQuestion question) {
        for (TQuestionItem item : question.getQuestionItemList()) {
            questionItemMapper.deleteByPrimaryKey(item.getId());
        }
    }

    private void deleteQuestionTag(TQuestion question) {
        TrQuestionTagExample example = new TrQuestionTagExample();
        TrQuestionTagExample.Criteria criteria = example.createCriteria();
        criteria.andQuestionIdEqualTo(question.getId());

        questionTagMapper.deleteByExample(example);
    }

    private void initQuestionCatalog(TQuestion question) {
        TCatalog catalog = catalogMapper.selectByPrimaryKey(question.getCatalogId());
        question.setCatalog(catalog);
    }

    private void initQuestionTag(TQuestion question) {
        List<TTag> tags = tagMapper.selectTagListByQuestionId(question.getId());
        question.setTagList(tags);
        List<String> tagNameList = new ArrayList<>();
        for (TTag tag: tags) {
            tagNameList.add(tag.getName());
        }
        question.setTagNameList(tagNameList);
    }

    private void initQuestionCompany(TQuestion question) {
        TCompany company = companyMapper.selectByIdForQuestion(question.getCompanyId());
        List<TIndustry> industries = industryMapper.selectIndustryListByCompany(question.getCompanyId());
        List<String> industryNameList = new ArrayList<>();
        for (TIndustry industry : industries) {
            industryNameList.add(industry.getName());
        }
        company.setIndustryList(industries);
        company.setIndustryNameList(industryNameList);
        question.setCompany(company);
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
