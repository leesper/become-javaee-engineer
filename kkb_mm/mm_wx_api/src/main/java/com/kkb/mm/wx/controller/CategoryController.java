package com.kkb.mm.wx.controller;

import com.kkb.controller.BaseController;
import com.kkb.domain.AjaxResult;
import com.kkb.mm.wx.service.CategoryService;
import com.kkb.mm.wx.service.WxMemberService;
import com.kkb.pojo.TWxMember;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
public class CategoryController extends BaseController {

    @Autowired
    private WxMemberService wxMemberService;

    @Autowired
    private CategoryService categoryService;

    @PostMapping("category/list")
    @ResponseBody
    public AjaxResult getCategoryList(@RequestBody Map<String, Object> data) {
        try {
            String openId = getHeaderAuthorization();
            // get memberId, cityId and courseId according to openId
            TWxMember member = wxMemberService.findByOpenId(openId);
            data.put("memberId", member.getId());
            data.put("cityId", member.getCityId());
            data.put("courseId", member.getCourseId());

            logger.debug("category/list: %s\n", data);
            List<Map> mapList = categoryService.findCategory(data);
            return AjaxResult.success(mapList);

        } catch (Exception e) {
            logger.error(e.getMessage());
            return AjaxResult.error(e.getMessage());
        }
    }

    @PostMapping("category/questions/list")
    @ResponseBody
    public AjaxResult getCategoryQuestionList(@RequestBody Map<String, Object> data) {
        try {
            String openId = getHeaderAuthorization();
            TWxMember member = wxMemberService.findByOpenId(openId);
            data.put("memberId", member.getId());
            data.put("cityId", member.getCityId());
            data.put("courseId", member.getCourseId());

            logger.debug("category/questions/list: " + data);
            Map<String, Object> result = categoryService.findCategoryQuestionList(data);
            return AjaxResult.success(result);
        } catch (Exception e) {
            logger.error(e.getMessage());
            return AjaxResult.error(e.getMessage());
        }
    }

    @PostMapping("/category/questions/commit")
    @ResponseBody
    public AjaxResult commitQuestion(@RequestBody Map<String, Object> data) {
        try {
            String openId = getHeaderAuthorization();
            TWxMember member = wxMemberService.findByOpenId(openId);
            data.put("memberId", member.getId());
            logger.debug("category/questions/commit: " + data);
            int result = categoryService.commitQuestion(data);
            return toAjax(result);
        } catch (Exception e) {
            logger.error(e.getMessage());
            return AjaxResult.error(e.getMessage());
        }
    }
}
