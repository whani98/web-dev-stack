package com.example.demo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MemberRepository extends CrudRepository<Member, Long> {
    // CrudRepository : 따로 sql문을 작성하지 않고, >>생성, 조회, 수정, 삭제<< 기능을 제공하는 인터페이스
    
    // CrudRepository가 제공하는 기본 crud 메서드
    // 1) save() : 생성(insert) 및 수정(update)
    // 2) findById(), findAll() : 조회(select)
    // 3) deleteById(), deleteAll() : 삭제(delete)
    // 4) count() : 전체 행수 조회
    List<Member> findByName(String name);

    // 유사검색(like) 조회 - findByNameContaining 사용
    List<Member> findByNameContaining(String name);

    // 이름으로 삭제
    int deleteByName(String name);
}
