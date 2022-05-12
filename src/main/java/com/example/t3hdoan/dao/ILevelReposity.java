package com.example.t3hdoan.dao;

import com.example.t3hdoan.model.entity.LevelEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ILevelReposity extends JpaRepository<LevelEntity, Integer>{

    @Query(value = "SELECT * FROM level ", nativeQuery = true)
    List<LevelEntity> getAll();

    LevelEntity findById(int id);
}
