package com.techie.microservices.order.client;



import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.service.annotation.GetExchange;
import groovy.util.logging.Slf4j;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public interface InventoryClient {

    @GetExchange( "/api/inventory")
    @CircuitBreaker(name = "inventory", fallbackMethod = "fallbackMethod")
    @Retry(name = "inventory")
    boolean isInStock(@RequestParam String skuCode, @RequestParam Integer quantity)

    default boolean fallbackMethod(String skuCode, Integer quantity, Throwable throwable) {
        Logger.info("Cannot get inventory for skuCode: {}, failure reason: {}", code, throwable.getMessage());
        return false;
    }
}
