package com.codingapi.sdk.okx.rest.protocol.pub;

import com.codingapi.sdk.okx.rest.protocol.OkxResponse;
import com.codingapi.springboot.framework.rest.param.RestParam;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

public class ConvertContractCoin {

    @Setter
    @Getter
    @ToString
    public static class Request implements RestParam {
        /**
         * 转换类型
         * 1: 币转张，当张为小数时，会进一取整
         * 2: 张转币
         * 默认为 1
         */
        private String type;
        /**
         * 产品ID，仅适用于交割/永续/期权
         */
        private String instId;
        /**
         * 数量，币转张时，为币的数量，张转币时，为张的数量。
         * 张的数量，只能是正整数
         */
        private String sz;
        /**
         * 委托价格
         * 币本位合约的张币转换时必填；
         * U本位合约，usdt 与张的转换时，必填；coin 与张的转换时，可不填；
         * 期权的张币转换时，可不填。
         */
        private String px;
        /**
         * 币的单位，coin: 币，usdt: usdt
         * 仅适用于交割和永续合约的U本位合约
         */
        private String unit;
    }

    @Setter
    @Getter
    @ToString
    public static class Data {
        /**
         * 产品ID
         */
        private String instId;
        /**
         * 转换类型
         * 1: 币转张，当张小数时，会进一取整
         * 2: 张转币
         */
        private String type;
        /**
         * 委托价格
         */
        private String px;
        /**
         * 数量，张转币时，为币的数量，币转张时，为张的数量
         */
        private String sz;
        /**
         * 币的单位，coin: 币，usdt: usdt
         */
        private String unit;
    }

    @ToString
    public static class Response extends OkxResponse {

        public List<Data> getData() {
            return getMultiData(Data.class);
        }

    }
}
