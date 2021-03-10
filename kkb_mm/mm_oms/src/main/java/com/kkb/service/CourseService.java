package com.kkb.service;

import com.kkb.page.QueryPageBean;
import com.kkb.pojo.TCourse;

import java.util.List;

public interface CourseService {
    int addCourse(TCourse course);

    List<TCourse> findCourseList(QueryPageBean queryPageBean);

    int updateCourse(TCourse course);

    int deleteCourse(TCourse course);

    List<TCourse> findListAll();
}
