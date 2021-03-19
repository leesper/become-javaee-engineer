package com.kkb.mm.wx.controller;

import com.kkb.controller.BaseController;
import com.kkb.domain.AjaxResult;
import com.kkb.mm.wx.service.CommonService;
import com.kkb.mm.wx.utils.LocationUtil;
import com.kkb.pojo.TDict;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class CommonController extends BaseController {
    @Autowired
    private CommonService commonService;

    @PostMapping("commons/cities")
    @ResponseBody
    public AjaxResult getCities(@RequestBody Map data) {
        try {
            logger.debug("data: " + data);
            String cityName = LocationUtil.parseLocation((String) data.get("location"));

            TDict dict = commonService.findDictByCityName(cityName);

            List<TDict> cityList = commonService.findDictListByFs((Integer) data.get("fs"));

            Map result = new HashMap();
            result.put("location", dict);
            result.put("cities", cityList);
            return AjaxResult.success(result);
        } catch (Exception e) {
            logger.error(e.getMessage());
            return AjaxResult.error(e.getMessage());
        }
    }
}
