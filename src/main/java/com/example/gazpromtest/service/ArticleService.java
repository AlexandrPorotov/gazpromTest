package com.example.gazpromtest.service;

import com.example.gazpromtest.repository.ArticleRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
@AllArgsConstructor
public class ArticleService {

    private final ArticleRepository articleRepository;
    private final ImportService importService;

    public void importData() throws IOException {
        importService.saveDataFromJson();
    }
}
