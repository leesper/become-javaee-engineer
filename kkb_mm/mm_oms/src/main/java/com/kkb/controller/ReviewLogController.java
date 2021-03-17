package com.kkb.controller;

import com.kkb.domain.AjaxResult;
import com.kkb.pojo.TReviewLog;
import com.kkb.pojo.TUser;
import com.kkb.service.ReviewLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

import static com.kkb.constant.GlobalConst.SESSION_KEY_USER;

@Controller
public class ReviewLogController extends BaseController {
    @Autowired
    private ReviewLogService reviewLogService;

    @PostMapping("review/add")
    @ResponseBody
    public AjaxResult addReview(@Validated @RequestBody TReviewLog reviewLog) {
        try {
            TUser user = getSessionUser(SESSION_KEY_USER);
            reviewLog.setUserId(user != null ? user.getId() : 1);
            reviewLog.setCreateDate(new Date());
            int res = reviewLogService.addReview(reviewLog);
            return toAjax(res);
        } catch (Exception e) {
            logger.error(e.getMessage());
            return AjaxResult.error(e.getMessage());
        }
    }
}
