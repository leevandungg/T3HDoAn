package com.example.t3hdoan.service.impl;

import com.example.t3hdoan.dao.ILevelReposity;
import com.example.t3hdoan.model.LevelModel;
import com.example.t3hdoan.model.entity.LevelEntity;
import com.example.t3hdoan.service.ILevelService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.sql.Timestamp;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class LevelServiceImpl implements ILevelService {

    private final ModelMapper modelMapper;
    private final ILevelReposity iLevelReposity;

    public LevelServiceImpl(ModelMapper modelMapper, ILevelReposity iLevelReposity) {
        this.modelMapper = modelMapper;
        this.iLevelReposity = iLevelReposity;
    }

    @Override
    public LevelModel save(LevelModel levelModel) {

        if(levelModel.getId() == 0){
            levelModel.setCreateDate(new Timestamp(new Date().getTime()));
        }

        levelModel.setUpdateDate(new Timestamp(new Date().getTime()));
        levelModel.setDeleted(false);

        LevelEntity levelEntity = modelMapper.map(levelModel,LevelEntity.class);

        levelEntity = iLevelReposity.save(levelEntity);

        return levelModel;
    }

    @Override
    public List<LevelModel> getAll() {
        List<LevelModel> list = iLevelReposity.getAll().stream().map(entity -> modelMapper.map(entity, LevelModel.class))
                .collect(Collectors.toList());
        return list;
    }

    @Override
    public LevelModel findById(int id) {
        LevelEntity levelEntity = iLevelReposity.findById(id);

        LevelModel levelModel = modelMapper.map(levelEntity,LevelModel.class);

        return levelModel;
    }
}
