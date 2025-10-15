package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Article {

    private long id; // 작성글 번호
    private String title; // 제목
    private String description; // 내용
    private Date created; // 생성일
    private Date updated; // 수정일
    private long memberId; // 작성자 번호

}
