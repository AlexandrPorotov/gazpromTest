package com.example.gazpromtest.model;

import lombok.Data;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

/**@author Alexandr Porotov
 * <p>Сущность базы данных - статья</p>*/
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


    public long getCreateTimestampByUnixTime(){
        return this.createTimestamp.getTime();
    }

    public long getTimestampByUnixTime(){
        return this.timestamp.getTime();
    }
}
