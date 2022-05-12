package com.example.t3hdoan.service;

import com.example.t3hdoan.model.CategoryModel;

import java.util.List;

public interface ICategoryService {

    List<CategoryModel> getAll();

    CategoryModel save(CategoryModel categoryModel);

    CategoryModel findById(int id);
}
