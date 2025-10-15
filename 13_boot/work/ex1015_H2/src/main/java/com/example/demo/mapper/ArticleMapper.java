package com.example.demo.mapper;

import com.example.demo.model.Article;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ArticleMapper {

    @Select("select * from article")
    List<Article> selectAll();
}
