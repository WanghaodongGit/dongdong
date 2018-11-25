package com.fh.member.security;

import com.fh.app.api.biz.IAppService;
import com.fh.member.annotation.Limit;
import com.fh.util.ServerResponse;
import com.fh.util.SystemEnum;
import com.fh.util.security.CheckSumBuilder;
import com.fh.util.security.RedisUtil;
import com.fh.util.security.WebContext;
import org.apache.commons.lang.RandomStringUtils;
import org.apache.http.protocol.ResponseServer;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.UUID;

public class Security {
    private static final long EXPIRE=60*1000;

    @Resource(name = "appService")
    private IAppService appService;

    public Object securityAspect(ProceedingJoinPoint pjp){
        HttpServletRequest request = WebContext.getRequest();
        String appKey = request.getHeader("appKey");
        String nonce = request.getHeader("nonce");
        String time = request.getHeader("time");
        String sign = request.getHeader("sign");
        //判断请求头信息
        if (StringUtils.isEmpty(appKey)|| StringUtils.isEmpty(time)||StringUtils.isEmpty(sign) || StringUtils.isEmpty(nonce)){
            return ServerResponse.error(SystemEnum.HEADER_HAS_NULL);
        }
        //判断时间
        if (Long.parseLong(time)+EXPIRE<System.currentTimeMillis()){
            return ServerResponse.error(SystemEnum.TIME_TIME_OUT);
        }
        //nonce失效
        boolean requestNonce =  RedisUtil.setExpire(nonce,60*1000);
        if (!requestNonce){
            return ServerResponse.error(SystemEnum.NONCE_ERROR);
        }

        //appkey是否正确
        String result = appService.findAppScrect(appKey);
        if (StringUtils.isEmpty(result)){

            return ServerResponse.error(SystemEnum.APPKEY_ERROR);
        }
        //验证签名
        String resultTime =  String.valueOf(new Date().getTime());
        String requestSign = CheckSumBuilder.getCheckSum(result,nonce,resultTime);
        if (!sign.equals(requestSign)){
            return ServerResponse.error(SystemEnum.SIGN_ERROR);
        }
        //通过ProceedingJoinPoint来获取我们的签名值
        MethodSignature signature = (MethodSignature) pjp.getSignature();
        //声明method通过MethodSignature来获取我们的方法名
        Method method = signature.getMethod();
        //通过我们的方法名来使我们的注解生效
        if (method.isAnnotationPresent(Limit.class)){
            //获取我们的2个自定义注解
            int maxCount = method.getAnnotation(Limit.class).maxCount();
            int seconds = method.getAnnotation(Limit.class).seconds();
            //获取我们的appkey+访问方法的方式+访问地址的路径
            String appkey = appKey+""+request.getMethod()+""+request.getRequestURI();
            //给我们每次执行的次数加入到我们的redis当中并设置失效时间
            long appExpire = RedisUtil.setAppExpire(appkey, seconds);
            if (appExpire>maxCount){
                return ServerResponse.error(SystemEnum.PORT_IMPOSE_FLOW);
            }
        }
        Object proceed=  null;
        try {
             proceed = pjp.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            return ServerResponse.error();
        }
        return proceed;
    }


    public static void main(String[] args) {
        long time = new Date().getTime();
        String nonce = UUID.randomUUID().toString().replace("-","").toUpperCase()+RandomStringUtils.randomAlphanumeric(10);
        System.out.println(CheckSumBuilder.getCheckSum("dca9d44d7a7b45c89a3d54dd8f1e5485",nonce,time+""));
        System.out.println(time);
    }

}
