package com.example.calculadora.client;

import com.example.calculadora.retry.RetryPolicy;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Component
public class CalculadoraHttpClient {

    private final WebClient client =
        WebClient.builder().baseUrl("http://localhost:8080").build();

    public double enviarOperacao(double a, double b, String op) throws Exception {

        RetryPolicy retry = new RetryPolicy(3, 1000);

        return retry.execute(() ->
            client.post()
                .uri("/calcular")
                .bodyValue("a=" + a + "&b=" + b + "&op=" + op)
                .header("Content-Type", "application/x-www-form-urlencoded")
                .retrieve()
                .bodyToMono(Double.class)
                .block()
        );
    }
}
