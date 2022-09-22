package com.example.rewardyourteachersq011bjavapode.utils;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class RestClientProvider {
    WebClient webClient;
    public void init() {
         webClient = WebClient.builder()
                .baseUrl("https://api.paystack.co/transaction/verify/")
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .build();
    }
//    blockingHelloWorld()
//  .subscribe(result -> assertEquals(expected, result));

//
}
