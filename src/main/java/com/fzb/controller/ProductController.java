package com.fzb.controller;

import com.fzb.utils.yunUtils.YunCommonUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.UnsupportedEncodingException;

@RestController
@RequestMapping("/cloud/product")
@Api(tags = "产品管理服务")
public class ProductController {

    @PostMapping("/productList/get")
    @ApiOperation(value = "查询项目下的产品列表",produces = "application/json")
    public String getProductList(String cloudToken,int pageNo,int pageSize) throws UnsupportedEncodingException {
        YunCommonUtils.setInformation("1.1.0");
        YunCommonUtils.request.setCloudToken(cloudToken);
        YunCommonUtils.request.putParam("pageNo", pageNo);
        YunCommonUtils.request.putParam("pageSize", pageSize);
        return YunCommonUtils.outJson("/cloud/thing/productList/get");
    }

    @PostMapping("/product/get")
    @ApiOperation(value = "查询单个产品",produces = "application/json")
    public String getProduct(String cloudToken,String productKey) throws UnsupportedEncodingException {
        System.out.println(YunCommonUtils.request.getVersion());
        YunCommonUtils.setInformation("1.1.0");
        System.out.println(YunCommonUtils.request.getVersion());
        YunCommonUtils.request.setCloudToken(cloudToken);
        YunCommonUtils.request.putParam("productKey", productKey);
        return YunCommonUtils.outJson("/cloud/thing/product/get");
    }

}
