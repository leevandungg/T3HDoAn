package com.example.t3hdoan.controller;

import com.example.t3hdoan.model.*;
import com.example.t3hdoan.service.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequestMapping("/admin")
public class AdminController {

    private final ILevelService iLevelService;
    private final ICategoryService iCategoryService;
    private final IQuestionService iQuestionService;
    private final ISuggestService iSuggestService;
    private final IExamService iExamService;

    public AdminController(ILevelService iLevelService, ICategoryService iCategoryService, IQuestionService iQuestionService, ISuggestService iSuggestService, IExamService iExamService) {
        this.iLevelService = iLevelService;
        this.iCategoryService = iCategoryService;
        this.iQuestionService = iQuestionService;
        this.iSuggestService = iSuggestService;
        this.iExamService = iExamService;
    }

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index() {
        return "/admin/index";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
        return "/admin/login";
    }

    @RequestMapping(value = "/level", method = RequestMethod.GET)
    public String level(Model model) {
        List<LevelModel> levelModelList = iLevelService.getAll();
        model.addAttribute("levels", levelModelList);
        return "/admin/level";
    }

    @GetMapping("/level/add")
    public String addLevel(Model model) {
        LevelModel levelModel = new LevelModel();
        model.addAttribute("level", levelModel);
        return "/admin/addLevel";
    }

    @PostMapping("/level/save")
    public String save(@ModelAttribute LevelModel levelModel) {
        iLevelService.save(levelModel);
        return "redirect:/admin/level";
    }

    @GetMapping("/category")
    public String category(Model model) {
        List<CategoryModel> list = iCategoryService.getAll();
        model.addAttribute("categorys", list);
        return "/admin/category";
    }

    @GetMapping("/category/add")
    public String addCategory(Model model) {
        CategoryModel categoryModel = new CategoryModel();
        model.addAttribute("category", categoryModel);
        return "/admin/addCategory";
    }

    @PostMapping("/category/save")
    public String save(@ModelAttribute CategoryModel categoryModel) {
        iCategoryService.save(categoryModel);
        return "redirect:/admin/category";
    }

    @GetMapping("/category/update")
    public String updateCategory(@RequestParam("id") String id, Model model) {
        CategoryModel categoryModel = iCategoryService.findById(Integer.parseInt(id));
        model.addAttribute("category", categoryModel);
        return "/admin/updateCategory";
    }

    @GetMapping("/level/update")
    public String updateLevel(@RequestParam("id") String id, Model model) {
        LevelModel levelModel = iLevelService.findById(Integer.parseInt(id));
        model.addAttribute("level", levelModel);
        return "/admin/updateLevel";
    }

    @GetMapping("/question")
    public String question(Model model) {
        List<CategoryModel> categoryModels = iCategoryService.getAll();
        List<QuestionModel> list = iQuestionService.getAll();
        model.addAttribute("questions", list);
        model.addAttribute("categorys",categoryModels);
        return "/admin/question";
    }

    @GetMapping("/question/add")
    public String addQuestion(Model model){
        List<CategoryModel> categoryModels = iCategoryService.getAll();
        model.addAttribute("categorys",categoryModels);
        return "/admin/addQuestion";
    }

    @GetMapping("/question/update")
    public String updateQuestion(@RequestParam("id") String id, Model model){
        QuestionModel questionModel = iQuestionService.findById(Integer.parseInt(id));
        List<SuggestModel> suggestModel = iSuggestService.findByQuestionId(Integer.parseInt(id));
        List<CategoryModel> categoryModels = iCategoryService.getAll();
        model.addAttribute("categorys",categoryModels);
        model.addAttribute("question",questionModel);
        model.addAttribute("suggests",suggestModel);
        return "/admin/updateQuestion";
    }

    @GetMapping("/exam")
    public String exam(Model model){
        List<ExamModel> examModels = iExamService.getAll();
        model.addAttribute("exams",examModels);
        return "/admin/exam";
    }

    @GetMapping("/exam/add")
    public String addExam(Model model){
        List<LevelModel> levelModels = iLevelService.getAll();
        List<CategoryModel> categoryModels = iCategoryService.getAll();
        model.addAttribute("levels",levelModels);
        model.addAttribute("categorys",categoryModels);
        return "/admin/addExam";
    }
}
