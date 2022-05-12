package com.example.t3hdoan.dao;

import com.example.t3hdoan.model.entity.QuestionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IQuestionReposity extends JpaRepository<QuestionEntity, Integer> {

    @Query(value = "SELECT * FROM question", nativeQuery = true)
    List<QuestionEntity> getAll();

    QuestionEntity findById(int id);
}
