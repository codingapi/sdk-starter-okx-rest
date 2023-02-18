package com.codingapi.sdk.okx.rest.protocol.trade;

import com.codingapi.sdk.okx.rest.protocol.OkxResponse;
import com.codingapi.springboot.framework.rest.param.RestParam;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

public class ClosePosition {

    @Setter
    @Getter
    public static class Request implements RestParam {
        /**
         * 产品ID，如 BTC-USD-190927
         * 是否必须 是
         */
        private String instId;
        /**
         * 持仓方向
         * 单向持仓模式下：可不填写此参数，默认值net，如果填写，仅可以填写net
         * 双向持仓模式下： 必须填写此参数，且仅可以填写 long：平多 ，short：平空
         * 是否必须 否
         */
        private String posSide;

        /**
         *保证金模式
         * cross：全仓 ； isolated：逐仓
         * 是否必须 是
         */
        private String mgnMode;

        /**
         * 保证金币种
         * 单币种保证金模式的全仓币币杠杆平仓必填
         * 是否必须 否
         */
        private String ccy;

        /**
         * 当市价全平时，平仓单是否需要自动撤销,默认为false.
         * false：不自动撤单 true：自动撤单
         * 是否必须 否
         */
        private String autoCxl;

        /**
         * 客户自定义订单ID
         * 字母（区分大小写）与数字的组合，可以是纯字母、纯数字且长度要在1-32位之间。
         * 是否必须 否
         */
        private String clOrdId;

        /**
         * 订单标签
         * 字母（区分大小写）与数字的组合，可以是纯字母、纯数字，且长度在1-16位之间。
         * 是否必须 否
         */
        private String tag;

    }

    @Setter
    @Getter
    @ToString
    public static class Data {
        private String instId;
        private String clOrdId;
        private String posSide;
        private String tag;
    }

    public static class Response extends OkxResponse {

        public List<Data> getData() {
            return getMultiData(Data.class);
        }
    }
}
