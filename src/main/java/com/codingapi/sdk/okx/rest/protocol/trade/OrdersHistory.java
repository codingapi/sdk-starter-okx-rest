package com.codingapi.sdk.okx.rest.protocol.trade;

import com.codingapi.sdk.okx.rest.protocol.OkxResponse;
import com.codingapi.springboot.framework.rest.param.RestParam;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

public class OrdersHistory {


    @Setter
    @Getter
    @ToString
    public static class Request implements RestParam {

        /**
         * 产品类型
         * SPOT：币币
         * MARGIN：币币杠杆
         * SWAP：永续合约
         * FUTURES：交割合约
         * OPTION：期权
         */
        private String instType;

        /**
         * 标的指数
         */
        private String uly;

        /**
         * 交易品种
         * 适用于交割/永续/期权
         */
        private String instFamily;

        /**
         * 产品ID
         * 是
         */
        private String instId;

        /**
         * 订单类型
         * market：市价单
         * limit：限价单
         * post_only：只做maker单
         * fok：全部成交或立即取消
         * ioc：立即成交并取消剩余
         * optimal_limit_ioc：市价委托立即成交并取消剩余（仅适用交割、永续
         */
        private String ordType;

        /**
         * 订单状态
         * canceled：撤单成功
         * filled：完全成交
         */
        private String state;

        /**
         * 订单种类
         * twap：TWAP自动换币
         * adl：ADL自动减仓
         * full_liquidation：强制平仓
         * partial_liquidation：强制减仓
         * delivery：交割
         * ddh：对冲减仓类型订单
         */
        private String category;

        /**
         * 请求此 ID 之前（更旧的数据）的分页内容，传的值为对应接口的billId
         */
        private String after;

        /**
         * 请求此 ID 之后（更新的数据）的分页内容，传的值为对应接口的billId
         */
        private String before;

        /**
         * 筛选的开始时间戳，Unix 时间戳为毫秒数格式，如 1597026383085
         */
        private String begin;

        /**
         * 筛选的结束时间戳，Unix 时间戳为毫秒数格式，如 1597027383085
         */
        private String end;

        /**
         * 返回结果的数量，最大为100，默认100条
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
         * 币币市价单委托数量sz的单位
         * base_ccy: 交易货币 ；quote_ccy：计价货币
         * 仅适用于币币市价订单
         * 默认买单为quote_ccy，卖单为base_ccy
         */
        private String tgtCcy;

        /**
         * 保证金币种，仅适用于单币种保证金模式下的全仓杠杆订单
         */
        private String ccy;

        /**
         * 订单ID
         */
        private String ordId;


        /**
         * 客户自定义订单ID
         */
        private String clOrdId;

        /**
         * 订单标签
         */
        private String tag;

        /**
         * 委托价格
         */
        private String px;

        /**
         * 委托数量
         */
        private String sz;

        /**
         * 收益，适用于有成交的平仓订单，其他情况均为0
         */
        private String pnl;

        /**
         * 订单类型
         * market：市价单
         * limit：限价单
         * post_only：只做maker单
         * fok：全部成交或立即取消
         * ioc：立即成交并取消剩余
         * optimal_limit_ioc：市价委托立即成交并取消剩余（仅适用交割、永续）
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
         * 最新成交价格。如果还没成交，系统返回0。
         */
        private String fillPx;


        /**
         * 最新成交ID
         */
        private String tradeId;

        /**
         * 最新成交数量
         */
        private String fillSz;

        /**
         * 最新成交时间
         */
        private String fillTime;

        /**
         * 成交均价。如果还没成交，系统返回0。
         */
        private String avgPx;

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
         * 止盈委托价
         */
        private String tpOrdPx;

        /**
         * 交易手续费币种
         */
        private String feeCcy;

        /**
         * 手续费与返佣
         * 对于币币和杠杆，为订单交易累计的手续费，平台向用户收取的交易手续费，为负数。如： -0.01
         * 对于交割、永续和期权，为订单交易累计的手续费和返佣
         */
        private String fee;


        /**
         * 返佣金币种
         */
        private String rebateCcy;

        /**
         * 返佣金额，仅适用于币币和杠杆，平台向达到指定lv交易等级的用户支付的挂单奖励（返佣），如果没有返佣金，该字段为“”。手续费返佣为正数，如：0.01
         */
        private String rebate;

        /**
         * 订单来源
         * 13:策略委托单触发后的生成的限价单
         */
        private String source;

        /**
         * 订单种类
         * normal： 普通委托
         */
        private String category;


        /**
         * 是否只减仓，true 或 false
         */
        private String reduceOnly;

        /**
         * 订单状态更新时间，Unix时间戳的毫秒数格式，如 1597026383085
         */
        private String uTime;

        /**
         * 订单创建时间， Unix时间戳的毫秒数格式，如 1597026383085
         */
        private String cTime;

        private String ts;
    }
}
