package com.example.t3hdoan.service.impl;

import com.example.t3hdoan.dao.IExamReposity;
import com.example.t3hdoan.model.ExamModel;
import com.example.t3hdoan.model.entity.ExamEntity;
import com.example.t3hdoan.model.request.ExamRequest;
import com.example.t3hdoan.service.IExamService;
import com.example.t3hdoan.service.IFileService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.io.File;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@Service
public class ExamServiceImpl implements IExamService {

    private final IExamReposity iExamReposity;
    private final ModelMapper modelMapper;

    private final IFileService iFileService;

    public ExamServiceImpl(IExamReposity iExamReposity, ModelMapper modelMapper, IFileService iFileService) {
        this.iExamReposity = iExamReposity;
        this.modelMapper = modelMapper;
        this.iFileService = iFileService;
    }

    @Override
    public List<ExamModel> getAll() {

        List<ExamModel> examModels = iExamReposity.getAll().stream().map(examEntity ->
                modelMapper.map(examEntity,ExamModel.class)).collect(Collectors.toList());
        return examModels;
    }

    @Override
    public ExamModel save(ExamRequest examRequest) {
        if(examRequest.getId() == 0){
            examRequest.setCreateDate(new Timestamp(new Date().getTime()));
            examRequest.setDeleted(false);
        }
        examRequest.setUpdateDate(new Timestamp(new Date().getTime()));

        Optional<ExamEntity> examFindById = iExamReposity.findById(examRequest.getId());

        ExamEntity examEntity = modelMapper.map(examRequest,ExamEntity.class);

        String avatarPath;

        // Xóa file cũ
        String oldUrl;

        if (examRequest.getId() == 0) {
            oldUrl = "";
        } else {
            oldUrl = examFindById.get().getAvatar();
        }

        String realUrl = new File(".").getAbsolutePath();

        if (examRequest.getAvatar() != null) {
//            // Xóa file cũ
//            File file = new File(realUrl+"\\src\\main\\resources\\static\\admin\\img\\exam\\"
//                    + oldUrl.substring(oldUrl.lastIndexOf("/") + 1));
//
//            File target = new File(realUrl+"\\target\\classes\\static\\admin\\img\\exam\\" +
//                    oldUrl.substring(oldUrl.lastIndexOf("/") + 1));
//
//            file.delete();
//            target.delete();

            // Thêm file mới được chọn
            String pathFile = realUrl+"\\src\\main\\resources\\static\\admin\\img\\exam";
            File fileSaved = iFileService.uploadFile(examRequest.getAvatar(), pathFile);
            avatarPath = "/admin/dist/img/avatar/" + fileSaved.getName();
            File targetAvatar = new File(realUrl+"\\target\\classes\\static\\admin\\img\\exam\\" + fileSaved.getName());
            iFileService.copyFile(fileSaved, targetAvatar);
        } else {
            avatarPath = oldUrl;
        }

        examEntity.setAvatar(avatarPath);

        examEntity = iExamReposity.save(examEntity);

        ExamModel examModel = modelMapper.map(examEntity,ExamModel.class);

        return examModel;
    }

    @Override
    public ExamModel get(int id) {

        ExamEntity examEntity = iExamReposity.getById(id);

        ExamModel examModel = modelMapper.map(examEntity,ExamModel.class);

        return examModel;
    }
}
