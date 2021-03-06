package com.fzb.utils.yunUtils;

import com.alibaba.cloudapi.sdk.annotation.ThreadSafe;
import com.alibaba.cloudapi.sdk.client.ApacheHttpClient;
import com.alibaba.cloudapi.sdk.enums.HttpMethod;
import com.alibaba.cloudapi.sdk.enums.Scheme;
import com.alibaba.cloudapi.sdk.model.ApiRequest;
import com.alibaba.cloudapi.sdk.model.ApiResponse;
import com.alibaba.cloudapi.sdk.model.HttpClientBuilderParams;
import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Component;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.Map;

import static com.alibaba.cloudapi.sdk.enums.HttpConnectionModel.MULTIPLE_CONNECTION;

@ThreadSafe
public final class SyncApiClient extends ApacheHttpClient {

    @Override
    public void init(HttpClientBuilderParams params) {
        super.init(params);
    }

    public ApiResponse postBody(String host, String path, IoTApiRequest request, boolean isHttps,
                                Map<String, String> headers)
            throws UnsupportedEncodingException {
        byte[] body = JSONObject.toJSONString(request).getBytes("UTF-8");
        ApiRequest apiRequest = new ApiRequest(HttpMethod.POST_BODY, path,
                body);
        apiRequest.setHttpConnectionMode(MULTIPLE_CONNECTION);
        apiRequest.setScheme(isHttps ? Scheme.HTTPS : Scheme.HTTP);
        apiRequest.setHost(host);
        if (null != headers && headers.size() > 0) {
            for (Map.Entry<String, String> header : headers.entrySet()) {
                apiRequest.getHeaders().put(header.getKey(), Arrays.asList(header.getValue()));
            }
        }
        return sendSyncRequest(apiRequest);
    }

    public ApiResponse postBody(String host, String path, IoTApiRequest request, boolean isHttps)
            throws UnsupportedEncodingException {

        return postBody(host, path, request, isHttps, null);
    }

    public ApiResponse postBody(String host, String path, IoTApiRequest request)
            throws UnsupportedEncodingException {
        return postBody(host, path, request, false, null);
    }

}