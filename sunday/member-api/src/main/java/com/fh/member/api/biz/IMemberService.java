package com.fh.member.api.biz;

import com.fh.area.api.util.ServerResponse;
import com.fh.member.api.po.Member;

public interface IMemberService {
    Member queryUserNameByUserName(String userName);

    ServerResponse sms(String mobile);

    void addMember(Member member);
}
