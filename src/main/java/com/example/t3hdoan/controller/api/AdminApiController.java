package com.example.t3hdoan.controller.api;

import com.example.t3hdoan.model.*;
import com.example.t3hdoan.model.request.ExamRequest;
import com.example.t3hdoan.service.*;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin")
public class AdminApiController {

    private final IQuestionService iQuestionService;
    private final ISuggestService iSuggestService;
    private final ICategoryService iCategoryService;

    private final IExamService iExamService;

    private final IExamQuestionService iExamQuestionService;

    public AdminApiController(IQuestionService iQuestionService, ISuggestService iSuggestService, ISuggestService iSuggestService1, ICategoryService iCategoryService, IExamService iExamService, IExamQuestionService iExamQuestionService) {
        this.iQuestionService = iQuestionService;
        this.iSuggestService = iSuggestService1;
        this.iCategoryService = iCategoryService;
        this.iExamService = iExamService;
        this.iExamQuestionService = iExamQuestionService;
    }

    @GetMapping()
    public ResponseEntity<List<QuestionModel>> getAll(){
        return ResponseEntity.ok(iQuestionService.getAll());
    }

    @PostMapping("/question/add")
    public ResponseEntity<QuestionModel> add(@RequestBody QuestionModel questionModel){
        return ResponseEntity.ok(iQuestionService.save(questionModel));
    }

    @PostMapping("/suggest/add")
    public ResponseEntity<SuggestModel> add(@RequestBody SuggestModel suggestModel){
        return ResponseEntity.ok(iSuggestService.save(suggestModel));
    }

    @GetMapping("/suggest")
    public ResponseEntity<List<SuggestModel>> getByQuestion(@RequestParam("id") String id){
        return ResponseEntity.ok(iSuggestService.findByQuestionId(Integer.parseInt(id)));
    }

    @DeleteMapping("/suggest/delete")
    public ResponseEntity<SuggestModel> deleteSuggest(@RequestParam("id") String id){
        return ResponseEntity.ok(iSuggestService.removeById(Integer.parseInt(id)));
    }

    @GetMapping("/category")
    public ResponseEntity<List<CategoryModel>> getAllCatalog(){
        return ResponseEntity.ok(iCategoryService.getAll());
    }

    @PostMapping(value = "/exam",consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<ExamModel> add(ExamRequest examRequest){
        return ResponseEntity.ok(iExamService.save(examRequest));
    }
    @PostMapping("/exam/question")
    public ResponseEntity<ExamQuestionModel> add(@RequestBody ExamQuestionModel examQuestionModel){
        return ResponseEntity.ok(iExamQuestionService.save(examQuestionModel));
    }
}
