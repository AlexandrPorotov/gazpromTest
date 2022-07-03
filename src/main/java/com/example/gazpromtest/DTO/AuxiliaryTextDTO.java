package com.example.gazpromtest.DTO;

import com.example.gazpromtest.model.Article;
import lombok.Data;

/**@author Alexandr Porotov
 * <p>Класс для парсинга поля AuxiliaryText из JSON файла</p>
 * @see com.example.gazpromtest.service.ImportService
 * @see com.example.gazpromtest.model.AuxiliaryText*/
@Data
public class AuxiliaryTextDTO {

    private String auxiliaryText;

    private Article article;
}
