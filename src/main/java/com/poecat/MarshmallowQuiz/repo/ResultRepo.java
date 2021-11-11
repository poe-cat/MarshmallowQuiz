package com.poecat.MarshmallowQuiz.repo;

import com.poecat.MarshmallowQuiz.model.Result;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResultRepo extends JpaRepository <Result, Integer> {

}
