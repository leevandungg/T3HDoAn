package com.example.t3hdoan.service;

import com.example.t3hdoan.model.LevelModel;

import java.util.List;

public interface ILevelService {

    LevelModel save(LevelModel levelModel);

    List<LevelModel> getAll();

    LevelModel findById(int id);
}
