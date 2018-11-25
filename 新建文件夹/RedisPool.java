package com.fh.shop.api.util;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class RedisPool {

    private static JedisPool jedis = null;

    private static void initPool () {
        JedisPoolConfig poolConfig = new JedisPoolConfig();
        poolConfig.setMaxTotal(1000);
        poolConfig.setMaxIdle(100);
        poolConfig.setMinIdle(100);
        poolConfig.setTestOnBorrow(true);
        poolConfig.setTestOnReturn(true);
        jedis = new JedisPool(poolConfig,"192.168.1.169",6379);
    }

    static{
        initPool();
    }

    public static Jedis getInstance() {
        return jedis.getResource();
    }

    private RedisPool() {

    }

}
