package com.project.quizApp.Repository;

import com.project.quizApp.Model.Questions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddQuestionRepo extends JpaRepository<Questions,Integer> {

}
