package com.example.gazpromtest.repository;

import com.example.gazpromtest.model.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<Article,Long> {

}
