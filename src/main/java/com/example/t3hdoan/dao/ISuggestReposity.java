package com.example.t3hdoan.dao;

import com.example.t3hdoan.model.entity.SuggestEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface ISuggestReposity extends JpaRepository<SuggestEntity, Integer> {

    @Query(value = "SELECT * FROM suggest",nativeQuery = true)
    List<SuggestEntity> getAll();

    SuggestEntity findById(int id);

    List<SuggestEntity> findByQuestionId(int id);

    SuggestEntity deleteById(int id);
}
