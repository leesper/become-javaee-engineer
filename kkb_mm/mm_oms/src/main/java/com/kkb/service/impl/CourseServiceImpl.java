package com.kkb.service.impl;

import com.kkb.mapper.TCourseMapper;
import com.kkb.pojo.TCourse;
import com.kkb.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseServiceImpl implements CourseService {
    @Autowired
    private TCourseMapper courseMapper;

    @Override
    public int addCourse(TCourse course) {
        return courseMapper.insert(course);
    }
}
