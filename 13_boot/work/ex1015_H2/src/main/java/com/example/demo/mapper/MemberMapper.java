package com.example.demo.mapper;

import com.example.demo.model.Member;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper
public interface MemberMapper {

    // mapper.xml의 <select id="selectAll">와 이름을 맞춰야한다.
    List<Member> selectAll();
    int selectAllCount();
    
    // 이메일 조회
    // 이메일로 검색한 결과가 한 건도 없다면, Optional.empty()를 반환
    Optional<Member> selectByEmail(String email);
}
