package com.zwy.zwyapiclientsdk;

import com.zwy.zwyapiclientsdk.client.ZwyApiClient;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties("zwyapi.client")
@Data
@ComponentScan
public class ZwyApiClientConfig {
    private String accessKey;
    private String secretKey;

    @Bean
    public ZwyApiClient zwyApiClient(){
        return new ZwyApiClient(accessKey, secretKey);
    }

}
