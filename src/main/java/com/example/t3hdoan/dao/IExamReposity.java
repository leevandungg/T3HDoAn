package com.example.t3hdoan.dao;

import com.example.t3hdoan.model.entity.ExamEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IExamReposity extends JpaRepository<ExamEntity, Integer> {

    @Query(value = "SELECT * FROM exam",nativeQuery = true)
    List<ExamEntity> getAll();

    ExamEntity getById(int id);
}
