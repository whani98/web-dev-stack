package com.example.demo.repository;

import com.example.demo.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
    //findMember("홍길동")
    // # 대신에 : 사용
    // Member로 쓸것! (table 명이 아닌 class 명으로)
    @Query("SELECT m FROM Member m where m.name=:name")
    List<Member> findMember(String name);
}
