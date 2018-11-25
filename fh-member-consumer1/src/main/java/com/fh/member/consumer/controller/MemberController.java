package com.fh.member.consumer.controller;


import com.fh.member.annotation.Limit;
import com.fh.member.api.biz.IMemberService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class MemberController {

    @Resource(name = "memberService")
    private IMemberService memberService;

    @Limit(maxCount = 3,seconds = 10)
    @RequestMapping(value = "/findMember",method = RequestMethod.GET)
    public String  findMember(){
        System.out.println(123456);
        return  "555";
    }

}
