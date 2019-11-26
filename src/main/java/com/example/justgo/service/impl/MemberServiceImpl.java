package com.example.justgo.service.impl;

import com.example.justgo.entity.Member;
import com.example.justgo.repository.MemberDao;
import com.example.justgo.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @Auther: YYF
 * @Date: 2019/9/19 12:04
 */
@Service
@Transactional
public class MemberServiceImpl implements MemberService {

    @Autowired
    private MemberDao memberDao;

    @Override
    public Member getMember(String mid) {
        System.out.println("mid" + mid);
        Member member = memberDao.getByMid(mid);
        return member;
    }
}
