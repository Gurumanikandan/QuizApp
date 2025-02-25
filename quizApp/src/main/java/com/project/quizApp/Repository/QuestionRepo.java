package com.project.quizApp.Repository;

import com.project.quizApp.Model.Questions;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuestionRepo extends JpaRepository<Questions,Integer> {

    List<Questions> findQuestionByCategory(String category);
}
