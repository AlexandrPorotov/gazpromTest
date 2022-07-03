package com.example.gazpromtest.DTO;

import com.example.gazpromtest.model.Article;
import lombok.Data;

/**@author Alexandr Porotov
 * <p>Класс для парсинга поля Category из JSON файла</p>
 * @see com.example.gazpromtest.service.ImportService
 * @see com.example.gazpromtest.model.Category*/
@Data
public class CategoryDTO {

    private String category;

    private Article article;
}
