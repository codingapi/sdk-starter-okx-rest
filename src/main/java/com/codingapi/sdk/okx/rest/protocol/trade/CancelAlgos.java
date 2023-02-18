package com.codingapi.sdk.okx.rest.protocol.trade;

import com.alibaba.fastjson.JSONArray;
import com.codingapi.sdk.okx.rest.protocol.OkxResponse;
import lombok.*;

import java.util.List;

public class CancelAlgos {

    @Setter
    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Body{

        /**
         * 产品ID 如 BTC-USDT
         * 是否必须 是
         */
        private String instId;

        /**
         * 策略委托单ID
         * 是否必须 是
         */
        private String algoId;

    }

    @Setter
    @Getter
    public static class Request  {

        private JSONArray jsonArray = new JSONArray();

        public Request addBody(Body body){
            this.jsonArray.add(body);
            return this;
        }

        public JSONArray getParameters(){
            return jsonArray;
        }
    }

    @Setter
    @Getter
    @ToString
    public static class Data {
        private String algoId;
        private String sCode;
        private String sMsg;
    }

    public static class Response extends OkxResponse {

        public List<Data> getData() {
            return getMultiData(Data.class);
        }
    }
}
