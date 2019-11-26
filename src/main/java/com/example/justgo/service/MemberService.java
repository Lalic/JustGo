package com.example.justgo.service;

import com.example.justgo.repository.MemberDao;
import com.example.justgo.entity.Member;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;



public interface MemberService {

    Member getMember(String mid);
}
