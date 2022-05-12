package com.example.t3hdoan.service;

import com.example.t3hdoan.model.SuggestModel;

import java.util.List;

public interface ISuggestService {

    List<SuggestModel> getAll();

    SuggestModel save(SuggestModel suggestModel);

    SuggestModel findById(int id);

    List<SuggestModel> findByQuestionId(int id);

    SuggestModel removeById(int id);
}
