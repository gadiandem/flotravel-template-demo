package com.flocash.flotravel.demo.service;

import com.flocash.flotravel.demo.dto.common.AuthBasic;
import io.netty.channel.ChannelOption;
import io.netty.handler.timeout.ReadTimeoutHandler;
import io.netty.handler.timeout.WriteTimeoutHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.client.reactive.ClientHttpConnector;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.netty.http.client.HttpClient;
import reactor.netty.resources.ConnectionProvider;

import javax.annotation.PostConstruct;
import java.time.Duration;
import java.util.Base64;
import java.util.concurrent.TimeUnit;

import static com.flocash.flotravel.demo.constant.FlotravelConstant.FLOTRAVEL_TEST_DOMAIN;

@Service
@Slf4j
public class WebClientServiceImp implements WebClientService {
    private final int timeout = 15000;
    private HttpClient httpClient;

    @PostConstruct
    public void setUpTimeout() {
        httpClient = HttpClient.create()
                .option(ChannelOption.CONNECT_TIMEOUT_MILLIS, timeout)
                .responseTimeout(Duration.ofMillis(timeout))
                .doOnConnected(conn ->
                        conn.addHandlerLast(new ReadTimeoutHandler(timeout, TimeUnit.MILLISECONDS))
                                .addHandlerLast(new WriteTimeoutHandler(timeout, TimeUnit.MILLISECONDS)));
    }

    @Override
    public WebClient requestDefault() {
        return WebClient.builder()
                .clientConnector(new ReactorClientHttpConnector(httpClient))
                .baseUrl(FLOTRAVEL_TEST_DOMAIN)
                .build();
    }

    @Override
    public WebClient retRequestWithEndpoint(String endpoint) {
        return WebClient.builder()
                .clientConnector(new ReactorClientHttpConnector(httpClient))
                .baseUrl(endpoint)
                .build();
    }

    @Override
    public WebClient requestAuthBasic(String endpoint, AuthBasic authBasic) {
        String authorization = basicAuth(authBasic);
        return WebClient.builder()
                .clientConnector(new ReactorClientHttpConnector(httpClient))
                .baseUrl(endpoint)
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .defaultHeader(HttpHeaders.AUTHORIZATION, authorization)
                .build();
    }

    @Override
    public WebClient requestAuthBasicFormUrlEncoded(String endpoint, AuthBasic authBasic) {
        String authorization = basicAuth(authBasic);
        return WebClient.builder()
                .clientConnector(new ReactorClientHttpConnector(httpClient))
                .baseUrl(endpoint)
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_FORM_URLENCODED_VALUE)
                .defaultHeader(HttpHeaders.AUTHORIZATION, authorization)
                .build();
    }

    private String basicAuth(AuthBasic authBasic) {
        String auth = authBasic.getUserName() + ":" + authBasic.getPassword();
        String BasicBase64format = Base64.getEncoder().encodeToString(auth.getBytes());
        return "Basic " + BasicBase64format;
    }
}
