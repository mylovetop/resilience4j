package io.github.resilience4j.service.test;


import java.io.IOException;

import org.springframework.stereotype.Component;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;

@CircuitBreaker(name = DummyService.BACKEND)
@RateLimiter(name = DummyService.BACKEND)
@Component
public class DummyServiceImpl implements DummyService {
    @Override
    public void doSomething(boolean throwBackendTrouble) throws IOException {
        if (throwBackendTrouble) {
            throw new IOException("Test Message");
        }
    }
}
