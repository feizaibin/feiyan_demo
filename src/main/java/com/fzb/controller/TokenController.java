package com.fzb.controller;

import com.fzb.utils.yunUtils.YunCommonUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.UnsupportedEncodingException;

@RestController
@RequestMapping("/cloud/token")
@Api(tags = "云端资源服务")
public class TokenController {

    @PostMapping("/")
    @ApiOperation(value = "获取云端资源token",produces = "application/json")
    public String getToken(String res) throws UnsupportedEncodingException {
        YunCommonUtils.setInformation("1.0.0");
        YunCommonUtils.request.putParam("grantType", "project");
        YunCommonUtils.request.putParam("res", res);
        return YunCommonUtils.outJson("/cloud/token");
    }

    @PostMapping("/refresh")
    @ApiOperation(value = "刷新云端资源token",produces = "application/json")
    public String refreshToken(String cloudToken) throws UnsupportedEncodingException {
        YunCommonUtils.setInformation("1.0.0");
        YunCommonUtils.request.putParam("cloudToken", cloudToken);
        return YunCommonUtils.outJson("/cloud/token/refresh");
    }

}
