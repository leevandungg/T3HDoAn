package com.example.t3hdoan.service;
import com.example.t3hdoan.model.ExamQuestionModel;

import java.util.List;

public interface IExamQuestionService {

    List<ExamQuestionModel> getAll();

    ExamQuestionModel save(ExamQuestionModel ExamQuestionModel);

    ExamQuestionModel findById(int id);
}
