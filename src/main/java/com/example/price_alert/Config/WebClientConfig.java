package com.example.price_alert.Config;

import io.netty.channel.ChannelOption;
import io.netty.handler.timeout.ReadTimeoutHandler;
import io.netty.handler.timeout.WriteTimeoutHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.web.reactive.function.client.ExchangeStrategies;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.netty.http.client.HttpClient;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

@Configuration
public class WebClientConfig {

    @Bean
    public WebClient webClient() {

        // 1. 응답 메모리 크기 늘리기 (기본 256KB -> 10MB)
        // 아주 큰 HTML 페이지를 받아올 때 메모리 부족 오류를 방지합니다.
        ExchangeStrategies exchangeStrategies = ExchangeStrategies.builder()
                .codecs(configurer -> configurer.defaultCodecs().maxInMemorySize(10 * 1024 * 1024))
                .build();

        // 2. 타임아웃 설정
        // 특정 쇼핑몰 서버가 응답이 없을 때 무한정 기다리는 것을 방지합니다.
        HttpClient httpClient = HttpClient.create()
                .option(ChannelOption.CONNECT_TIMEOUT_MILLIS, 5000) // Connection 타임아웃: 5초
                .responseTimeout(Duration.ofMillis(5000)) // Response 타임아웃: 5초
                .doOnConnected(conn ->
                        conn.addHandlerLast(new ReadTimeoutHandler(5000, TimeUnit.MILLISECONDS)) // Read 타임아웃
                                .addHandlerLast(new WriteTimeoutHandler(5000, TimeUnit.MILLISECONDS))); // Write 타임아웃

        return WebClient.builder()
                .clientConnector(new ReactorClientHttpConnector(httpClient))
                .exchangeStrategies(exchangeStrategies)
                // 3. 기본 헤더 설정
                // "나(봇)는 사실 브라우저야" 라고 일부 사이트를 속이기 위한 User-Agent 설정
                .defaultHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/111.0.0.0 Safari/537.36")
                .build();
    }
}
//@Service
//@RequiredArgsConstructor
//public class ScrapingService {
//
//    private final WebClient webClient; // Config 파일에 의해 생성된 WebClient Bean이 자동으로 주입됩니다.
//
//    public void scrapeProduct() {
//        // webClient를 사용하여 스크래핑 로직 구현...
//        String html = webClient.get()
//                .uri("https://www.example-shop.com/product/12345")
//                .retrieve()
//                .bodyToMono(String.class)
//                .block(); // 실제로는 block()을 최소화하는 것이 좋습니다.
//    }
//}