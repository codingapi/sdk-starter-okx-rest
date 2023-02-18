package com.codingapi.sdk.okx.rest.protocol.account;

import com.codingapi.sdk.okx.rest.protocol.OkxResponse;
import com.codingapi.springboot.framework.rest.param.RestParam;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

public class LeverageSet {

    @Setter
    @Getter
    @ToString
    public static class Request implements RestParam {

        /**
         * 产品ID：币对、合约
         * instId和ccy至少要传一个；如果两个都传，默认使用instId
         * 是否必须 否
         */
        private String instId;
        /**
         * 保证金币种
         * 仅适用于跨币种保证金模式的全仓 币币杠杆。设置自动借币的杠杆倍数时必填
         * 是否必须 否
         */
        private String ccy;

        /**
         * 杠杆倍数
         * 是否必须 否
         */
        private String lever;

        /**
         * 保证金模式
         * isolated：逐仓 cross：全仓
         * 如果ccy有效传值，该参数值只能为cross
         * 是否必须 否
         */
        private String mgnMode;

        /**
         * 持仓方向
         * long：双向持仓多头
         * short：双向持仓空头
         * 仅适用于逐仓交割/永续
         * 在双向持仓且保证金模式为逐仓条件下必填
         * 是否必须 否
         */
        private String posSide;

    }

    @Setter
    @Getter
    @ToString
    public static class Data {
        private String instId;
        private String mgnMode;
        private String pocSide;
        private String lever;
    }

    @ToString
    public static class Response extends OkxResponse {

        public List<Data> getData() {
            return getMultiData(Data.class);
        }

    }
}
