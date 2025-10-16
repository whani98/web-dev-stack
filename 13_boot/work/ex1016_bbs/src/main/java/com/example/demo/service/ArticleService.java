package com.example.demo.service;

import com.example.demo.dto.ArticleDto;
import com.example.demo.model.Article;
import com.example.demo.repository.ArticleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ArticleService {

    private final ArticleRepository articleRepository;

    // Article(DB연동 객체)에서 가져온 정보를 화면에 보여주기 위해 DTO 타입으로 매핑하기 위한 메서드
    private ArticleDto mapToArticleDto(Article article){

        // 받은 값이 DTO형태로 바뀜
        return ArticleDto.builder().id(article.getId())
                                    .title(article.getTitle())
                                    .description(article.getDescription())
                                    .created(article.getCreated())
                                    .updated(article.getUpdated())
                                    .member_id(article.getMember_id())
                                    .build();
    }

    // 게시글 전체 조회
    public List<ArticleDto> findAll(){
        return articleRepository.findAll().stream().map(this::mapToArticleDto).toList(); // select * from article을 대신하는 코드
    }
    
    // id로 게시글 조회
    public ArticleDto findById(Long id){
        return articleRepository.findById(id).map(this::mapToArticleDto).orElseThrow();
    }
    
    // 새 글 등록
    public ArticleDto addNewArticle(Integer member_id, String title, String description){
        // 파라미터값 받은걸로 세팅
        Article article = new Article();
        article.setMember_id(member_id);
        article.setTitle(title);
        article.setDescription(description);
        article.setCreated(article.getCreated());
        article.setUpdated(article.getUpdated());

        // 세팅한 값을 insert(save)
        Article saveArticle = articleRepository.save(article);

        return mapToArticleDto(saveArticle);
    }

    // 게시글 수정
    public ArticleDto update(ArticleDto articleDto){

        // orElseThrow() : 없으면 예외처리
        Article article = articleRepository.findById(articleDto.getId()).orElseThrow(); // 이미 존재하는 아이디 가져오기
        article.setTitle(articleDto.getTitle()); // controller에서 변경된 값으로 변경
        article.setDescription(articleDto.getDescription()); // controller에서 변경된 값으로 변경
        article.setUpdated(article.getUpdated());

        // 세팅한 값을 update(수정)
        Article updateArticle = articleRepository.save(article);

        return mapToArticleDto(updateArticle);
    }

    // 게시글 삭제
    public void delete(Long id){
//       이것도 가능
//       Article article = articleRepository.findById(id).orElseThrow(); // 지울 게시글 아이디 가져오기
//       articleRepository.delete(article);

        articleRepository.deleteById(id);
    }
}
