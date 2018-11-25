package com.fh.shop.api.util;

import redis.clients.jedis.Jedis;

public class RedisUtil {

    public static void set (String key, String value) {
        Jedis jedis = null;
        try {
            jedis = RedisPool.getInstance();
            jedis.set(key, value);
        } finally {
            if(null!=jedis) {
                jedis.close();
                jedis=null;
            }
        }

    }

    public static void expire (String key, int seconds) {
        Jedis jedis = null;
        try {
            jedis = RedisPool.getInstance();
            jedis.expire(key, seconds);
        } finally {
            if(null!=jedis) {
                jedis.close();
                jedis=null;
            }
        }

    }

    public static String get (String key) {
        String result = "";
        Jedis jedis = null;
        try {
            jedis = RedisPool.getInstance();
            result=jedis.get(key);
        } finally {
            if(null!=jedis) {
                jedis.close();
                jedis=null;
            }
        }
        return result;
    }

}
