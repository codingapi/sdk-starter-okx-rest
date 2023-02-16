package com.codingapi.sdk.okx.rest.dto.trade;

import com.codingapi.sdk.okx.rest.dto.OkxResponse;
import com.codingapi.springboot.framework.rest.param.RestParam;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

public class OrderAlgo {


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
         * conditional：单向止盈止损
         * oco：双向止盈止损
         * trigger：计划委托
         * move_order_stop：移动止盈止损
         * iceberg：冰山委托
         * twap：时间加权委托
         * 是否必须 是
         */
        private String ordType;

        /**
         * 委托数量
         * 是否必须 是
         */
        private String sz;

        /**
         * 订单标签
         * 字母（区分大小写）与数字的组合，可以是纯字母、纯数字，且长度在1-16位之间。
         * 是否必须 否
         */
        private String tag;
        /**
         * 委托数量的类型
         * base_ccy: 交易货币 ；quote_ccy：计价货币
         * 仅适用于币币单向止盈止损买单
         * 默认买为计价货币，卖为交易货币
         * 是否必须 否
         */
        private String tgtCcy;

        /**
         * 是否只减仓，true 或 false，默认false
         * 仅适用于币币杠杆，以及买卖模式下的交割/永续
         * 仅适用于单币种保证金模式和跨币种保证金模式
         * 是否必须 否
         */
        private Boolean reduceOnly;

        /**
         * 客户自定义订单ID
         * 字母（区分大小写）与数字的组合，可以是纯字母、纯数字且长度要在1-32位之间。
         * 是否必须 否
         */
        private String clOrdId;

        //止盈止损//

        /**
         * 止盈触发价，如果填写此参数，必须填写 止盈委托价
         * 是否必须 否
         */
        private String tpTriggerPx;
        /**
         *止盈触发价类型
         * last：最新价格
         * index：指数价格
         * mark：标记价格
         * 默认为last
         * 是否必须 否
         */
        private String tpTriggerPxType;
        /**
         * 止盈委托价，如果填写此参数，必须填写 止盈触发价
         * 委托价格为-1时，执行市价止盈
         * 是否必须 否
         */
        private String tpOrdPx;
        /**
         * 止损触发价，如果填写此参数，必须填写 止损委托价
         * 是否必须 否
         */
        private String slTriggerPx;
        /**
         *
         * 止损触发价类型
         * last：最新价格
         * index：指数价格
         * mark：标记价格
         * 默认为last
         * 是否必须 否
         */
        private String slTriggerPxType;
        /**
         * 止损委托价，如果填写此参数，必须填写 止损触发价
         * 委托价格为-1时，执行市价止损
         * 是否必须 否
         */
        private String slOrdPx;

        //计划委托

        /**
         * 计划委托触发价格
         * 是否必须 是
         */
        private String triggerPx;

        /**
         * 委托价格
         * 委托价格为-1时，执行市价委托
         * 是否必须 是
         */
        private String orderPx;

        /**
         * 计划委托触发价格类型
         * last：最新价格
         * index：指数价格
         * mark：标记价格
         * 默认为last
         * 是否必须 否
         */
        private String triggerPxType;

        //移动止盈止损

        /**
         * 回调幅度的比例，如 0.05
         * callbackRatio和callbackSpread只能传入一个
         * 是否必须 否
         */
        private String callbackRatio;
        /**
         *
         * 回调幅度的价距
         * 是否必须 否
         */
        private String callbackSpread;
        /**
         * 激活价格
         * 是否必须 否
         */
        private String activePx;

        //冰山委托

        /**
         * 挂单价距离盘口的比例
         * pxVar和pxSpread只能传入一个
         * 是否必须 否
         */
        private String pxVar;
        /**
         * 挂单价距离盘口的价距
         * 是否必须 否
         */
        private String pxSpread;
        /**
         * 单笔数量
         * 是否必须 是
         */
        private String szLimit;
        /**
         * 挂单限制价
         * 是否必须 是
         */
        private String pxLimit;

// 时间加权
// 字段重复
//        /**
//         * 吃单价优于盘口的比例
//         * pxVar和pxSpread只能传入一个
//         * 是否必须 否
//         */
//        private String pxVar;
//
//        /**
//         * 吃单单价优于盘口的价距
//         * 是否必须 否
//         */
//        private String pxSpread;
//        /**
//         * 单笔数量
//         * 是否必须 是
//         */
//        private String szLimit;
//        /**
//         * 挂单限制价
//         * 是否必须 是
//         */
//        private String pxLimit;

        /**
         * 下单间隔
         * 是否必须 是
         */
        private String timeInterval;

    }

    @Setter
    @Getter
    @ToString
    public static class Data {
        private String algoId;
        private String clOrdId;
        private String sCode;
        private String sMsg;
    }

    public static class Response extends OkxResponse {

        public List<Data> getData() {
            return getMultiData(Data.class);
        }

        public String getAlgoId() {
            if(isSuccess()){
                if(getData().size()>0){
                    Data data = getData().get(0);
                    return data.getAlgoId();
                }
            }
            return null;
        }
    }
}
