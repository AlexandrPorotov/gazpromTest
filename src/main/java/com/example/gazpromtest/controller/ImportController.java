package com.example.gazpromtest.controller;

import com.example.gazpromtest.service.ImportService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

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
