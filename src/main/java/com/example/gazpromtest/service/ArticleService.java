package com.example.gazpromtest.service;

import com.example.gazpromtest.gson.ArticleSerializer;
import com.example.gazpromtest.model.Article;
import com.example.gazpromtest.model.CountForCategory;
import com.example.gazpromtest.repository.ArticleRepository;
import com.example.gazpromtest.repository.CategoryRepository;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.List;

/**@author Alexandr Porotov
 * <p>Сервис реализующий выдачу данных в формате JSON</p>
 * @see Article
 * @see ArticleSerializer
 * @see com.example.gazpromtest.controller.ArticleController*/
@Service
@AllArgsConstructor
public class ArticleService {

    private final ArticleRepository articleRepository;
    private final CategoryRepository categoryRepository;

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

    public String getStatisticByCategory() {
       List<CountForCategory> statistic = categoryRepository.getStatisticCategories();
       Gson g = new GsonBuilder()
               .setPrettyPrinting()
               .create();
       Type listType = new TypeToken<List<CountForCategory>>() {}.getType();
       return g.toJson(statistic, listType);
    }

}
