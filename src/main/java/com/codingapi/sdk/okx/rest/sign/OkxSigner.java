package com.codingapi.sdk.okx.rest.sign;

import com.codingapi.springboot.framework.crypto.HmacSHA256;
import lombok.Getter;
import lombok.Setter;
import lombok.SneakyThrows;
import org.springframework.util.Base64Utils;

import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

@Getter
public class OkxSigner {

    private final String secretkey;

    public OkxSigner(String secretkey) {
        this.secretkey = secretkey;
    }

    @SneakyThrows
    public Sign apiSign(String method, String requestPath, String body) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        format.setTimeZone(TimeZone.getTimeZone("UTC"));
        String timestamp = format.format(new Date());
        String content = timestamp+method+requestPath+body;
        String signVal = Base64Utils.encodeToString(HmacSHA256.sha256(content.getBytes(StandardCharsets.UTF_8),
                secretkey.getBytes(StandardCharsets.UTF_8)));
        return new Sign(timestamp, signVal);
    }

    @Setter
    @Getter
    public static class Sign {
        private String timestamp;
        private String sign;

        public Sign(String timestamp, String sign) {
            this.timestamp = timestamp;
            this.sign = sign;
        }
    }

}
