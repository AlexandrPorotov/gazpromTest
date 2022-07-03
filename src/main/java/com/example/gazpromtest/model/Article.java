package com.example.gazpromtest.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Data
@Entity
@Table(name = "articles")
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "article_id")
    private long articleId;

    @Column(name = "create_timestamp")
    private Date createTimestamp;

    @Column(name = "timestamp")
    private Date timestamp;

    @Column(name = "language")
    private String language;

    @Column(name = "wiki")
    private String wiki;

    @OneToMany(mappedBy = "article")
    private List<Category> category;

    @Column(name = "title")
    private String title;

    @OneToMany(mappedBy = "article")
    private List<AuxiliaryText> auxiliaryText;
}