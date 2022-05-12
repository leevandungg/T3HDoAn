package com.example.t3hdoan.service.impl;

import com.example.t3hdoan.dao.IExamQuestionReposity;
import com.example.t3hdoan.model.ExamQuestionModel;
import com.example.t3hdoan.model.entity.ExamQuestionEntity;
import com.example.t3hdoan.service.IExamQuestionService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class IExamQuestionServiceImpl implements IExamQuestionService {

    private final IExamQuestionReposity iExamQuestionReposity;

    private final ModelMapper modelMapper;

    public IExamQuestionServiceImpl(IExamQuestionReposity iExamQuestionReposity, ModelMapper modelMapper) {
        this.iExamQuestionReposity = iExamQuestionReposity;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<ExamQuestionModel> getAll() {
        List<ExamQuestionModel> examQuestionModels = iExamQuestionReposity.getAll().stream().map(examQuestionEntity ->
                modelMapper.map(examQuestionEntity,ExamQuestionModel.class)).collect(Collectors.toList());
        return examQuestionModels;
    }

    @Override
    public ExamQuestionModel save(ExamQuestionModel examQuestionModel) {

        if(examQuestionModel.getId() == 0){
            examQuestionModel.setCreateDate(new Timestamp(new Date().getTime()));
        }

        examQuestionModel.setUpdateDate(new Timestamp(new Date().getTime()));
        examQuestionModel.setDeleted(false);

        System.out.println(examQuestionModel);

        ExamQuestionEntity examQuestionEntity = modelMapper.map(examQuestionModel,ExamQuestionEntity.class);

        examQuestionEntity = iExamQuestionReposity.save(examQuestionEntity);

        examQuestionModel.setId(examQuestionEntity.getId());

        return examQuestionModel;
    }

    @Override
    public ExamQuestionModel findById(int id) {
        return null;
    }
}
