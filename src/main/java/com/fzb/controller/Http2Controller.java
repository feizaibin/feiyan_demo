package com.fzb.controller;

import com.aliyun.openservices.iot.api.Profile;
import com.aliyun.openservices.iot.api.message.MessageClientFactory;
import com.aliyun.openservices.iot.api.message.api.MessageClient;
import com.aliyun.openservices.iot.api.message.callback.MessageCallback;
import com.aliyun.openservices.iot.api.message.entity.MessageToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.UnsupportedEncodingException;

@RestController
@RequestMapping("/http2")
public class Http2Controller {

    @PostMapping("/")
    public String connect(String appKey,String appSecret) throws UnsupportedEncodingException {
        Profile profile = Profile.getAppKeyProfile("https://ilop.iot-as-http2.cn-shanghai.aliyuncs.com:443", appKey, appSecret);
        MessageClient messageClient = MessageClientFactory.messageClient(profile);
        MessageCallback messageCallback = new MessageCallback() {
            public Action consume(MessageToken messageToken) {
                System.out.println("receive : " + new String(messageToken.getMessage().getPayload()));
                return Action.CommitSuccess;
            }
        };
        messageClient.setMessageListener(messageCallback);
        messageClient.connect(messageCallback);
        return "success";
    }

}
