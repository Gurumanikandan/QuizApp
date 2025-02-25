package com.project.quizApp.Service;

import com.project.quizApp.Model.Questions;
import com.project.quizApp.Repository.AddQuestionRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AddQuestionService {
    private final AddQuestionRepo repo;

    public AddQuestionService(AddQuestionRepo repo) {
        this.repo = repo;
    }

    public Questions addQuestions(Questions question) {
        return repo.save(question);
    }

    public Questions updateQuestions(Questions question) {
        return repo.save(question);
    }

    public List<Questions> getQuestions() {
        return repo.findAll();
    }

    public Optional<Questions> getQuestionById(int id) {
        return repo.findById(id);
    }
}
