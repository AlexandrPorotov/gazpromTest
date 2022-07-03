package com.example.gazpromtest.model;

import lombok.Data;

@Data
public class CountForCategory {

    private String category;

    private long total;

    public CountForCategory(String category, long total) {
        this.category = category;
        this.total = total;
    }
}
