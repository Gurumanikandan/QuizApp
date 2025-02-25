package com.project.quizApp.Controller;

import com.project.quizApp.Model.Questions;
import com.project.quizApp.Service.QuestionService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class QuestionController {

    private final QuestionService service;
    public QuestionController(QuestionService service) {
        this.service = service;
    }

    @GetMapping("/Question")
    public List<Questions> getAllQuestions(){
        List<Questions> questions;
        return  questions= service.getAllQuestions();
    }

    @GetMapping("/category/{category}")
    public List<Questions> getQuestionByCategory(@PathVariable String category){
       return service.getQuestionByCategory(category);
    }
}
