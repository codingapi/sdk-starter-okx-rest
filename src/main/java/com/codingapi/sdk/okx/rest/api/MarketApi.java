package com.codingapi.sdk.okx.rest.api;

import com.alibaba.fastjson.JSONObject;
import com.codingapi.sdk.okx.rest.client.SignOkxApi;
import com.codingapi.sdk.okx.rest.protocol.market.Books;
import com.codingapi.sdk.okx.rest.protocol.market.Candles;
import com.codingapi.sdk.okx.rest.protocol.market.Ticker;
import com.codingapi.sdk.okx.rest.protocol.market.Trades;
import com.codingapi.springboot.framework.rest.param.RestParam;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@AllArgsConstructor
public class MarketApi {

    private final SignOkxApi signOkxApi;

    /**
     * 获取K线数据
     * <a href="https://www.okx.com/docs-v5/zh/#rest-api-market-data-get-index-candlesticks">api</a>
     * @param request {@link Candles.Request}
     * @return {@link Candles.Response}
     */
    public Candles.Response candles(Candles.Request request) {
        String data = signOkxApi.getSign("/api/v5/market/candles", request.toParameters());
        log.debug("response:{}", data);
        return JSONObject.parseObject(data, Candles.Response.class);
    }


    /**
     * 获取交易产品历史K线数据
     * <a href="https://www.okx.com/docs-v5/zh/#rest-api-market-data-get-candlesticks-history">api</a>
     * @param request {@link Candles.Request}
     * @return {@link Candles.Response}
     */
    public Candles.Response historyCandles(Candles.Request request) {
        String data = signOkxApi.getSign("/api/v5/market/history-candles", request.toParameters());
        log.debug("response:{}", data);
        return JSONObject.parseObject(data, Candles.Response.class);
    }

    /**
     * 获取单个产品行情信息
     * <a href="https://www.okx.com/docs-v5/zh/#rest-api-market-data-get-ticker">api</a>
     * @param instId  产品ID，如 BTC-USD-SWAP
     * @return {@link Ticker.Response}
     */
    public Ticker.Response ticker(String instId) {
        String data = signOkxApi.getSign("/api/v5/market/ticker", RestParam.create().add("instId",instId));
        log.debug("response:{}", data);
        return JSONObject.parseObject(data, Ticker.Response.class);
    }


    /**
     * 获取交易产品公共成交数据
     * <a href="https://www.okx.com/docs-v5/zh/#rest-api-market-data-get-trades">api</a>
     * @param instId 产品ID，如 BTC-USDT
     * @param limit 获取记录条数
     * @return {@link Trades.Response}
     */
    public Trades.Response trades(String instId, int limit){
        String data = signOkxApi.getSign("/api/v5/market/trades", RestParam.create().add("instId",instId)
                .add("limit",String.valueOf(limit)));
        log.debug("response:{}", data);
        return JSONObject.parseObject(data, Trades.Response.class);
    }


    /**
     * 获取交易产品公共历史成交数据
     * <a href="https://www.okx.com/docs-v5/zh/#rest-api-market-data-get-trades-history">api</a>
     * @param request {@link Trades.Request}
     * @return {@link Trades.Response}
     */
    public Trades.Response historyTrades(Trades.Request request){
        String data = signOkxApi.getSign("/api/v5/market/history-trades", request.toParameters());
        log.debug("response:{}", data);
        return JSONObject.parseObject(data, Trades.Response.class);
    }


    /**
     * 获取交易产品公共成交数据
     * <a href="https://www.okx.com/docs-v5/zh/#rest-api-market-data-get-trades">api</a>
     * @param instId 产品ID，如 BTC-USDT
     * @return {@link Trades.Response}
     */
    public Trades.Response trades(String instId){
      return trades(instId,100);
    }


    /**
     *
     * 获取产品深度
     * <a href="https://www.okx.com/docs-v5/zh/#rest-api-market-data-get-order-book">api</a>
     * @param instId 产品ID，如 BTC-USDT
     * @param sz 深度档位数量，最大值可传400，即买卖深度共800条
     * 不填写此参数，默认返回1档深度数据
     * @return {@link Books.Response}
     */
    public Books.Response books(String instId, int sz){
        String data = signOkxApi.getSign("/api/v5/market/books", RestParam.create().add("instId",instId)
                .add("sz",String.valueOf(sz)));
        log.debug("response:{}", data);
        return JSONObject.parseObject(data, Books.Response.class);
    }

}
