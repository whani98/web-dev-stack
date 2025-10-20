package com.example.demo.dao;

import com.example.demo.vo.ArticleVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ArticleDAO {

    // 전체글 조회
    List<ArticleVO> selectAll(); // 이름이 동일한 mapper가 실행됨
    
    // 게시글 상세보기
    ArticleVO showView(Integer id);

    // 새 글 등록
    int newArticle(ArticleVO vo);

    // 게시글 삭제
    void deleteArticle(Integer id);

    // 게시글 수정
    int updateArticle(ArticleVO vo);

}
