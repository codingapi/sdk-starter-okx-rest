package com.codingapi.sdk.okx.rest.protocol.market;

import com.codingapi.sdk.okx.rest.protocol.OkxResponse;
import com.codingapi.springboot.framework.rest.param.IRestParam;
import com.codingapi.springboot.framework.rest.param.RestParam;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.util.StringUtils;

import java.util.List;


public class Candles {


    @Setter
    @Getter
    @ToString
    public static class Request implements IRestParam {

        /**
         * 产品ID，如BTC-USD-190927-5000-C
         */
        private String instId;

        /**
         * 时间粒度，默认值1m
         * 如 [1m/3m/5m/15m/30m/1H/2H/4H]
         * 香港时间开盘价k线：[6H/12H/1D/2D/3D/1W/1M/3M/6M/1Y]
         * UTC时间开盘价k线：[/6Hutc/12Hutc/1Dutc/2Dutc/3Dutc/1Wutc/1Mutc/3Mutc/6Mutc/1Yutc]
         */
        private String bar;

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


        @Override
        public RestParam toParameters() {
            RestParam builder = RestParam.create();
            builder.add("instId", instId);

            if (!StringUtils.hasText(bar)) {
                bar = "1m";
            }
            builder.add("bar", bar);

            if (StringUtils.hasText(after)) {
                builder.add("after", after);
            }
            if (StringUtils.hasText(before)) {
                builder.add("before", before);
            }
            if (StringUtils.hasText(limit)) {
                builder.add("limit", limit);
            }
            return builder;
        }
    }

    public static class Response extends OkxResponse {

        public List getData() {
            return getMultiData(List.class);
        }
    }


}
