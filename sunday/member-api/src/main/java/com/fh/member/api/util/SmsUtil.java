package com.fh.member.api.util;

import org.apache.commons.lang3.RandomStringUtils;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class SmsUtil {
    public static String sendSms(String mobile){
        //设置参数
        Map map = new HashMap();//13461073852
        map.put("mobile",mobile);
        map.put("templateid",Systemconst.TEMPLATEID);
        //设置头信息
        String date = new Date().getTime() + "";
        String randonNonce = RandomStringUtils.randomAlphabetic(10);
        Map headerMap = new HashMap();
        headerMap.put("AppKey",Systemconst.APPKEY);
        headerMap.put("Nonce",randonNonce);
        headerMap.put("CurTime",date);
        headerMap.put("CheckSum",CheckSumBuilder.getCheckSum(Systemconst.APPSECRET, randonNonce, date));

        String msg = HttpClientUtil.sendPost(Systemconst.SMSURL, map, headerMap);
        return msg;
    }
}
