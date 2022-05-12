package com.example.t3hdoan.dao;

import com.example.t3hdoan.model.entity.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ICategoryReposity extends JpaRepository<CategoryEntity, Integer> {

    @Query(value = "SELECT * FROM category", nativeQuery = true)
    List<CategoryEntity> getAll();

    CategoryEntity findById(int id);
}
