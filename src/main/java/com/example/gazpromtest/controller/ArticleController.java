package com.example.gazpromtest.controller;

import com.example.gazpromtest.service.ArticleService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
@AllArgsConstructor
public class ArticleController {

    private final ArticleService articleService;

    @GetMapping(value = "wiki/{title}",params = {"pretty"})
    public String getArticle(@RequestParam(value = "pretty") String isPretty, @PathVariable String title){
        String response = "";
        if(isPretty.equals("true")){
            response = articleService.getArticleByTitlePretty(title);
        } else if (isPretty.equals("false")) {
            response = articleService.getArticleByTitle(title);
        }
        return response;
    }

}
