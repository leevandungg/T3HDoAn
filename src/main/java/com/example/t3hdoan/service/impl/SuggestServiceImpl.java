package com.example.t3hdoan.service.impl;

import com.example.t3hdoan.dao.ISuggestReposity;
import com.example.t3hdoan.model.SuggestModel;
import com.example.t3hdoan.model.entity.LevelEntity;
import com.example.t3hdoan.model.entity.SuggestEntity;
import com.example.t3hdoan.service.ISuggestService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SuggestServiceImpl implements ISuggestService {

    private final ISuggestReposity iSuggestReposity;
    private final ModelMapper modelMapper;

    public SuggestServiceImpl(ISuggestReposity iSuggestReposity, ModelMapper modelMapper) {
        this.iSuggestReposity = iSuggestReposity;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<SuggestModel> getAll() {
        List<SuggestModel> list = iSuggestReposity.getAll().stream().map(suggestEntity ->
                modelMapper.map(suggestEntity,SuggestModel.class)).collect(Collectors.toList());
        return list;
    }

    @Override
    public SuggestModel save(SuggestModel suggestModel) {
        if(suggestModel.getId() == 0){
            suggestModel.setCreateDate(new Timestamp(new Date().getTime()));
        }

        suggestModel.setUpdateDate(new Timestamp(new Date().getTime()));
        suggestModel.setDeleted(false);

        SuggestEntity suggestEntity = modelMapper.map(suggestModel,SuggestEntity.class);

        suggestEntity = iSuggestReposity.save(suggestEntity);

        suggestModel.setId(suggestEntity.getId());

        return suggestModel;
    }

    @Override
    public SuggestModel findById(int id) {
        return null;
    }

    @Override
    public List<SuggestModel> findByQuestionId(int id) {
        List<SuggestModel> suggestModels = iSuggestReposity.findByQuestionId(id).stream().map(suggestEntity ->
        {
            SuggestModel suggestModel = modelMapper.map(suggestEntity,SuggestModel.class);
            return suggestModel;
        }).collect(Collectors.toList());
        return suggestModels;
    }

    @Override
    public SuggestModel removeById(int id) {

        SuggestEntity suggestEntity = iSuggestReposity.findById(id);

        SuggestModel suggestModel = modelMapper.map(suggestEntity,SuggestModel.class);

        suggestEntity = iSuggestReposity.deleteById(id);

        return suggestModel;
    }
}
