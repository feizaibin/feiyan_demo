package com.fzb.controller.feiyan;

import com.aliyun.openservices.iot.api.Profile;
import com.aliyun.openservices.iot.api.message.MessageClientFactory;
import com.aliyun.openservices.iot.api.message.api.MessageClient;
import com.fzb.entity.User;
import com.fzb.service.UserService;
import com.fzb.utils.yunUtils.MyMessageCallBack;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import java.util.concurrent.CopyOnWriteArraySet;

@ServerEndpoint(value = "/websocket")
@Controller
@RequestMapping("/synData")
public class SynDataController{

    @Autowired
    UserService userService;

    private static String syn_app_key;
    private static String syn_app_secret;

    //用来存放每个客户端对应的MyWebSocket对象。
    private static CopyOnWriteArraySet<SynDataController> webSocketSet = new CopyOnWriteArraySet<SynDataController>();

    //与某个客户端的连接会话，需要通过它来给客户端发送数据
    public Session session;

    private MessageClient messageClient;

    /**
     * 连接建立成功调用的方法
     */
    @OnOpen
    public void onOpen(Session session) {
        this.session = session;
        webSocketSet.add(this);//加入set中
        Profile profile = Profile.getAppKeyProfile("https://ilop.iot-as-http2.cn-shanghai.aliyuncs.com:443", syn_app_key, syn_app_secret);
        messageClient = MessageClientFactory.messageClient(profile);
        MyMessageCallBack myMessageCallBack = new MyMessageCallBack(webSocketSet);
        messageClient.setMessageListener(myMessageCallBack);
        messageClient.connect(myMessageCallBack);

        this.session.getAsyncRemote().sendText("成功建立连接");
    }

    /**
     * 连接关闭调用的方法
     */
    @OnClose
    public void onClose() {
        messageClient.disconnect();
        webSocketSet.remove(this);  //从set中删除
    }
    /**
     * 发生错误时调用
     */
    @OnError
    public void onError(Session session, Throwable error) {
        System.out.println("发生错误");
        error.printStackTrace();
    }

    @RequestMapping("/toPage/{uname}")
    public String toPage(@PathVariable("uname") String uname){
        User user = userService.findUserByName(uname);
        syn_app_key = user.getSyn_app_key();
        syn_app_secret = user.getSyn_app_secret();
        return "main/synData";
    }
}
