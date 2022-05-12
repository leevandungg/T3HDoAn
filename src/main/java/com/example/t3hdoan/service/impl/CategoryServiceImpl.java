package com.example.t3hdoan.service.impl;

import com.example.t3hdoan.dao.ICategoryReposity;
import com.example.t3hdoan.model.CategoryModel;
import com.example.t3hdoan.model.entity.CategoryEntity;
import com.example.t3hdoan.service.ICategoryService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements ICategoryService {

    private final ICategoryReposity iCategoryReposity;
    private final ModelMapper modelMapper;

    public CategoryServiceImpl(ICategoryReposity iCategoryReposity, ModelMapper modelMapper) {
        this.iCategoryReposity = iCategoryReposity;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<CategoryModel> getAll() {
        List<CategoryModel> categoryModels = iCategoryReposity.getAll().stream()
                .map(entity -> modelMapper.map(entity, CategoryModel.class)).collect(Collectors.toList());
        return categoryModels;
    }

    @Override
    public CategoryModel save(CategoryModel categoryModel) {
        if(categoryModel.getId() == 0){
            categoryModel.setCreateDate(new Timestamp(new Date().getTime()));
        }
        categoryModel.setUpdateDate(new Timestamp(new Date().getTime()));
        categoryModel.setDeleted(false);

        CategoryEntity categoryEntity = modelMapper.map(categoryModel,CategoryEntity.class);

        categoryEntity = iCategoryReposity.save(categoryEntity);

        categoryModel.setId(categoryEntity.getId());

        return categoryModel;
    }

    @Override
    public CategoryModel findById(int id) {
        CategoryEntity categoryEntity = iCategoryReposity.findById(id);

        CategoryModel categoryModel = modelMapper.map(categoryEntity,CategoryModel.class);

        return categoryModel;
    }
}
