package com.example.demo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

// 어노테이션
// @Table : 현재 클래스에서 DB를 연동할 때 클래스 이름과 동일한 테이블을 찾아서 자동으로 매핑하기 위한 어노테이션
// @Builder : 복잡한 생성자 대신 직관적이고 가독성 좋은 방식으로 객체를 생성하기 위한 준비

@Table
@Data
@Builder // 가독성 좋은 객체 생성하는 어노테이션의 라이브러리
@AllArgsConstructor
@NoArgsConstructor
public class Member {

    @Id // primary key로 지정하는 어노테이션
    private long id;
    private String name;
    private String email;
    private int age;
}
