package com.example.t3hdoan.service;

import com.example.t3hdoan.model.ExamModel;
import com.example.t3hdoan.model.request.ExamRequest;

import java.util.List;

public interface IExamService {

    List<ExamModel> getAll();

    ExamModel save(ExamRequest examRequest);

    ExamModel get(int id);
}
