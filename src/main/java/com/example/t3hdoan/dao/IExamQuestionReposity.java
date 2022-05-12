package com.example.t3hdoan.dao;
import com.example.t3hdoan.model.entity.ExamQuestionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IExamQuestionReposity extends JpaRepository<ExamQuestionEntity,Integer> {

    @Query(value = "SELECT * FROM exam_question",nativeQuery = true)
    List<ExamQuestionEntity> getAll();

    ExamQuestionEntity getById(int id);
}
