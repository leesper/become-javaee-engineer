package com.kkb.controller;

import com.kkb.domain.AjaxResult;
import com.kkb.pojo.TIndustry;
import com.kkb.service.IndustryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class IndustryController extends BaseController {
    @Autowired
    private IndustryService industryService;

    @GetMapping("industry/findListAll")
    @ResponseBody
    public AjaxResult findListAll() {
        try {
            List<TIndustry> industries = industryService.findListAll();
            return AjaxResult.success(industries);
        } catch (Exception e) {
            logger.error(e.getMessage());
            return AjaxResult.error(e.getMessage());
        }
    }
}
