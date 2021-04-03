package com.kkb.mm.wx.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.kkb.constant.GlobalConst;
import com.kkb.controller.BaseController;
import com.kkb.domain.AjaxResult;
import com.kkb.mm.wx.service.CommonService;
import com.kkb.mm.wx.utils.LocationUtil;
import com.kkb.pojo.TCourse;
import com.kkb.pojo.TDict;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
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
    @Autowired
    private StringRedisTemplate redisTemplate;

    @PostMapping("commons/cities")
    @ResponseBody
    public AjaxResult getCities(@RequestBody Map data) {
        try {
            logger.debug("data: " + data);
            String cityName = LocationUtil.parseLocation((String) data.get("location"));

            TDict dict = commonService.findDictByCityName(cityName);

            String jsonString = redisTemplate.opsForValue().get(GlobalConst.REDIS_KEY_WX_CITY_LIST);
            List<TDict> cityList = null;
            if (jsonString != null && !jsonString.equals("")) {
                logger.debug("get from redis: " + jsonString);
                cityList = JSON.parseArray(jsonString, TDict.class);
            } else {
                cityList = commonService.findDictListByFs((Integer) data.get("fs"));
                redisTemplate.opsForValue().set(GlobalConst.REDIS_KEY_WX_CITY_LIST, JSON.toJSONString(cityList));
            }

            Map result = new HashMap();
            result.put("location", dict);
            result.put("cities", cityList);
            return AjaxResult.success(result);
        } catch (Exception e) {
            logger.error(e.getMessage());
            return AjaxResult.error(e.getMessage());
        }
    }

    @GetMapping("commons/courseList")
    @ResponseBody
    public AjaxResult getCourseList() {
        try {
            String jsonString = redisTemplate.opsForValue().get(GlobalConst.REDIS_KEY_WX_COURSE_LIST);
            if (jsonString != null && !jsonString.equals("")) {
                logger.debug("get from redis: " + jsonString);
                JSONArray jsonArray = JSON.parseArray(jsonString);
                return AjaxResult.success(jsonArray);
            }
            List<TCourse> courseList = commonService.getCourseList();
            redisTemplate.opsForValue().set(GlobalConst.REDIS_KEY_WX_COURSE_LIST, JSON.toJSONString(courseList));
            return AjaxResult.success(courseList);
        } catch (Exception e) {
            logger.error(e.getMessage());
            return AjaxResult.error(e.getMessage());
        }
    }
}
