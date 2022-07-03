package com.example.gazpromtest.model;

import lombok.Data;

import javax.persistence.*;

/**@author Alexandr Porotov
 * <p>Сущность базы данных, поле объекта статья</p>
 * @see Article*/
@Data
@Entity
@Table(name = "categories")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id")
    private long categoryId;

    @Column(name = "category")
    private String category;

    @ManyToOne
    @JoinColumn(name = "article_id")
    private Article article;
}
