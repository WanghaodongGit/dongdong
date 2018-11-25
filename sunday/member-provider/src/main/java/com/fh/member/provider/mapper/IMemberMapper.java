package com.fh.member.provider.mapper;

import com.fh.member.api.po.Member;

public interface IMemberMapper {
    Member queryUserNameByUserName(String userName);

    void addMember(Member member);
}
