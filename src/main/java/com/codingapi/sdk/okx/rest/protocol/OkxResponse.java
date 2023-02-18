package com.codingapi.sdk.okx.rest.protocol;

import com.alibaba.fastjson.JSONObject;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@ToString
public class OkxResponse {

    @Setter
    @Getter
    private String code;
    @Setter
    @Getter
    private String msg;

    @Setter
    private String data;

    public <T> T getSingleData(Class<T> clazz) {
        return JSONObject.parseObject(data, clazz);
    }

    public <T> List<T> getMultiData(Class<T> clazz) {
        return JSONObject.parseArray(data, clazz);
    }


    public boolean isSuccess() {
        return "0".equals(code);
    }
}
