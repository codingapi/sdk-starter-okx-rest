package com.codingapi.sdk.okx.rest.dto.trade;

import com.codingapi.sdk.okx.rest.dto.OkxResponse;
import com.codingapi.springboot.framework.rest.param.RestParam;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

public class OrderCancel {

    @Setter
    @Getter
    public static class Request implements RestParam {
        /**
         * 产品ID，如 BTC-USD-190927
         * 是否必须 是
         */
        private String instId;
        /**
         * 订单ID， ordId和clOrdId必须传一个，若传两个，以ordId为主
         * 是否必须 否
         */
        private String ordId;

        /**
         * 客户自定义订单ID
         * 字母（区分大小写）与数字的组合，可以是纯字母、纯数字且长度要在1-32位之间。
         * 是否必须 否
         */
        private String clOrdId;

    }

    @Setter
    @Getter
    @ToString
    public static class Data {
        private String clOrderId;
        private String ordId;
        private String sCode;
        private String sMsg;
    }

    public static class Response extends OkxResponse {

        public List<Data> getData() {
            return getMultiData(Data.class);
        }
    }
}
