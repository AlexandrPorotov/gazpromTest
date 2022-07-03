package com.example.gazpromtest.DTO;

import com.example.gazpromtest.model.Article;
import lombok.Data;

@Data
public class AuxiliaryTextDTO {

    private String auxiliaryText;

    private Article article;
}
