package com.kkb.controller;

import com.kkb.domain.AjaxResult;
import com.kkb.pojo.TDict;
import com.kkb.service.DictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class DictController extends BaseController {
    @Autowired
    private DictService dictService;

    @GetMapping("dict/findListAll")
    @ResponseBody
    public AjaxResult findListAll() {
        try {
            List<TDict> dicts = dictService.findListAll();
            return AjaxResult.success(dicts);
        } catch (Exception e) {
            logger.error(e.getMessage());
            return AjaxResult.error(e.getMessage());
        }
    }
}
