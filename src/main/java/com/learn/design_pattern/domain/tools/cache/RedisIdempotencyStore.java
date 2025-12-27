package com.learn.design_pattern.domain.tools.cache;

import com.learn.design_pattern.domain.dto.PaymentResult;
import com.learn.design_pattern.domain.tools.IdempotencyStore;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.util.Optional;

@Component
public class RedisIdempotencyStore implements IdempotencyStore {

    private final RedisTemplate<String, PaymentResult> redisTemplate;

    public RedisIdempotencyStore(RedisTemplate<String, PaymentResult> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    @Override
    public Optional<PaymentResult> get(String key) {
        return Optional.ofNullable(redisTemplate.opsForValue().get(key));
    }

    @Override
    public void save(String key, PaymentResult paymentResult) {
        redisTemplate.opsForValue().set(key, paymentResult, Duration.ofMinutes(10L));
    }
}
