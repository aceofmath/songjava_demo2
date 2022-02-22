package com.example.demo.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

import com.example.demo.configuration.properties.KakaoProperties;

import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class KakaoConfiguration {
	
	private final KakaoProperties kakaoProperties;
	
	@Bean
	public WebClient kakaoWebClient() {
		return WebClient.builder().baseUrl("https://dapi.kakao.com")
				.defaultHeader("Authorization", "KakaoAK " + kakaoProperties.getRestapi()).build();
		
	}

}
