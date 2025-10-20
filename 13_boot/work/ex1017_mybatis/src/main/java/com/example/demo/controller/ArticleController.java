package com.example.demo.controller;

import com.example.demo.dao.ArticleDAO;
import com.example.demo.vo.ArticleVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class ArticleController {

    private final ArticleDAO articleDAO;

    @GetMapping(value={"/", "/list"})
    public String getArticleList(Model model){

        List<ArticleVO> articles = articleDAO.selectAll();
        model.addAttribute("articles", articles); // 바인딩

        return "article-list"; // 포워딩
    }

    // 게시글 상세보기
    @GetMapping("/content")
    public String getView(Model model, Integer id){

        ArticleVO vo = articleDAO.showView(id);
        model.addAttribute("vo", vo);

        return "article-content";
    }

    // 새 글 작성
    @GetMapping("/add")
    public String newArticleForm(Model model, Integer member_id){

        // 새 글 작성 페이지로 member_id를 가지고 전환
        model.addAttribute("member_id", member_id); // 바인딩
        return "article-add"; // 포워딩
    }
    
    // 새 글 작성
    @PostMapping("/add")
    public String postNoewArticle(ArticleVO vo){

        articleDAO.newArticle(vo);

        return "redirect:/list";
    }

    // 게시글 삭제
    @GetMapping("/delete")
    public String getDelete(Integer id){

        articleDAO.deleteArticle(id);
        return "redirect:/list";
    }

    // 게시글 수정페이지로 이동
    @GetMapping("/edit")
    public String getEdit(Model model, Integer id){

        ArticleVO vo = articleDAO.showView(id);
        model.addAttribute("vo", vo); // 바인딩
        return "article-update"; // 수정 전 정보 포워딩
    }

    // 게시글 수정
    @PostMapping("/update")
    public String postUpdate(ArticleVO vo){

        ArticleVO articleVO = articleDAO.showView(vo.getId()); // 수정 전 게시물
        articleVO.setTitle(vo.getTitle());
        articleVO.setDescription(vo.getDescription());

        articleDAO.updateArticle(articleVO);

        return "redirect:/list";
    }

}
