package com.example.gazpromtest.service;

import com.example.gazpromtest.gson.ArticleSerializer;
import com.example.gazpromtest.gson.AuxiliaryTextSerializer;
import com.example.gazpromtest.gson.CategorySerializer;
import com.example.gazpromtest.model.Article;
import com.example.gazpromtest.model.AuxiliaryText;
import com.example.gazpromtest.model.Category;
import com.example.gazpromtest.repository.ArticleRepository;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
@AllArgsConstructor
public class ArticleService {

    private final ArticleRepository articleRepository;
    private final ImportService importService;

   public String getArticleByTitlePretty(String response){
       Gson g = new GsonBuilder()
               .setPrettyPrinting()
               .registerTypeAdapter(Article.class, new ArticleSerializer())
               .create();
       Article article = articleRepository.getArticleByTitle(response);
       return g.toJson(article);
   }
    public String getArticleByTitle(String response){
       Gson g = new GsonBuilder()
               .registerTypeAdapter(Article.class, new ArticleSerializer())
               .create();
       Article article = articleRepository.getArticleByTitle(response);
        return g.toJson(article);
    }


}
