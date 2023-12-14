package com.codingapi.sdk.okx.rest.api;

import com.alibaba.fastjson.JSONObject;
import com.codingapi.sdk.okx.rest.client.SignOkxApi;
import com.codingapi.sdk.okx.rest.protocol.system.Status;
import com.codingapi.springboot.framework.rest.param.RestParam;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;


@Slf4j
@AllArgsConstructor
public class SystemApi {

    private final SignOkxApi signOkxApi;

    /**
     * 获取系统升级事件的状态
     * <a href="https://www.okx.com/docs-v5/zh/#rest-api-status">api</a>
     * @param request {@link Status.Request}
     * @return {@link Status.Response}
     */
    public Status.Response status(Status.Request request) {
        String data;
        if(request!=null) {
            data = signOkxApi.getSign("/api/v5/system/status", RestParam.create().add("state", request.name()));
        }else{
            data = signOkxApi.getSign("/api/v5/system/status", (RestParam) null);
        }
        log.debug("response:{}", data);
        return JSONObject.parseObject(data, Status.Response.class);
    }

    public Status.Response status() {
        return status(null);
    }
}
