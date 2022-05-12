package com.example.t3hdoan.service.impl;

import com.example.t3hdoan.dao.IQuestionReposity;
import com.example.t3hdoan.model.QuestionModel;
import com.example.t3hdoan.model.entity.QuestionEntity;
import com.example.t3hdoan.model.entity.SuggestEntity;
import com.example.t3hdoan.service.IQuestionService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class QuestionServiceImpl implements IQuestionService {

    private final IQuestionReposity iQuestionReposity;
    private final ModelMapper modelMapper;

    public QuestionServiceImpl(IQuestionReposity iQuestionReposity, ModelMapper modelMapper) {
        this.iQuestionReposity = iQuestionReposity;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<QuestionModel> getAll() {
        List<QuestionModel> questionModels = iQuestionReposity.getAll().stream().map(questionEntity ->
                modelMapper.map(questionEntity,QuestionModel.class)).collect(Collectors.toList());
        return questionModels;
    }

    @Override
    public QuestionModel save(QuestionModel questionModel) {
        if(questionModel.getId() == 0){
            questionModel.setCreateDate(new Timestamp(new Date().getTime()));
        }

        questionModel.setUpdateDate(new Timestamp(new Date().getTime()));
        questionModel.setDeleted(false);

        QuestionEntity questionEntity = modelMapper.map(questionModel,QuestionEntity.class);

        questionEntity = iQuestionReposity.save(questionEntity);

        questionModel.setId(questionEntity.getId());

        return questionModel;
    }

    @Override
    public QuestionModel findById(int id) {

        QuestionEntity question = iQuestionReposity.findById(id);

        QuestionModel questionModel = modelMapper.map(question,QuestionModel.class);

        return questionModel;
    }
}
