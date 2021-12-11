package com.poecat.quiz.repo;

import com.poecat.quiz.model.QuizChoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuizRepo extends JpaRepository<QuizChoice, Integer> {

}
