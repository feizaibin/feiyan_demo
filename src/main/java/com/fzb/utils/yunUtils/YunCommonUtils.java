package com.fzb.utils.yunUtils;

import com.alibaba.cloudapi.sdk.model.ApiResponse;
import org.springframework.stereotype.Component;

import java.io.UnsupportedEncodingException;

@Component
public class YunCommonUtils {

    public static IoTApiClientBuilderParams ioTApiClientBuilderParams = new IoTApiClientBuilderParams();

    public static SyncApiClient syncApiClient = new SyncApiClient();

    public static IoTApiRequest request = new IoTApiRequest();

    public static void setInformation(String appKey,String appSecret,String apiVer){
        ioTApiClientBuilderParams.setAppKey(appKey);
        ioTApiClientBuilderParams.setAppSecret(appSecret);
        syncApiClient.init(ioTApiClientBuilderParams);
        request.setApiVer(apiVer);
    }

    public static String outJson(String path) throws UnsupportedEncodingException {
        ApiResponse response = syncApiClient.postBody("api.link.aliyun.com",path,request,true);
        return new String(response.getBody(),"UTF-8");
    }

}
