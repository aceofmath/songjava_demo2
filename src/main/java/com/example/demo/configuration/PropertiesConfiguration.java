package com.example.demo.configuration;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.example.demo.configuration.properties.KakaoProperties;

@Configuration
@EnableConfigurationProperties({KakaoProperties.class})
@PropertySource({"classpath:properties//kakao.properties"})
public class PropertiesConfiguration {

}
