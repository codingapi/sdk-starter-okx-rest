package com.codingapi.sdk.okx.rest.protocol.trade;

import com.codingapi.sdk.okx.rest.protocol.OkxResponse;
import com.codingapi.springboot.framework.rest.param.RestParam;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

public class Order {

    @Setter
    @Getter
    public static class Request implements RestParam {
        /**
         * 产品ID，如 BTC-USD-190927-5000-C
         * 是否必须 是
         */
        private String instId;
        /**
         * 交易模式
         * 保证金模式：isolated：逐仓 ；cross：全仓
         * 非保证金模式：cash：非保证金
         * 是否必须 是
         */
        private String tdMode;
        /**
         * 保证金币种，仅适用于单币种保证金模式下的全仓杠杆订单
         * 是否必须 否
         */
        private String ccy;
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
        /**
         * 订单方向
         * buy：买， sell：卖
         * 是否必须 是
         */
        private String side;
        /**
         * 持仓方向
         * 在双向持仓模式下必填，且仅可选择 long 或 short。 仅适用交割、永续
         * 是否必须 否
         */
        private String posSide;
        /**
         * 订单类型
         * market：市价单
         * limit：限价单
         * post_only：只做maker单
         * fok：全部成交或立即取消
         * ioc：立即成交并取消剩余
         * optimal_limit_ioc：市价委托立即成交并取消剩余（仅适用交割、永续）
         * 是否必须 是
         */
        private String ordType;
        /**
         * 委托数量
         * 是否必须 是
         */
        private String sz;
        /**
         * 委托价格，仅适用于limit、post_only、fok、ioc类型的订单
         * 是否必须 否
         */
        private String px;
        /**
         * 是否只减仓，true 或 false，默认false
         * 仅适用于币币杠杆，以及买卖模式下的交割/永续
         * 仅适用于单币种保证金模式和跨币种保证金模式
         * 是否必须 否
         */
        private Boolean reduceOnly;
        /**
         * 市价单委托数量的类型，仅适用于币币市价订单
         * base_ccy: 交易货币 ；quote_ccy：计价货币
         * 买单默认quote_ccy， 卖单默认base_ccy
         * 是否必须 否
         */
        private String tgtCcy;
        /**
         * 是否禁止币币市价改单，true 或 false，默认false
         * 为true时，余额不足时，系统不会改单，下单会失败，仅适用于币币市价单
         * 是否必须 否
         */
        private Boolean banAmend;


        /**
         * 止盈触发价，如果填写此参数，必须填写 止盈委托价
         */
        private String tpTriggerPx;
        /**
         * 止盈委托价，如果填写此参数，必须填写 止盈触发价
         * 委托价格为-1时，执行市价止盈
         */
        private String tpOrdPx;
        /**
         * 止损触发价，如果填写此参数，必须填写 止损委托价
         */
        private String slTriggerPx;
        /**
         * 止损委托价，如果填写此参数，必须填写 止损触发价
         * 委托价格为-1时，执行市价止损
         */
        private String slOrdPx;
        /**
         * 止盈触发价类型
         * last：最新价格
         * index：指数价格
         * mark：标记价格
         * 默认为last
         */
        private String tpTriggerPxType;
        /**
         * 止损触发价类型
         * last：最新价格
         * index：指数价格
         * mark：标记价格
         * 默认为last
         */
        private String slTriggerPxType;




    }

    @Setter
    @Getter
    @ToString
    public static class Data {
        private String clOrderId;
        private String ordId;
        private String tag;
        private String sCode;
        private String sMsg;
    }

    public static class Response extends OkxResponse {

        public List<Data> getData() {
            return getMultiData(Data.class);
        }
    }
}
