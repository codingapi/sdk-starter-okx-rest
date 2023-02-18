package com.codingapi.sdk.okx.rest.api;

import com.alibaba.fastjson.JSONObject;
import com.codingapi.sdk.okx.rest.client.SignOkxApi;
import com.codingapi.sdk.okx.rest.protocol.trade.*;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@AllArgsConstructor
public class TradeApi {

    private final SignOkxApi signOkxApi;

    /**
     * 下单接口
     * <a href="https://www.okx.com/docs-v5/zh/#rest-api-trade-place-order">api</a>
     * @param request {@link Order.Request}
     * @return {@link Order.Response}
     */
    public Order.Response order(Order.Request request) {
        String data = signOkxApi.postSign("/api/v5/trade/order", request.getParameters());
        log.debug("response:{}", data);
        return JSONObject.parseObject(data, Order.Response.class);
    }

    /**
     * 撤单接口
     * <a href="https://www.okx.com/docs-v5/zh/#rest-api-trade-cancel-order">api</a>
     * @param request {@link OrderCancel.Request}
     * @return {@link OrderCancel.Response}
     */
    public OrderCancel.Response cancel(OrderCancel.Request request) {
        String data = signOkxApi.postSign("/api/v5/trade/cancel-order", request.getParameters());
        log.debug("response:{}", data);
        return JSONObject.parseObject(data, OrderCancel.Response.class);
    }

    /**
     * 修改订单接口
     * <a href="https://www.okx.com/docs-v5/zh/#rest-api-trade-amend-order">api</a>
     * @param request {@link OrderAmend.Request}
     * @return {@link OrderAmend.Response}
     */
    public OrderAmend.Response amend(OrderAmend.Request request) {
        String data = signOkxApi.postSign("/api/v5/trade/amend-order", request.getParameters());
        log.debug("response:{}", data);
        return JSONObject.parseObject(data, OrderAmend.Response.class);
    }


    /**
     * 市价仓位全平
     * <a href="https://www.okx.com/docs-v5/zh/#rest-api-trade-close-positions">api</a>
     * @param request {@link ClosePosition.Request}
     * @return {@link ClosePosition.Response}
     */
    public ClosePosition.Response closePosition(ClosePosition.Request request) {
        String data = signOkxApi.postSign("/api/v5/trade/close-position", request.getParameters());
        log.debug("response:{}", data);
        return JSONObject.parseObject(data, ClosePosition.Response.class);
    }


    /**
     * 策略委托下单
     * <a href="https://www.okx.com/docs-v5/zh/#rest-api-trade-place-algo-order">api</a>
     * @param request {@link OrderAlgo.Request}
     * @return {@link OrderAlgo.Response}
     */
    public OrderAlgo.Response algo(OrderAlgo.Request request) {
        String data = signOkxApi.postSign("/api/v5/trade/order-algo", request.getParameters());
        log.debug("response:{}", data);
        return JSONObject.parseObject(data, OrderAlgo.Response.class);
    }



    /**
     * 撤销策略委托订单
     * <a href="https://www.okx.com/docs-v5/zh/#rest-api-trade-cancel-algo-order">api</a>
     * @param request {@link CancelAlgos.Request}
     * @return {@link CancelAlgos.Response}
     */
    public CancelAlgos.Response cancelAlgos(CancelAlgos.Request request) {
        String data = signOkxApi.postSign("/api/v5/trade/cancel-algos", request.getParameters());
        log.debug("response:{}", data);
        return JSONObject.parseObject(data, CancelAlgos.Response.class);
    }

    /**
     * 获取未完成策略委托单列表
     * <a href="https://www.okx.com/docs-v5/zh/#rest-api-trade-cancel-advance-algo-order"></a>
     * @param request {@link OrdersAlgoPending.Request}
     * @return {@link OrdersAlgoPending.Response}
     */
    public OrdersAlgoPending.Response  ordersAlgoPending(OrdersAlgoPending.Request request){
        String data = signOkxApi.getSign("/api/v5/trade/orders-algo-pending", request.getParameters());
        log.debug("response:{}", data);
        return JSONObject.parseObject(data, OrdersAlgoPending.Response.class);
    }


    /**
     * 获取历史策略委托单列表
     * <a href="https://www.okx.com/docs-v5/zh/#rest-api-trade-get-algo-order-history"></a>
     * @param request {@link OrdersAlgoHistory.Request}
     * @return {@link OrdersAlgoHistory.Response}
     */
    public OrdersAlgoHistory.Response  ordersAlgoHistory(OrdersAlgoHistory.Request request){
        String data = signOkxApi.getSign("/api/v5/trade/orders-algo-history", request.getParameters());
        log.debug("response:{}", data);
        return JSONObject.parseObject(data, OrdersAlgoHistory.Response.class);
    }

    /**
     * 获取未成交订单列表
     * <a href="https://www.okx.com/docs-v5/zh/#rest-api-trade-get-order-list"></a>
     * @param request  {@link OrdersPending.Request}
     * @return  {@link OrdersPending.Response}
     */
    public OrdersPending.Response ordersPending(OrdersPending.Request request){
        String data = signOkxApi.getSign("/api/v5/trade/orders-pending", request.getParameters());
        log.debug("response:{}", data);
        return JSONObject.parseObject(data, OrdersPending.Response.class);
    }


    /**
     * 获取订单信息
     * <a href="https://www.okx.com/docs-v5/zh/#rest-api-trade-get-order-details"></a>
     * @param request  {@link OrderQuery.Request}
     * @return  {@link OrderQuery.Response}
     */
    public OrderQuery.Response orderQuery(OrderQuery.Request request){
        String data = signOkxApi.getSign("/api/v5/trade/order", request.getParameters());
        log.debug("response:{}", data);
        return JSONObject.parseObject(data, OrderQuery.Response.class);
    }

    /**
     * 获取历史订单记录（近七天）
     * <a href="https://www.okx.com/docs-v5/zh/#rest-api-trade-get-order-list"></a>
     * @param request {@link OrdersHistory.Request}
     * @return {@link OrdersHistory.Request}
     */
    public OrdersHistory.Response orderHistory(OrdersHistory.Request request){
        String data = signOkxApi.getSign("/api/v5/trade/fills", request.getParameters());
        log.debug("response:{}", data);
        return JSONObject.parseObject(data, OrdersHistory.Response.class);
    }
}
