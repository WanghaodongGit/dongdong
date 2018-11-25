package com.fh.member.api.util;

import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class HttpClientUtil {

    public static String sendPost(String url,Map<String,String> params,Map<String,String> header){
        CloseableHttpClient client = HttpClientBuilder.create().build();
        HttpPost httpPost = new HttpPost(url);

        if(params!=null&&params.size()>0){
            List<NameValuePair> list = new ArrayList<NameValuePair>();
            Iterator<Map.Entry<String, String>> iterator = params.entrySet().iterator();
            while (iterator.hasNext()){
                Map.Entry<String, String> next = iterator.next();
                String key = next.getKey();
                String value = next.getValue();
                list.add(new BasicNameValuePair(key,value));
            }
            try {
                UrlEncodedFormEntity urlEncodedFormEntity = new UrlEncodedFormEntity(list);
                httpPost.setEntity(urlEncodedFormEntity);
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        if(header!=null&&header.size()>0){
            Iterator<Map.Entry<String, String>> iterator = header.entrySet().iterator();
                while (iterator.hasNext()){
                    Map.Entry<String, String> next = iterator.next();
                    String key = next.getKey();
                    String value = next.getValue();
                    httpPost.addHeader(key,value);
                }
        }
        String msg = null;
        CloseableHttpResponse response=null;
        try {
            response = client.execute(httpPost);
            msg= EntityUtils.toString(response.getEntity(), "utf-8");
        } catch (IOException e) {
            e.printStackTrace();
        }finally {

                try {
                    if(response!=null){
                        response.close();
                        response=null;
                    }
                    if(httpPost!=null){
                        httpPost.releaseConnection();
                    }
                    if(client!=null){
                        client.close();
                        client=null;
                    }
                } catch (IOException e) {
                    e.printStackTrace();
            }
        }
        return msg;
    }
}
