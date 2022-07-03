package com.example.gazpromtest.controller;

import com.example.gazpromtest.service.ImportService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

/**
 * @author Alexandr Porotov
 * <p>Контроллер для запуска импорта данных из файла в бд.
 * Для того что бы запустить процесс импорта, необходимо отправить post запрос на эндпойнит - <br>/api/admin/import</p>
 * @see ImportService*/
@RestController
@RequestMapping("api/admin")
@AllArgsConstructor
public class ImportController {

    private final ImportService importService;

    @PostMapping("/import")
    public void importData() throws IOException {
        importService.saveDataFromJson();
    }
}
