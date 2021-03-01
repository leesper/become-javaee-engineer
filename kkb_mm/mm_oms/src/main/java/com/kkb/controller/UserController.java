package com.kkb.controller;

import com.kkb.domain.AjaxResult;
import com.kkb.pojo.TUser;
import com.kkb.service.UserService;
import com.kkb.utils.ServletUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import static com.kkb.constant.GlobalConst.SESSION_KEY_USER;

@Controller
public class UserController extends BaseController {
    @Autowired
    UserService userService;

    @PostMapping("user/login")
    @ResponseBody
    public AjaxResult login(@Validated @RequestBody TUser loginForm) {
        try {
            TUser user = userService.findByUserName(loginForm.getUsername());
            if (user == null) {
                return AjaxResult.error("user not found");
            }
            if (!user.getPassword().equals(loginForm.getPassword())) {
                return AjaxResult.error("incorrect password");
            }
            ServletUtils.getSession().setAttribute(SESSION_KEY_USER, user);
            return AjaxResult.success("login success");
        } catch (Exception e) {
            logger.error("error: " + e.getMessage());
            return AjaxResult.error(e.getMessage());
        }
    }
}
