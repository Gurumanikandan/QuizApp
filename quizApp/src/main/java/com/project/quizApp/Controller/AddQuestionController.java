package com.project.quizApp.Controller;

import com.project.quizApp.Model.Questions;
import com.project.quizApp.Service.AddQuestionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class AddQuestionController {
    private final AddQuestionService service;

    public AddQuestionController(AddQuestionService service) {
        this.service = service;
    }

    @PostMapping("/Questions")
    public ResponseEntity<?> addQuestions(@RequestBody Questions question){
        Questions question1=service.addQuestions(question);
        return question1!=null
                ? new ResponseEntity<>("success", HttpStatus.OK)
                : new ResponseEntity<>("Not success",HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @GetMapping("/Questions")
    public List<Questions> getQuestions(){
        return service.getQuestions();
    }
    @GetMapping("/Questions/{id}")
    public Questions getQuestionById(@PathVariable int id) throws Exception {
        Optional<Questions> question= service.getQuestionById(id);
        if(question.isPresent())
            return question.orElse(null);
        else
            throw  new Exception("not found");
    }

    @PutMapping("/Questions")
    public ResponseEntity<?> updateQuestions(@RequestBody Questions question){
        Questions questions1=service.updateQuestions(question);
        return questions1!=null
                ? new ResponseEntity<>("success",HttpStatus.OK)
                : new ResponseEntity<>("Not success",HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
