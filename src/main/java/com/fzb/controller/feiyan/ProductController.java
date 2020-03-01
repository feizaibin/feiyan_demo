package com.fzb.controller.feiyan;

import com.fzb.entity.User;
import com.fzb.service.UserService;
import com.fzb.utils.yunUtils.YunCommonUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.UnsupportedEncodingException;

@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    UserService userService;

    @RequestMapping("/toPage")
    public String toPage(){
        return "main/product";
    }

    @RequestMapping("/getProductList")
    public String getProductList(String uname, String cloudToken, int pageNo, int pageSize, Model model) throws UnsupportedEncodingException {
        User user = userService.findUserByName(uname);
        YunCommonUtils.setInformation(user.getCld_app_key(),user.getCld_app_secret(),"1.1.0");
        YunCommonUtils.request.setCloudToken(cloudToken);
        YunCommonUtils.request.putParam("pageNo", pageNo);
        YunCommonUtils.request.putParam("pageSize", pageSize);
        String getProductListMsg = YunCommonUtils.outJson("/cloud/thing/productList/get");
        model.addAttribute("getProductListMsg",getProductListMsg);
        return "main/product";
    }

    @RequestMapping("/getProduct")
    public String getProduct(String uname, String cloudToken,String productKey, Model model) throws UnsupportedEncodingException {
        User user = userService.findUserByName(uname);
        YunCommonUtils.setInformation(user.getCld_app_key(),user.getCld_app_secret(),"1.1.0");
        YunCommonUtils.request.setCloudToken(cloudToken);
        YunCommonUtils.request.putParam("productKey", productKey);
        String getProductMsg = YunCommonUtils.outJson("/cloud/thing/product/get");
        model.addAttribute("getProductMsg",getProductMsg);
        return "main/product";
    }

}
