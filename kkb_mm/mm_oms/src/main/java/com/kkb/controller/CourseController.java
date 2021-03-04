package com.kkb.controller;

import com.kkb.domain.AjaxResult;
import com.kkb.page.QueryPageBean;
import com.kkb.page.TableDataInfo;
import com.kkb.pojo.TCourse;
import com.kkb.pojo.TUser;
import com.kkb.service.CourseService;
import com.kkb.utils.ServletUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;

import static com.kkb.constant.GlobalConst.SESSION_KEY_USER;

@Controller
public class CourseController extends BaseController {
    @Autowired
    private CourseService courseService;

    @PostMapping("course/add")
    @ResponseBody
    public AjaxResult addCourse(@Validated @RequestBody TCourse course) {
        try {
            course.setCreateDate(new Date());

            TUser user = getSessionUser(SESSION_KEY_USER);
            if (user != null) {
                logger.info("current user: " + user.toString());
                course.setUserId(user.getId());
            } else {
                course.setUserId(1);
            }

            int rows = courseService.addCourse(course);
            return toAjax(rows);
        } catch (Exception e) {
            logger.error("add course error: " + e.getMessage());
            return AjaxResult.error(e.getMessage());
        }
    }

    @PostMapping("course/findListByPage")
    @ResponseBody
    public TableDataInfo findListByPage(@RequestBody QueryPageBean queryPageBean) {
        List<TCourse> courses = courseService.findCourseList(queryPageBean);
        return getDataTable(courses);
    }
}
