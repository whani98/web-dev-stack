package com.example.demo;

import com.example.demo.mapper.ArticleMapper;
import com.example.demo.mapper.MemberMapper;
import com.example.demo.model.Member;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lombok.extern.slf4j.XSlf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor // mapper를 갖다 써야할 때 알아서 생성자 파라미터로 받도록 하는 어노테이션
@Slf4j

public class MybatisApplication implements ApplicationRunner {

    private final MemberMapper memberMapper;
    private final ArticleMapper articleMapper;

    // implements ApplicationRunner 작성 후 alt + Enter 메서드 구현
    @Override
    public void run(ApplicationArguments args) throws Exception {

        int count = memberMapper.selectAllCount();
        log.info("member count:{}", count);
        // .orElseThrow() : 예외 처리
        Member member = memberMapper.selectByEmail("hong@a.com").orElseThrow();
        log.info("Member:{}", member);

    }
}
