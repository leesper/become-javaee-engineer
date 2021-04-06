package com.kkb.pojo;

import java.io.Serializable;

public class TQuestionItemForWx implements Serializable {
    private Integer id;

    private Integer isRight;

    private String code;

    private String title;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public boolean getIsRight() {
        return isRight == 1;
    }

    public void setIsRight(Integer isRight) {
        this.isRight = isRight;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}