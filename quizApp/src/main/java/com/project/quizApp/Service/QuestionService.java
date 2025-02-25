package com.project.quizApp.Service;

import com.project.quizApp.Model.Questions;
import com.project.quizApp.Repository.QuestionRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {
        private final QuestionRepo repo;

    public QuestionService(QuestionRepo repo) {
        this.repo = repo;
    }

    public List<Questions> getAllQuestions() {
        return repo.findAll();
    }

    public List<Questions> getQuestionByCategory(String category) {
        return repo.findQuestionByCategory(category);
    }
}
