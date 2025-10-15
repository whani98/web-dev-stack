package com.example.demo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.web.WebProperties;

@Entity
@Table(name = "article")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title", length = 100) // varchar(100)
    private String title;

    @Column(name = "description", length = 4096)
    private String description;

    @ManyToOne // 다 대 일
    @JoinColumn(name = "memberId")
    private Member member;
}
