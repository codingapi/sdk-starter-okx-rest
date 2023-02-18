package com.codingapi.sdk.okx.rest;

import com.codingapi.sdk.okx.rest.api.*;
import com.codingapi.sdk.okx.rest.client.SignOkxApi;
import com.codingapi.sdk.okx.rest.properties.OkxConfigProperties;
import com.codingapi.springboot.framework.rest.properties.HttpProxyProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AutoOkxRestConfiguration {

    @Bean
    @ConfigurationProperties(prefix = "codingapi.okx.proxy")
    public HttpProxyProperties httpProxyProperties() {
        return new HttpProxyProperties();
    }

    @Bean
    @ConfigurationProperties(prefix = "codingapi.okx.config")
    public OkxConfigProperties okxConfigProperties() {
        return new OkxConfigProperties();
    }

    @Bean
    public SignOkxApi okxApi(HttpProxyProperties properties, OkxConfigProperties okxConfig) {
        return new SignOkxApi(properties, okxConfig);
    }

    @Bean
    public AccountApi accountApi(SignOkxApi signOkxApi){
        return new AccountApi(signOkxApi);
    }

    @Bean
    public PublicApi publicApi(SignOkxApi signOkxApi){
        return new PublicApi(signOkxApi);
    }

    @Bean
    public SystemApi systemApi(SignOkxApi signOkxApi){
        return new SystemApi(signOkxApi);
    }

    @Bean
    public TradeApi tradeApi(SignOkxApi signOkxApi){
        return new TradeApi(signOkxApi);
    }

    @Bean
    public MarketApi marketApi(SignOkxApi signOkxApi){
        return new MarketApi(signOkxApi);
    }
}
