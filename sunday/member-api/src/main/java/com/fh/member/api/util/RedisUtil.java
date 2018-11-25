package com.fh.member.api.util;

import redis.clients.jedis.Jedis;

public class RedisUtil {

    public static  void del(String key){
        Jedis jedis = null;
        try{
            jedis = RedisPool.getResource();
            jedis.del(key);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(jedis!=null){
                jedis.close();
                jedis=null;
            }
        }
    }
    public static void set(String key,String value){
        Jedis jedis = null;
        try{
            jedis = RedisPool.getResource();
            jedis.set(key,value);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(jedis!=null){
                jedis.close();
                jedis=null;
            }
        }

    }
    public static  void expire(String key,int time){
        Jedis jedis=null;
        try{
            jedis = RedisPool.getResource();
            jedis.expire(key,time);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(jedis!=null){
                jedis.close();
                jedis=null;
            }
        }
    }

    public static String get(String key){
        Jedis jedis = null;
        String result = "";
        try{
            jedis = RedisPool.getResource();
            result = jedis.get(key);
        }catch (Exception e){
            e.printStackTrace();
            return result;
        }finally {
            if(jedis!=null){
                jedis.close();
                jedis=null;
            }
        }
        return result;
    }


}
