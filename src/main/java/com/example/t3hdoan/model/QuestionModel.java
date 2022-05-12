package com.example.t3hdoan.model;

import com.example.t3hdoan.model.entity.ExamEntity;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

public class QuestionModel {

    private int id;

    private Timestamp createDate;

    private Timestamp updateDate;

    private Timestamp deleteDate;

    private boolean deleted;

    private String name;

    private int categoryId;

    private boolean multiple;

    private double score;

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public boolean isMultiple() {
        return multiple;
    }

    public void setMultiple(boolean multiple) {
        this.multiple = multiple;
    }

    private Set<ExamEntity> examEntitySet = new HashSet<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Timestamp getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Timestamp createDate) {
        this.createDate = createDate;
    }

    public Timestamp getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Timestamp updateDate) {
        this.updateDate = updateDate;
    }

    public Timestamp getDeleteDate() {
        return deleteDate;
    }

    public void setDeleteDate(Timestamp deleteDate) {
        this.deleteDate = deleteDate;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public Set<ExamEntity> getExamEntitySet() {
        return examEntitySet;
    }

    public void setExamEntitySet(Set<ExamEntity> examEntitySet) {
        this.examEntitySet = examEntitySet;
    }
}
