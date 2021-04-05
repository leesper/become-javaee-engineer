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

            logger.debug("category/list", data);
            List<Map> mapList = categoryService.findCategory(data);
            return AjaxResult.success(mapList);

        } catch (Exception e) {
            logger.error(e.getMessage());
            return AjaxResult.error(e.getMessage());
        }
    }
}
