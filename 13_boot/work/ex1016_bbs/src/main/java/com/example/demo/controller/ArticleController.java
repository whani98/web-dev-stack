package com.example.demo.controller;

import com.example.demo.dto.ArticleDto;
import com.example.demo.model.Article;
import com.example.demo.service.ArticleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/article")
@RequiredArgsConstructor
public class ArticleController {

    // Service 가져오기
    private final ArticleService articleService;

    @GetMapping(value={"", "/list"})
    public String getArticleList(Model model){

        // Service에서 findAll 리스트 형태로 가져오기
        List<ArticleDto> articles = articleService.findAll();

        model.addAttribute("articles", articles); // 바인딩
        return "article-list"; // 포워딩
    }
    
    // 게시글 상세보기
    @GetMapping("/content")
    public String getArticle(Model model, Long id){

        model.addAttribute("article", articleService.findById(id)); // 바인딩
        return "article-content";// 포워딩
    }

    // 새 글 작성 페이지로 이동
    @GetMapping("/add")
    public String articleAdd(Model model, Integer member_id){

        model.addAttribute("member_id", member_id);
        return "article-add";
    }
    
    // 새 글 등록
    @PostMapping("/add")
    public String postAdd(Integer member_id, String title, String description){ // dto로 받아도 가능

        articleService.addNewArticle(member_id, title, description);
        return "redirect:/article/list";
    }

    // 수정을 원하는 게시글 검색
    @GetMapping("/edit")
    public String getEdit(Model model, Long id){

        ArticleDto dto = articleService.findById(id);
        model.addAttribute("dto", dto); // 바인딩
        return "article-edit"; // 포워딩
    }

    // 게시글 변경사항 적용(수정)
    @PostMapping("/update")
    public String postUpdate(ArticleDto dto){
        
        // 수정할 게시글의 id에 해당하는 dto 조회
        ArticleDto articleDto = articleService.findById(dto.getId()); // 수정 전 게시물
        articleDto.setTitle(dto.getTitle());
        articleDto.setDescription(dto.getDescription());

        // Service에 새로운 정보 전송
        articleService.update(articleDto);

        return "redirect:/article/list";
    }

    // 게시글 삭제
    @GetMapping("/delete")
    public String getDelete(Long id){

        articleService.delete(id);
        return "redirect:/article/list";
    }
}
