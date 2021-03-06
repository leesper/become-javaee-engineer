package com.kkb.mm.wx.service.impl;

import com.kkb.mapper.TWxMemberMapper;
import com.kkb.mm.wx.service.WxMemberService;
import com.kkb.pojo.TWxMember;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class WxMemberServiceImpl implements WxMemberService {
    @Autowired
    private TWxMemberMapper wxMemberMapper;

    @Override
    public TWxMember findByOpenId(String openid) {
        return wxMemberMapper.selectByOpenId(openid);
    }

    @Override
    public int regWxMember(TWxMember member) {
        return wxMemberMapper.insert(member);
    }

    @Override
    public int updateCityCourse(Map<String, String> data) {
        return wxMemberMapper.updateCityCourse(data);
    }

    @Override
    public Map<String, Object> findMemberCenterById(Integer id) {
        Map<String, Object> result = wxMemberMapper.selectMemberCenterById(id);
        String categoryTitle = wxMemberMapper.selectCategoryTitleByCategory((Integer) result.get("categoryKind"),
                (Integer) result.get("categoryID"));
        result.put("categoryTitle", categoryTitle);
        return result;
    }
}
