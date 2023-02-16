# sdk-starter-okx-rest

基于OKX v5 rest api开发的springboot的OKX-REST-SDK starter  
[OKX API](https://www.okx.com/docs-v5/zh/#rest-api)

## 使用步骤

* 源码本地打包(暂未上传中心仓库,后续将上传中心库)  
`mvn clean -DskipTests=true  install`
* maven依赖
```
    <dependency>
        <groupId>com.codingapi</groupId>
        <artifactId>sdk-starter-okx-rest</artifactId>
        <version>${last.version}</version>
    </dependency>
```
* 配置OKX APIKEY
```
# http 代理配置,根据服务网络情况自行开启
codingapi.okx.proxy.enable-proxy=true
codingapi.okx.proxy.proxy-host=127.0.0.1
codingapi.okx.proxy.proxy-port=7890
codingapi.okx.proxy.proxy-type=http

# OKX api 参数配置
codingapi.okx.config.apikey=xxxx
codingapi.okx.config.secretkey=xxx
codingapi.okx.config.passphrase=xxx
codingapi.okx.config.mock=false

```

* SDK使用
```

    @Autowired
    private MarketApi marketApi;

    @Test
    void trades() {
        Trades.Response response = marketApi.trades("BTC-USDT");
        assertTrue(response!=null);
        assertTrue(response.getData().size()>0);
        log.info("list:{}",response.getData());
    }

    
```


## 代码维护

本框架基于RestTemplate开发，通过底层的抽象完成的SDK开发。 因此允许用户自行拓展维护新的接口。


* 确定API模板  
目前已经提供了AccountApi、MarketApi、PublicApi、SystemApi、TradeApi,这些模块的划分依据是根据okx接口文档的地址前缀。  
例如批量下单接口地址为 /api/v5/trade/batch-orders，即归到了TradeApi模块下。
* 编写请求参数与相应参数对象  
以下单接口为例
```

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
```

需要编写Order.Response和 Order.Request 对象。如下:
```
package com.codingapi.sdk.okx.rest.dto.trade;

import com.codingapi.sdk.okx.rest.dto.OkxResponse;
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

```

* 请在编写对应接口的单元测试   
以获取成交记录为例.(注意：代码提交时,不要将自己的apikey参数提交到Git上。本项目中已过滤了`application-dev.properties`的提交)

```

@Slf4j
@Profile("dev")
@SpringBootTest
class MarketApiTest {

    @Autowired
    private MarketApi marketApi;

    @Test
    void trades() {
        Trades.Response response = marketApi.trades("BTC-USDT");
        assertTrue(response!=null);
        assertTrue(response.getData().size()>0);
        log.info("list:{}",response.getData());
    }
}
```

* 提交PR  
当你确认代码已经测试没有问题,欢迎提交PR贡献合并。