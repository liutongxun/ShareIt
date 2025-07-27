package com.liu.club.gateway.redis;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * RedisUtil Utility Class
 *
 * @author: Liu Tongxun
 * @date: 2025/07/27
 */
@Component
@Slf4j
public class RedisUtil {

    @Resource
    private RedisTemplate redisTemplate;

    private static final String CACHE_KEY_SEPARATOR = ".";

    /**
     * Build a cache key by joining multiple string parts with a separator.
     *
     * @param parts the pieces to join into a single cache key
     * @return the concatenated cache key
     */
    public String buildKey(String... parts) {
        return Stream.of(parts)
                .collect(Collectors.joining(CACHE_KEY_SEPARATOR));
    }

    /**
     * Check whether a given key exists in Redis.
     *
     * @param key the cache key to check
     * @return true if the key exists, false otherwise
     */
    public boolean exist(String key) {
        return redisTemplate.hasKey(key);
    }

    /**
     * Delete a key from Redis.
     *
     * @param key the cache key to delete
     * @return true if the key was removed, false if it did not exist
     */
    public boolean del(String key) {
        return redisTemplate.delete(key);
    }

    /**
     * Store a string value in Redis without an expiration time.
     *
     * @param key   the cache key under which the value is stored
     * @param value the string value to store
     */
    public void set(String key, String value) {
        redisTemplate.opsForValue().set(key, value);
    }

    /**
     * Store a string value in Redis with an expiration time, only if the key does not already exist.
     *
     * @param key       the cache key under which the value is stored
     * @param value     the string value to store
     * @param timeout   the duration after which the key will expire
     * @param timeUnit  the time unit of the timeout
     * @return true if the value was set successfully, false if the key already exists
     */
    public boolean setNx(String key, String value, Long timeout, TimeUnit timeUnit) {
        return redisTemplate.opsForValue().setIfAbsent(key, value, timeout, timeUnit);
    }

    /**
     * Retrieve a string value from Redis by its key.
     *
     * @param key the cache key to retrieve
     * @return the stored string value, or null if not found
     */
    public String get(String key) {
        return (String) redisTemplate.opsForValue().get(key);
    }

    /**
     * Add an element with a score to a Redis sorted set (ZSet).
     *
     * @param key   the sorted set key
     * @param value the element to add
     * @param score the score used for ordering
     * @return true if the element was added, false otherwise
     */
    public Boolean zAdd(String key, String value, Long score) {
        return redisTemplate.opsForZSet().add(key, value, score.doubleValue());
    }

    /**
     * Get the size of a Redis sorted set.
     *
     * @param key the sorted set key
     * @return the number of elements in the sorted set
     */
    public Long countZset(String key) {
        return redisTemplate.opsForZSet().size(key);
    }

    /**
     * Retrieve a range of elements from a sorted set by index.
     *
     * @param key   the sorted set key
     * @param start the start index (inclusive)
     * @param end   the end index (inclusive)
     * @return the set of elements in the specified index range
     */
    public Set<String> rangeZset(String key, long start, long end) {
        return redisTemplate.opsForZSet().range(key, start, end);
    }

    /**
     * Remove a specific element from a Redis sorted set.
     *
     * @param key   the sorted set key
     * @param value the element to remove
     * @return the number of elements removed (0 or 1)
     */
    public Long removeZset(String key, Object value) {
        return redisTemplate.opsForZSet().remove(key, value);
    }

    /**
     * Remove multiple elements from a Redis sorted set.
     *
     * @param key    the sorted set key
     * @param values the set of elements to remove
     */
    public void removeZsetList(String key, Set<String> values) {
        values.forEach(v -> redisTemplate.opsForZSet().remove(key, v));
    }

    /**
     * Get the score associated with an element in a sorted set.
     *
     * @param key   the sorted set key
     * @param value the element whose score to retrieve
     * @return the score of the element, or null if not present
     */
    public Double score(String key, Object value) {
        return redisTemplate.opsForZSet().score(key, value);
    }

    /**
     * Retrieve elements from a sorted set whose scores fall within the given range.
     *
     * @param key   the sorted set key
     * @param min   the minimum score (inclusive)
     * @param max   the maximum score (inclusive)
     * @return the set of elements with scores in the specified range
     */
    public Set<String> rangeByScore(String key, long min, long max) {
        return redisTemplate.opsForZSet().rangeByScore(key, (double) min, (double) max);
    }

    /**
     * Increment the score of an element in a sorted set by a given amount.
     *
     * @param key   the sorted set key
     * @param value the element whose score to increment
     * @param delta the amount to add to the existing score
     * @return the new score of the element
     */
    public Double addScore(String key, Object value, double delta) {
        return redisTemplate.opsForZSet().incrementScore(key, value, delta);
    }

    /**
     * Get the rank (index) of an element in a sorted set.
     *
     * @param key   the sorted set key
     * @param value the element whose rank to retrieve
     * @return the zero-based rank of the element, or null if not present
     */
    public Long rank(String key, Object value) {
        return redisTemplate.opsForZSet().rank(key, value);
    }

}
