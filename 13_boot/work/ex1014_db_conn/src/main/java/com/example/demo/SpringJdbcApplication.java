package com.example.demo;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component // 가장 먼저 실행 자식 어노테이션 -> ㄴ@Controller ㄴ@Repository ㄴ@Service
@RequiredArgsConstructor // public SpringJdbcApplication(MemberRepository memberRepository)를 생성하는 것과 같다
@Slf4j

public class SpringJdbcApplication implements ApplicationRunner {

    private final MemberRepository memberRepository;
    
    // implements ApplicationRunner 작성 후 alt + Enter
    @Override
    public void run(ApplicationArguments args) throws Exception {

        log.info("{}", "hello run");

        // create(insert)
//        Member member = Member.builder().name("lim")
//                                        .email("hgd@a.com")
//                                        .age(20)
//                                        .build(); // 생성하겠다!
//
//        memberRepository.save(member); // memberRepository한테 member 객체를 만들어달라고 할거야~
//        // update
//        member.setAge(60); // 나이 수정
//        memberRepository.save(member); // 수정된 정보로 저장
        
        // 이름으로 조회
        List<Member> members = memberRepository.findByName("홍길동"); // 홍길동이라는 이름을 찾아 list에 넣음
        if(members.isEmpty()){

            log.info("홍길동이라는 이름의 회원이 없습니다.");
            
        }else{

            for(Member member : members){
                log.info("조회된 회원 {}", member);
            }
        }
        
        // 이름에 a가 포함되어있는 데이터를 조회
        log.info("포함여부{}", memberRepository.findByNameContaining("a"));

        // 이름으로 삭제
        int res = memberRepository.deleteByName("홍길동");

    } // run
}
