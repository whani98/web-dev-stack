package com.example.demo.controller;

import com.example.demo.model.Member;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Controller
public class ExpressionController {

    private final List<Member> members = List.of(new Member("hong", "h@a.com", 50),
                                                new Member("kim", "k@a.com", 40)
                                         );

    @GetMapping("/object")
    public String getMember(Model model){

        model.addAttribute("money", 2100000000);

        Date date = Calendar.getInstance().getTime();
        model.addAttribute("date", date);

        model.addAttribute("member", members);
        return "express/object";
    }

    @GetMapping("/link")
    public String getLink(Model model){

        model.addAttribute("id", 1);
        return "express/link";
    }

    @GetMapping("/member")
    public String getIdParam(Integer id, Model model){

        if(id != null){
            model.addAttribute("p_mem", members.get(id));
        } else{
            model.addAttribute("p_mem", members.get(0));
        }

        return "express/member_fin";
    }

    @GetMapping("/member/{id}")
    public String getIdparam2(@PathVariable Integer id, Model model){

        if(id != null){
            model.addAttribute("p_mem", members.get(id));
        } else {
            model.addAttribute("p_mem", members.get(0));
        }

        return "express/member_fin";
    }
}
