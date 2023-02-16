package com.codingapi.sdk.okx.rest.dto.trade;

import com.codingapi.sdk.okx.rest.dto.OkxResponse;
import com.codingapi.springboot.framework.rest.param.RestParam;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

public class OrderAmend {

    @Setter
    @Getter
    public static class Request implements RestParam {
        /**
         * 产品ID，如 BTC-USD-190927
         * 是否必须 是
         */
        private String instId;

        /**
         * false：不自动撤单 true：自动撤单 当订单修改失败时，该订单是否需要自动撤销。默认为false
         * 是否必须 否
         */
        private Boolean cxlOnFail;

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
        /**
         * 用户自定义修改事件ID
         * 字母（区分大小写）与数字的组合，可以是纯字母、纯数字且长度要在1-32位之间。
         * 是否必须 否
         */
        private String reqId;

        /**
         * 修改的新数量，newSz和newPx不可同时为空。对于部分成交订单，该数量应包含已成交数量。
         * 是否必须 否
         */
        private String newSz;

        /**
         * 修改的新价格
         * 是否必须 否
         */
        private String newPx;

    }

    @Setter
    @Getter
    @ToString
    public static class Data {
        private String clOrderId;
        private String ordId;
        private String sCode;
        private String reqId;
        private String sMsg;
    }

    public static class Response extends OkxResponse {

        public List<Data> getData() {
            return getMultiData(Data.class);
        }
    }
}
