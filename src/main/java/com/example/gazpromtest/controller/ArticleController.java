package com.example.gazpromtest.controller;

import com.example.gazpromtest.service.ArticleService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

/**@author Alexandr Porotov
 * <p>Контроллер реализущий выдачу статьи в JSON формате</p>
 * <p>Один эндпойнт для получения ответа в редактированном виде и в виде строки</p>
 * <p>Для того что бы получить форматированный ответ - необходимо отправить get запрос по эндпойнту - <br>/wiki/<название статьи>/?pretty=true</p>
 * <p>Для того что бы получить ответ в виде строки, флаг pretty должен быть равен false - <br>/wiki/<название статьи>/?pretty=false</p>
 * <p>Для получения статистики - кол-во статей по категориям - необходимо отправить get запрос на эндпойнт /statistic</p>
 * @see com.example.gazpromtest.model.Article
 * @see ArticleService*/
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

    @GetMapping(value = "statistic")
    public String getStatistic(){
        return  articleService.getStatisticByCategory();
    }

}
