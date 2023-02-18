package com.codingapi.sdk.okx.rest.dto.trade;

import com.codingapi.sdk.okx.rest.dto.OkxResponse;
import com.codingapi.springboot.framework.rest.param.RestParam;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

public class OrdersAlgoPending {

    @Setter
    @Getter
    @ToString
    public static class Request implements RestParam {

        /**
         *  策略委托单ID
         *  否
         */
        private String algoId;

        /**
         * 产品类型
         * 否
         * SPOT：币币
         * SWAP：永续合约
         * FUTURES：交割合约
         * MARGIN：杠杆
         */
        private String instType;

        /**
         * 产品ID
         * 否
         */
        private String instId;

        /**
         * 订单类型 是
         * conditional：单向止盈止损
         * oco：双向止盈止损
         * trigger：计划委托
         * move_order_stop：移动止盈止损
         * iceberg：冰山委托
         * twap：时间加权委托
         */
        private String ordType;

        /**
         * 请求此ID之前（更旧的数据）的分页内容，传的值为对应接口的algoId
         * 否
         */
        private String after;

        /**
         * 请求此ID之后（更新的数据）的分页内容，传的值为对应接口的algoId
         * 否
         */
        private String before;

        /**
         * 分页返回的结果集数量，最大为300，不填默认返回100条
         * 否
         */
        private String limit;

        /**
         * 客户自定义订单ID
         * 字母（区分大小写）与数字的组合，可以是纯字母、纯数字且长度要在1-32位之间。
         * 否
         */
        private String clOrdId;
    }

    @Setter
    @Getter
    @ToString
    public static class Response extends OkxResponse {

        public List<Data> getData() {
            return getMultiData(Data.class);
        }

        public String getLiveAlgoId(){
            if(isSuccess()){
                if(getData().size()>0) {
                    Data data = getData().get(0);
                    if(data.getState().equals("live")) {
                        return data.getAlgoId();
                    }
                }
            }
            return null;
        }

    }

    @Setter
    @Getter
    @ToString
    public static class Data{
        /**
         * 产品类型
         */
        private String instType;

        /**
         * 产品ID
         */
        private String instId;

        /**
         * 保证金币种，仅适用于单币种保证金模式下的全仓杠杆订单
         */
        private String ccy;

        /**
         * 订单ID
         */
        private String ordId;

        /**
         * 策略委托单ID
         */
        private String algoId;

        /**
         * 客户自定义订单ID
         */
        private String clOrdId;

        /**
         * 委托数量
         */
        private String sz;

        /**
         * 订单类型
         */
        private String ordType;

        /**
         * 订单方向
         */
        private String side;

        /**
         * 持仓方向
         */
        private String posSide;

        /**
         * 交易模式
         */
        private String tdMode;

        /**
         * 币币市价单委托数量sz的单位
         * base_ccy: 交易货币 ；quote_ccy：计价货币
         * 仅适用于币币市价订单
         * 默认买单为quote_ccy，卖单为base_ccy
         */
        private String tgtCcy;

        /**
         * 订单状态 ，live：待生效 pause：暂停生效 partially_effective:部分生效
         */
        private String state;

        /**
         * 杠杆倍数，0.01到125之间的数值，仅适用于 币币杠杆/交割/永续
         */
        private String lever;

        /**
         * 止盈触发价
         */
        private String tpTriggerPx;

        /**
         * 止盈触发价类型
         * last：最新价格
         * index：指数价格
         * mark：标记价格
         */
        private String tpTriggerPxType;

        /**
         * 止盈委托价
         */
        private String tpOrdPx;

        /**
         * 止损触发价
         */
        private String slTriggerPx;

        /**
         * 止损触发价类型
         * last：最新价格
         * index：指数价格
         * mark：标记价格
         */
        private String slTriggerPxType;

        /**
         * 止损委托价
         */
        private String slOrdPx;

        /**
         * 计划委托触发价格
         */
        private String triggerPx;

        /**
         * 计划委托触发价类型
         * last：最新价格
         * index：指数价格
         * mark：标记价格
         */
        private String triggerPxType;

        /**
         * 计划委托委托价格
         */
        private String ordPx;

        /**
         * 实际委托量
         */
        private String actualSz;

        /**
         * 实际委托价
         */
        private String actualPx;

        /**
         * 实际触发方向， tp：止盈 sl： 止损
         */
        private String actualSide;

        /**
         * 策略委托触发时间，Unix时间戳的毫秒数格式，如 1597026383085
         */
        private String triggerTime;

        /**
         * 价格比例
         * 仅适用于冰山委托和时间加权委托
         */
        private String pxVar;

        /**
         * 价距
         * 仅适用于冰山委托和时间加权委托
         */
        private String pxSpread;

        /**
         * 单笔数量
         * 仅适用于冰山委托和时间加权委托
         */
        private String szLimit;

        /**
         * 订单标签
         */
        private String tag;

        /**
         * 挂单限制价
         * 仅适用于冰山委托和时间加权委托
         */
        private String pxLimit;

        /**
         * 下单间隔
         * 仅适用于时间加权委托
         */
        private String timeInterval;

        /**
         * 回调幅度的比例
         * 仅适用于移动止盈止损
         */
        private String callbackRatio;

        /**
         * 回调幅度的价距
         * 仅适用于移动止盈止损
         */
        private String callbackSpread;

        /**
         * 移动止盈止损激活价格
         * 仅适用于移动止盈止损
         */
        private String activePx;

        /**
         * 移动止盈止损触发价格
         * 仅适用于移动止盈止损
         */
        private String moveTriggerPx;

        /**
         * 是否只减仓，true 或 false
         */
        private String reduceOnly;

        /**
         * 订单创建时间， Unix时间戳的毫秒数格式，如 1597026383085
         */
        private String cTime;
    }

}
