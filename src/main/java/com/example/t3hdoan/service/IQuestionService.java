package com.example.t3hdoan.service;

import com.example.t3hdoan.model.QuestionModel;

import java.util.List;

public interface IQuestionService {

    List<QuestionModel> getAll();

    QuestionModel save(QuestionModel questionModel);

    QuestionModel findById(int id);
}
