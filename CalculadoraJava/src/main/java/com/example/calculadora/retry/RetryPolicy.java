package com.example.calculadora.retry;

import java.util.function.Supplier;

public class RetryPolicy {

    private final int maxAttempts;
    private final long waitMs;

    public RetryPolicy(int maxAttempts, long waitMs) {
        this.maxAttempts = maxAttempts;
        this.waitMs = waitMs;
    }

    public <T> T execute(Supplier<T> action) throws Exception {

        Exception lastException = null;

        for (int attempt = 1; attempt <= maxAttempts; attempt++) {
            try {
                return action.get();
            }
            catch (Exception e) {
                lastException = e;
                System.out.println("Tentativa " + attempt + " falhou. Retentando...");
                Thread.sleep(waitMs);
            }
        }

        throw lastException;
    }
}
