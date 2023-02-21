package com.codingapi.sdk.okx.rest.client;

import com.alibaba.fastjson.JSON;
import com.codingapi.sdk.okx.rest.properties.OkxConfigProperties;
import com.codingapi.sdk.okx.rest.sign.OkxSigner;
import com.codingapi.springboot.framework.rest.HttpRequest;
import com.codingapi.springboot.framework.rest.Request;
import com.codingapi.springboot.framework.rest.RestClient;
import com.codingapi.springboot.framework.rest.param.RestParamBuilder;
import com.codingapi.springboot.framework.rest.properties.HttpProxyProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.util.MultiValueMap;
import org.springframework.util.StringUtils;

import java.net.URI;

@Slf4j
public class SignOkxApi {

    private final RestClient restClient;

    private final static int try_count = 5;

    private final static String EMPTY = "{}";

    private final OkxConfigProperties okxConfig;

    public SignOkxApi(HttpProxyProperties properties, OkxConfigProperties okxConfig) {
        this.okxConfig = okxConfig;
        HttpRequest.IHttpRequestHandler requestHandler = (client, uri, method, headers, httpEntity) -> {
            if (method.equals(HttpMethod.POST)) {
                String body = (String) httpEntity.getBody();
                signHeaders(headers, method.name(), URI.create(uri), body);
            }
            if (method.equals(HttpMethod.GET)) {
                signHeaders(headers, method.name(), URI.create(uri), "");
            }
            return uri;
        };
        this.restClient = new RestClient(properties, okxConfig.getApiUrl(),try_count,EMPTY,
                requestHandler,null);
    }

    private void signHeaders(HttpHeaders headers, String method, URI uri, String body) {
        headers.setContentType(MediaType.APPLICATION_JSON);
        OkxSigner signer = new OkxSigner(okxConfig.getSecretkey());

        String requestPath = uri.getPath();
        if (StringUtils.hasText(uri.getQuery())) {
            requestPath =uri.getPath()+"?"+uri.getQuery();
        }
        OkxSigner.Sign sign = signer.apiSign(method, requestPath, body);
        if (okxConfig.isMock()) {
            headers.set("x-simulated-trading", "1");
        }
        headers.set("OK-ACCESS-KEY", okxConfig.getApikey());
        headers.set("OK-ACCESS-SIGN", sign.getSign());
        headers.set("OK-ACCESS-TIMESTAMP", sign.getTimestamp());
        headers.set("OK-ACCESS-PASSPHRASE", okxConfig.getPassphrase());
    }


    public String postSign(String api, JSON jsonObject) {
        return restClient.post(api,new HttpHeaders(), jsonObject);
    }

    public String postSign(String api, RestParamBuilder restParam) {
        return postSign(api,restParam.toJsonRequest());
    }

    public String getSign(String api, MultiValueMap<String, String> uriVariables) {
        return restClient.get(api,new HttpHeaders(), uriVariables);
    }

    public String getSign(String api, RestParamBuilder restParam) {
        return getSign(api, restParam.toFormRequest());
    }

    public Request getPostSignRequest(String api, JSON jsonObject) {
        return restClient.getPostRequest(api,new HttpHeaders(), jsonObject);
    }

    public Request getPostSignRequest(String api, RestParamBuilder restParam) {
        return getPostSignRequest(api,restParam.toJsonRequest());
    }

    public Request getGetSignRequest(String api, MultiValueMap<String, String> uriVariables) {
        return restClient.getGetRequest(api,new HttpHeaders(), uriVariables);
    }

    public Request getGetSignRequest(String api, RestParamBuilder restParam) {
        return getGetSignRequest(api, restParam.toFormRequest());
    }
}
