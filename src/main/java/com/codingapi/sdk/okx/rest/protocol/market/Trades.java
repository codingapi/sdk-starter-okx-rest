package com.codingapi.sdk.okx.rest.protocol.market;

import com.codingapi.sdk.okx.rest.protocol.OkxResponse;
import com.codingapi.springboot.framework.rest.param.IRestParam;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

public class Trades {


    @Setter
    @Getter
    @ToString
    public static class Request implements IRestParam {

        /**
         * 产品ID，如 BTC-USDT
         */
        private String instId;

        /**
         * 分页类型
         * 1：tradeId 分页 2：时间戳分页
         * 默认为1：tradeId 分页
         */
        private String type;

        /**
         * 请求此时间戳之前（更旧的数据）的分页内容，传的值为对应接口的ts
         */
        private String after;

        /**
         * 请求此时间戳之后（更新的数据）的分页内容，传的值为对应接口的ts
         */
        private String before;

        /**
         * 分页返回的结果集数量，最大为300，不填默认返回100条
         */
        private String limit;
    }

    @Setter
    @Getter
    @ToString
    public static class Response extends OkxResponse {

        public List<Data> getData() {
            return getMultiData(Data.class);
        }
    }

    @Getter
    @Setter
    @ToString
    public static class Data{
        /**
         * 产品ID
         */
        private String instId;
        /**
         * 成交ID
         */
        private String tradeId;

        /**
         * 成交价格
         */
        private String px;

        /**
         * 成交数量
         */
        private String sz;

        /**
         * 成交方向
         */
        private String side;

        /**
         * 成交时间，Unix时间戳的毫秒数格式， 如1597026383085
         */
        private String ts;

    }


}
