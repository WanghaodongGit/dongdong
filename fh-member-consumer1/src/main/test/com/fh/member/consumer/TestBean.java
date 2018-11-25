package com.fh.member.consumer;


import com.fh.util.SendHttpClient;
import com.fh.util.security.CheckSumBuilder;
import org.apache.commons.lang.RandomStringUtils;
import org.junit.Test;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class TestBean {
    @Test
    public void security(){
        Map<String,String> map = new HashMap();
        Map<String,String> headers = new HashMap();
        headers.put("appKey","dca9d44d7a7b45c89a3d54dd8f1e5485");
        String nonce = UUID.randomUUID().toString().replace("-","").toUpperCase()+RandomStringUtils.randomAlphanumeric(10);
        headers.put("nonce","nonce");
        long time = new Date().getTime();
        headers.put("time","1542725319251");
        String s = CheckSumBuilder.getCheckSum("dca9d44d7a7b45c89a3d54dd8f1e5485","nonce","time");
        SendHttpClient.sendGet("http://localhost:8444/findMember",map,headers);
        System.out.println(s);
    }
}
