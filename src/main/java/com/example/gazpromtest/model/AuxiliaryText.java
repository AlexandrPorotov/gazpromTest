package com.example.gazpromtest.model;

import lombok.Data;

import javax.persistence.*;

/**@author Alexandr Porotov
 * <p>Сущность базы данных, поле объекта статьи</p>
 * @see Article*/
@Data
@Entity
@Table(name = "auxiliary_text")
public class AuxiliaryText {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "auxiliary_text_id")
    private long auxiliaryTextId;

    @Column(name = "auxiliary_text", length = 2000)
    private String auxiliaryText;

    @ManyToOne
    @JoinColumn(name = "article_id")
    private Article article;
}
