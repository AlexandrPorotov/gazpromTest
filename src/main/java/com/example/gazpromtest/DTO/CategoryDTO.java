package com.example.gazpromtest.DTO;

import com.example.gazpromtest.model.Article;
import lombok.Data;

@Data
public class CategoryDTO {

    private String category;

    private Article article;
}
