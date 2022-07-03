package com.example.gazpromtest.DTO;

import com.example.gazpromtest.model.AuxiliaryText;
import com.example.gazpromtest.model.Category;
import com.google.gson.annotations.SerializedName;
import lombok.Data;
import java.sql.Date;
import java.util.List;

@Data
public class ArticleDTO {

    @SerializedName("create_timestamp")
    private Date createTimestamp;

    @SerializedName("timestamp")
    private Date timestamp;

    @SerializedName("language")
    private String language;

    @SerializedName("wiki")
    private String wiki;

    @SerializedName("category")
    private String[] category;

    @SerializedName("title")
    private String title;

    @SerializedName("auxiliary_text")
    private String[] auxiliaryText;
}
