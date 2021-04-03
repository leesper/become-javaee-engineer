package com.kkb.mm.wx.service;

import com.kkb.pojo.TWxMember;

public interface WxMemberService {
    TWxMember findByOpenId(String openid);

    int regWxMember(TWxMember member);
}
