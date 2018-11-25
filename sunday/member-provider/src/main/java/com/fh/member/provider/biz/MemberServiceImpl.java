package com.fh.member.provider.biz;

import com.fh.area.api.util.ServerResponse;
import com.fh.area.api.util.SystemEnum;
import com.fh.log.api.biz.ILogService;
import com.fh.log.api.po.Log;
import com.fh.member.api.biz.IMemberService;
import com.fh.member.api.po.Member;
import com.fh.member.api.util.RedisUtil;
import com.fh.member.api.util.SmsUtil;
import com.fh.member.provider.mapper.IMemberMapper;
import com.google.gson.Gson;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("memberService")
public class MemberServiceImpl implements IMemberService {
    @Autowired
    private IMemberMapper memberMapper;

    @Resource(name = "logService")
    private ILogService logService;

    @Override
    public Member queryUserNameByUserName(String userName) {
        return memberMapper.queryUserNameByUserName(userName);
    }


    public ServerResponse sms(String mobile) {
        /*if(StringUtils.isEmpty(mobile)){
            return ServerResponse.error(SystemEnum.SMS_MOBILE_NULL);
        }
        if(mobile.length() != 11){
            return ServerResponse.error(SystemEnum.SMS_MOBILE_INVALID);
        }
        String result = SmsUtil.sendSms(mobile);
        Gson gson = new Gson();
        Map map = gson.fromJson(result, Map.class);
        int code = ((Double) map.get("code")).intValue();
        String message = (String) map.get("msg");
        String phoneCode = (String) map.get("obj");
        if (200 != code) {
            return ServerResponse.error(-1,"调用网易云信接口失败"+message);
        }
        RedisUtil.set(mobile,phoneCode);
        RedisUtil.expire(mobile,60);*/
        return ServerResponse.success();
    }

    @Override
    public void addMember(Member member) {
        memberMapper.addMember(member);
        Log log = new Log();
        log.setInfo("注册会员  账号是："+member.getUserName());
        logService.addLog(log);

    }
}
