package com.fh.member.consumer.controller;

import com.fh.area.api.biz.IAreaService;
import com.fh.area.api.util.ServerResponse;
import com.fh.area.api.util.SystemEnum;
import com.fh.member.api.biz.IMemberService;
import com.fh.member.api.po.Member;
import com.fh.member.api.util.RedisUtil;
import com.fh.member.api.util.SmsUtil;
import com.google.gson.Gson;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@RestController
public class MemberController {
    @Resource(name = "areaServoce")
    private IAreaService areaService;

    @Resource(name = "memberServoce")
    private IMemberService memberServoce;

    @RequestMapping("/queryArea")
    public ServerResponse queryArea(Integer id){
        List areaList = areaService.queryArea(id);
        System.err.println(areaList);
        return ServerResponse.success(areaList);
    }

    @RequestMapping("/queryUserNameByUserName")
    public ServerResponse queryUserNameByUserName(String userName) {
        if(StringUtils.isEmpty(userName)){
            return ServerResponse.error(SystemEnum.USERNAME_NULL);
        }
        Member dbmember = memberServoce.queryUserNameByUserName(userName);
        if(dbmember!=null){
            return ServerResponse.error(SystemEnum.USERNAME_EXISTS);
        }
        return ServerResponse.success();
    }

    @RequestMapping("/sendSMS")
    public ServerResponse sms(String mobile){
        return memberServoce.sms(mobile);
    }
    @RequestMapping("/addMember")
    public ServerResponse addMember(Member member){
        memberServoce.addMember(member);
        return ServerResponse.success();
    }

}
