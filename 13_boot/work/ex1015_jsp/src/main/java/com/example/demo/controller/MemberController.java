package com.example.demo.controller;

import com.example.demo.model.Member;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class MemberController {

    // id에서 1l에서 l은 long을 의미
    private List<Member> members = List.of(new Member(1l, "홍길동", "hong@a.com", 10),
                                           new Member(2l, "김길동", "kim@a.com", 20),
                                           new Member(3l, "이길동", "lee@a.com", 30),
                                           new Member(4l, "박길동", "park@a.com", 40)
    );


    @GetMapping("/member/list")
    public String getMembers(Model model){

        model.addAttribute("members", members);
        return "member-list";
    }
}
