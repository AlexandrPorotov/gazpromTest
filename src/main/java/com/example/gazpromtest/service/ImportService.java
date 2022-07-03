package com.example.gazpromtest.service;

import com.example.gazpromtest.DTO.*;
import com.example.gazpromtest.model.Article;
import com.example.gazpromtest.model.AuxiliaryText;
import com.example.gazpromtest.model.Category;
import com.example.gazpromtest.repository.ArticleRepository;
import com.example.gazpromtest.repository.AuxiliaryTextRepository;
import com.example.gazpromtest.repository.CategoryRepository;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class ImportService {

    private final ArticleRepository articleRepository;
    private final AuxiliaryTextRepository auxiliaryTextRepository;
    private final CategoryRepository categoryRepository;

    private static final String PATH = "E:\\PROJECTS\\gazpromTest\\src\\main\\resources\\static\\aawiki-20220627-cirrussearch-general.json";

    public void saveDataFromJson() throws IOException {
        List<String> gson = Files.readAllLines(Paths.get(PATH));

        Gson g = new GsonBuilder()
                .setDateFormat("\"yyyy-MM-dd'T'HH:mm:ss'Z'\"")
                .create();

        for(String s : gson) {
            if(!s.contains("{\"index\":{\"_type\":")) {

                ArticleDTO articleFromJson = g.fromJson(s, ArticleDTO.class);

                Article article = new Article();

                article.setLanguage(articleFromJson.getLanguage());
                article.setTimestamp(articleFromJson.getTimestamp());
                article.setTitle(articleFromJson.getTitle());
                article.setWiki(articleFromJson.getWiki());
                article.setCreateTimestamp(articleFromJson.getCreateTimestamp());

                articleRepository.save(article);
                List<AuxiliaryText> auxiliaryTextList = new ArrayList<>();
                if(articleFromJson.getAuxiliaryText() == null) {
                    article.setAuxiliaryText(null);
                } else {
                    for (String str : articleFromJson.getAuxiliaryText()) {
                        AuxiliaryText auxiliaryText = new AuxiliaryText();
                        auxiliaryText.setAuxiliaryText(str);
                        auxiliaryText.setArticle(article);
                        auxiliaryTextRepository.save(auxiliaryText);
                        auxiliaryTextList.add(auxiliaryText);
                    }
                    article.setAuxiliaryText(auxiliaryTextList);
                }

                List<Category> categoryList = new ArrayList<>();
                if(articleFromJson.getCategory() == null) {
                    article.setCategory(null);
                } else {
                    for (String str : articleFromJson.getCategory()) {
                        Category category = new Category();
                        category.setCategory(str);
                        category.setArticle(article);
                        categoryRepository.save(category);
                        categoryList.add(category);
                    }
                    article.setCategory(categoryList);
                }
                articleRepository.save(article);
            }
        }
    }
}
