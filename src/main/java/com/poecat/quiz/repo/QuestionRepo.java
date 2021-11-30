package com.poecat.quiz.repo;

import com.poecat.quiz.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionRepo extends JpaRepository <Question, Integer> {

}
