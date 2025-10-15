package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor // 파라미터가 하나도 없는 constructor
public class Member {

    private long id;
    private String name;
    private String email;
    private int age;
}
