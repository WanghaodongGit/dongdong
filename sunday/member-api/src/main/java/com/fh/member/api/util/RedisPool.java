package com.fh.member.api.util;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class RedisPool {
    private static  JedisPool jedisPool= null;
    private static void initJedisPool(){
        JedisPoolConfig JedisPoolConfig = new JedisPoolConfig();
        JedisPoolConfig.setMaxTotal(1000);
        JedisPoolConfig.setMinIdle(100);
        JedisPoolConfig.setMaxIdle(100);
        JedisPoolConfig.setTestOnBorrow(true);
        JedisPoolConfig.setTestOnReturn(true);
        jedisPool = new JedisPool(JedisPoolConfig,"192.168.0.150",6379);
    }
    static {
        initJedisPool();
    }
    private RedisPool(){}
    public static Jedis getResource(){
        return jedisPool.getResource();
    }



}
