package com.kkb.mm.wx.service;

import com.kkb.pojo.TWxMember;

import java.util.Map;

public interface WxMemberService {
    TWxMember findByOpenId(String openid);

    int regWxMember(TWxMember member);

    int updateCityCourse(Map<String, String> data);

    Map<String, Object> findMemberCenterById(Integer id);
}
