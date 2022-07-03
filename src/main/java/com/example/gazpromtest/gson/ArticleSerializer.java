package com.example.gazpromtest.gson;

import com.example.gazpromtest.model.Article;
import com.example.gazpromtest.model.AuxiliaryText;
import com.example.gazpromtest.model.Category;
import com.example.gazpromtest.service.ArticleService;
import com.google.gson.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

import java.lang.reflect.Type;

public class ArticleSerializer implements JsonSerializer<Article> {

    @Override
    public JsonElement serialize(Article article, Type type, JsonSerializationContext jsonSerializationContext) {

        JsonObject response = new JsonObject();

        response.addProperty("create_timestamp", article.getCreateTimestampByUnixTime());
        response.addProperty("timestamp", article.getTimestampByUnixTime());
        response.addProperty("language", article.getLanguage());
        response.addProperty("wiki", article.getWiki());
        response.addProperty("title", article.getTitle());

        JsonArray categories = new JsonArray();
        response.add("category", categories);
        for (Category c : article.getCategory()) {
            categories.add(c.getCategory());
        }

        JsonArray auxiliaryTexts = new JsonArray();
        response.add("auxiliary_text",auxiliaryTexts);
        for(AuxiliaryText a : article.getAuxiliaryText()) {
            auxiliaryTexts.add(a.getAuxiliaryText());
        }

        return response;
    }
}
