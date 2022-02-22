package com.example.demo.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/kakao/")
@RequiredArgsConstructor
public class KakaoController {
//	private final KakaoProperties kakaoProperties;
	private final WebClient kakaoWebClient;
		
//	@GetMapping("/test")
//	@ResponseBody
//	public KakaoProperties test() {
//		return kakaoProperties;
//	}
	
//	@GetMapping("/search")
//	public String search(@RequestParam String query) {
//		Mono<String> mono = WebClient.builder().baseUrl("https://dapi.kakao.com")
//			.build().get().uri(builder -> builder.path("/v2/local/search/address.json").queryParam("query", query).build())
//			.header("Authorization", "KakaoAK " + kakaoProperties.getRestapi())
//			.exchangeToMono(response -> {return response.bodyToMono(String.class);});
//		
//		return mono.block();
//			
//	}
	
	@GetMapping("/search")
	public String search(@RequestParam String query) {
		Mono<String> mono = kakaoWebClient.get()
			.uri(builder -> builder.path("/v2/local/search/address.json").queryParam("query", query).build())
			.exchangeToMono(response -> {return response.bodyToMono(String.class);});
		
		return mono.block();
			
	}
	
	@GetMapping("/coord2regioncode")
	public String coord2regioncode(@RequestParam String x, @RequestParam String y) {
		Mono<String> mono = kakaoWebClient.get()
			.uri(builder -> builder.path("/v2/local/geo/coord2regioncode.json").queryParam("x", x).queryParam("y", y).build())
			.exchangeToMono(response -> {return response.bodyToMono(String.class);});
		
		return mono.block();
			
	}

}
