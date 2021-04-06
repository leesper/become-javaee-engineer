package com.kkb.pojo;

import java.io.Serializable;
import java.util.List;

public class TQuestionForWx implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer id;
    private Integer type;
    private String title;
    private Integer grade;
    private String content;
    private String video;
    private String videoPoster;
    private String answerResult;
    private Integer answerTag;
    private boolean isAnswerRight;
    private Integer isFinished;
    private Integer isFavorite;
    private Integer memberId;
    private List<TTag> tags;
    private List<TQuestionItemForWx> selection;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }

    public String getVideoPoster() {
        return videoPoster;
    }

    public void setVideoPoster(String videoPoster) {
        this.videoPoster = videoPoster;
    }

    public String getAnswerResult() {
        return answerResult;
    }

    public void setAnswerResult(String answerResult) {
        this.answerResult = answerResult;
    }

    public Integer getAnswerTag() {
        return answerTag;
    }

    public void setAnswerTag(Integer answerTag) {
        this.answerTag = answerTag;
    }

    public boolean isAnswerRight() {
        return isAnswerRight;
    }

    public void setAnswerRight(boolean answerRight) {
        isAnswerRight = answerRight;
    }

    public Integer getIsFinished() {
        return isFinished;
    }

    public void setIsFinished(Integer isFinished) {
        this.isFinished = isFinished;
    }

    public Integer getIsFavorite() {
        return isFavorite;
    }

    public void setIsFavorite(Integer isFavorite) {
        this.isFavorite = isFavorite;
    }

    public Integer getMemberId() {
        return memberId;
    }

    public void setMemberId(Integer memberId) {
        this.memberId = memberId;
    }

    public List<TTag> getTags() {
        return tags;
    }

    public void setTags(List<TTag> tags) {
        this.tags = tags;
    }

    public List<TQuestionItemForWx> getSelection() {
        return selection;
    }

    public void setSelection(List<TQuestionItemForWx> selection) {
        this.selection = selection;
    }

    @Override
    public String toString() {
        return "TQuestionForWx{" +
                "id=" + id +
                ", type=" + type +
                ", title='" + title + '\'' +
                ", grade=" + grade +
                ", content='" + content + '\'' +
                ", video='" + video + '\'' +
                ", videoPoster='" + videoPoster + '\'' +
                ", answerResult='" + answerResult + '\'' +
                ", answerTag=" + answerTag +
                ", isAnswerRight=" + isAnswerRight +
                ", isFinished=" + isFinished +
                ", isFavorite=" + isFavorite +
                ", memberId=" + memberId +
                ", tags=" + tags +
                ", selection=" + selection +
                '}';
    }
}
