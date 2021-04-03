package com.kkb.mm.wx.controller;

import com.alibaba.fastjson.JSONObject;
import com.kkb.constant.GlobalConst;
import com.kkb.controller.BaseController;
import com.kkb.domain.AjaxResult;
import com.kkb.mm.wx.service.WxMemberService;
import com.kkb.mm.wx.utils.WxUtil;
import com.kkb.pojo.TWxMember;
import com.kkb.utils.ServletUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Controller
public class WxMemberController extends BaseController {
    @Autowired
    private WxMemberService wxMemberService;

    @PostMapping("member/login")
    @ResponseBody
    public AjaxResult login(@RequestBody Map<String, String> data) {
        try {
            logger.debug("data: " + data);
            String code = data.get("code");
            String encryptedData = data.get("encryptedData");
            String iv = data.get("iv");

            JSONObject jsonObject = WxUtil.get(code);
            String openid = jsonObject.getString("openid");
            logger.info("OPENID: " + openid);
            String sessionKey = jsonObject.getString("session_key");

            TWxMember member = wxMemberService.findByOpenId(openid);
            if (member == null) {
                // need to register
                member = new TWxMember();
                // decrypted wx info
                JSONObject userInfo = WxUtil.getUserInfo(encryptedData, sessionKey, iv);
                logger.debug("userInfo: " + userInfo);
                member.setNickName(userInfo.getString("nickName"));
                member.setAvatarUrl(userInfo.getString("avatarUrl"));
                member.setGender(userInfo.getString("gender"));
                member.setCity(userInfo.getString("city"));
                member.setProvince(userInfo.getString("province"));
                member.setCountry(userInfo.getString("country"));
                member.setLanguage(userInfo.getString("language"));
                member.setOpenId(userInfo.getString("openId"));
                member.setCreateTime(new Date());

                logger.debug("register user: " + member);
                wxMemberService.regWxMember(member);
            }

            Map map = new HashMap<>();
            map.put("token", openid);
            map.put("userInfo", member);

            return AjaxResult.success(map);
        } catch (Exception e) {
            logger.error(e.getMessage());
            return AjaxResult.error(e.getMessage());
        }
    }

    @PostMapping("member/setCityCourse")
    @ResponseBody
    public AjaxResult setCityCourse(@RequestBody Map<String, String> data) {
        try {
            HttpServletRequest request = ServletUtils.getRequest();
            String openId = request.getHeader(GlobalConst.HEADER_AUTHORIZATION);
            data.put("openId", openId);
            logger.debug("data: " + data);
            int result = wxMemberService.updateCityCourse(data);
            return toAjax(result);
        } catch (Exception e) {
            logger.error(e.getMessage());
            return AjaxResult.error(e.getMessage());
        }
    }
}
