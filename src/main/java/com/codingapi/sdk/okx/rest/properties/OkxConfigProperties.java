package com.codingapi.sdk.okx.rest.properties;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class OkxConfigProperties {

    /**
     * api url
     */
    private String apiUrl = "https://www.okx.com";

    /**
     * appkey
     */
    private String apikey;
    /**
     * secretkey
     */
    private String secretkey;

    /**
     * appkey 密码
     */
    private String passphrase;


    /**
     * mock
     */
    private boolean mock;


}
