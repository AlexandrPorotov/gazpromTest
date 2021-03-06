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

/**
 * @author Alexandr Porotov
 * <p>Сервис реализующий иморт данных из JSON файла в базу данных</p>
 * <p>Для запуска необходимо отправить post запрос на эндпойнт /api/admin/import</p>
 * @see com.example.gazpromtest.controller.ImportController
 * */
@Service
@AllArgsConstructor
public class ImportService {

    private final ArticleRepository articleRepository;
    private final AuxiliaryTextRepository auxiliaryTextRepository;
    private final CategoryRepository categoryRepository;

    // Путь к JSON файлу, в данном примере располагается в пакете resources\static . Имя файла - input.json
    private static final String PATH = System.getProperty("user.dir")+ "\\src\\main\\resources\\static\\input.json";

    public void saveDataFromJson() throws IOException {
        List<String> gson = Files.readAllLines(Paths.get(PATH));

        Gson g = new GsonBuilder()
                .setDateFormat("\"yyyy-MM-dd'T'HH:mm:ss'Z'\"")
                .create();

        for(String s : gson) {
            if(!s.contains("{\"index\":{\"_type\":")) {

                ArticleDTO articleFromJson = g.fromJson(s, ArticleDTO.class);

                Article article = new Article();

                List<AuxiliaryText> auxiliaryTextList = new ArrayList<>();
                if(articleFromJson.getAuxiliaryText() != null) {
                    for (String str : articleFromJson.getAuxiliaryText()) {
                        AuxiliaryText auxiliaryText = new AuxiliaryText();
                        auxiliaryText.setAuxiliaryText(str);
                        auxiliaryText.setArticle(article);
                        auxiliaryTextList.add(auxiliaryText);
                    }
                }

                List<Category> categoryList = new ArrayList<>();
                if(articleFromJson.getCategory() != null) {
                    for (String str : articleFromJson.getCategory()) {
                        Category category = new Category();
                        category.setCategory(str);
                        category.setArticle(article);
                        categoryList.add(category);
                    }
                }

                article.setCategory(categoryList);
                article.setAuxiliaryText(auxiliaryTextList);

                article.setLanguage(articleFromJson.getLanguage());
                article.setTimestamp(articleFromJson.getTimestamp());
                article.setTitle(articleFromJson.getTitle());
                article.setWiki(articleFromJson.getWiki());
                article.setCreateTimestamp(articleFromJson.getCreateTimestamp());

                articleRepository.save(article);
                auxiliaryTextRepository.saveAll(auxiliaryTextList);
                categoryRepository.saveAll(categoryList);

            }
        }
    }
}
