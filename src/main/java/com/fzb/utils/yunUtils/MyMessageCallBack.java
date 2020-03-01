package com.fzb.utils.yunUtils;

import com.aliyun.openservices.iot.api.message.callback.MessageCallback;
import com.aliyun.openservices.iot.api.message.entity.MessageToken;
import com.fzb.controller.feiyan.SynDataController;
import lombok.SneakyThrows;

import java.util.concurrent.CopyOnWriteArraySet;

public class MyMessageCallBack implements MessageCallback {

    private CopyOnWriteArraySet<SynDataController> webSocketSet;

    public MyMessageCallBack(CopyOnWriteArraySet<SynDataController> webSocketSet){
        this.webSocketSet = webSocketSet;
    }

    @SneakyThrows
    @Override
    public Action consume(MessageToken messageToken) {
        String msg = "实时同步数据："+new String(messageToken.getMessage().getPayload());
        for (SynDataController item : webSocketSet) {
            item.session.getBasicRemote().sendText(msg);
        }
        return Action.CommitSuccess;
    }
}
