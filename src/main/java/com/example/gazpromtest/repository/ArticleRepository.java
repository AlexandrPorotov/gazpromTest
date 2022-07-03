package com.example.gazpromtest.repository;

import com.example.gazpromtest.model.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ArticleRepository extends JpaRepository<Article,Long> {

    @Query("SELECT article FROM Article article WHERE article.title = ?1")
    Article getArticleByTitle(String title);

}
