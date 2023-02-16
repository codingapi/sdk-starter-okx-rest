package com.codingapi.sdk.okx.rest.api;

import com.codingapi.sdk.okx.rest.dto.market.Trades;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Profile;

import static org.junit.jupiter.api.Assertions.*;

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
