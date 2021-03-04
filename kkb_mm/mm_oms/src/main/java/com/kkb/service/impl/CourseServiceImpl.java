package com.kkb.service.impl;

import com.github.pagehelper.PageHelper;
import com.kkb.mapper.TCourseMapper;
import com.kkb.page.QueryPageBean;
import com.kkb.pojo.TCourse;
import com.kkb.pojo.TCourseExample;
import com.kkb.service.CourseService;
import com.kkb.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class CourseServiceImpl implements CourseService {
    @Autowired
    private TCourseMapper courseMapper;

    @Override
    public int addCourse(TCourse course) {
        return courseMapper.insert(course);
    }

    @Override
    public List<TCourse> findCourseList(QueryPageBean queryPageBean) {
        TCourseExample example = new TCourseExample();
        TCourseExample.Criteria criteria = example.createCriteria();

        Map params = queryPageBean.getQueryParams();
        if (params != null) {
            if (StringUtils.isNotNull(params.get("name"))) {
                criteria.andNameLike("%" + params.get("name") + "%");
            }
            if (StringUtils.isNotNull(params.get("status"))) {
                criteria.andIsShowEqualTo((Integer) params.get("status"));
            }
        }

        PageHelper.startPage(queryPageBean.getPageNum(), queryPageBean.getPageSize());
        return courseMapper.selectByExample(example);
    }
}
