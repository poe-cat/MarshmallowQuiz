package com.poecat.MarshmallowQuiz.repo;

import com.poecat.MarshmallowQuiz.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionRepo extends JpaRepository <Question, Integer> {

}
