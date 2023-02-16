package com.codingapi.sdk.okx.rest.api;


import com.alibaba.fastjson.JSONObject;
import com.codingapi.sdk.okx.rest.client.SignOkxApi;
import com.codingapi.sdk.okx.rest.dto.pub.ConvertContractCoin;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@AllArgsConstructor
public class PublicApi {

    private final SignOkxApi signOkxApi;

    /**
     *  张币转换
     *  <a href="https://www.okx.com/docs-v5/zh/#rest-api-public-data-get-unit-convert"></a>
     */
    public ConvertContractCoin.Response convertContractCoin(ConvertContractCoin.Request request){
        String data = signOkxApi.getSign("/api/v5/public/convert-contract-coin",request.getParameters());
        log.debug("response:{}", data);
        return JSONObject.parseObject(data, ConvertContractCoin.Response.class);
    }
}
