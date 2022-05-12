package com.example.t3hdoan.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "exam_question")
public class ExamQuestionEntity extends BaseEntity{

    @Column(name = "exam_id")
    private int exam;

    @Column(name = "question_id")
    private int question;

    public int getExam() {
        return exam;
    }

    public void setExam(int exam) {
        this.exam = exam;
    }

    public int getQuestion() {
        return question;
    }

    public void setQuestion(int question) {
        this.question = question;
    }
}
