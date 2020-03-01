package com.fzb.controller.feiyan;

import com.fzb.entity.User;
import com.fzb.service.UserService;
import com.fzb.utils.yunUtils.YunCommonUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.UnsupportedEncodingException;

@Controller
@RequestMapping("/token")
public class TokenController {

    @Autowired
    UserService userService;

    @RequestMapping("/toPage")
    public String toPage(){
        return "main/token";
    }

    @RequestMapping("/get")
    public String getToken(String uname,String res) throws UnsupportedEncodingException {
        User user = userService.findUserByName(uname);
        YunCommonUtils.setInformation(user.getCld_app_key(),user.getCld_app_secret(),"1.0.0");
        YunCommonUtils.request.putParam("grantType", "project");
        YunCommonUtils.request.putParam("res", res);
        String tokenBackMsg = YunCommonUtils.outJson("/cloud/token");
        Subject currentSubject = SecurityUtils.getSubject();
        Session session = currentSubject.getSession();
        session.setAttribute("tokenBackMsg",tokenBackMsg);
        return "redirect:/token/toPage";
    }

    @RequestMapping("/refresh")
    public String refreshToken(String uname,String cloudToken) throws UnsupportedEncodingException {
        User user = userService.findUserByName(uname);
        YunCommonUtils.setInformation(user.getCld_app_key(),user.getCld_app_secret(),"1.0.0");
        YunCommonUtils.request.setCloudToken(cloudToken);
        YunCommonUtils.request.putParam("cloudToken", cloudToken);
        String tokenBackMsg = YunCommonUtils.outJson("/cloud/token/refresh");
        Subject currentSubject = SecurityUtils.getSubject();
        Session session = currentSubject.getSession();
        session.setAttribute("tokenBackMsg",tokenBackMsg);
        return "redirect:/token/toPage";
    }

}
