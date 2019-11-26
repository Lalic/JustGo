package com.example.justgo.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.justgo.entity.Member;
import com.example.justgo.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * @auth chejiahui
 * @date 2019/9/18 17:45
 */
@RestController  //RestController 包含了Controller和ResponseBody
@RequestMapping(method = {RequestMethod.GET,RequestMethod.POST}, value = "/member")
public class MemberController {
    @Resource
   private MemberService memberService; //记得写private
    @Autowired
    private RedisTemplate redisTemplate;
    @RequestMapping("/show")
    public String showMember(HttpServletRequest request){
        System.out.println("傻逼sb车家辉");
        System.out.println("mid"+memberService.getMember(request.getParameter("mid")).toString());
        Member member =memberService.getMember(request.getParameter("mid"));
        redisTemplate.opsForValue().set("cjh",member);
        return JSONObject.toJSONString(member);

    }
}
