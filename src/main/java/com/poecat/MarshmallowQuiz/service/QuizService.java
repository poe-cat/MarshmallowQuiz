package com.poecat.MarshmallowQuiz.service;

import com.poecat.MarshmallowQuiz.model.Question;
import com.poecat.MarshmallowQuiz.model.QuestionForm;
import com.poecat.MarshmallowQuiz.model.Result;
import com.poecat.MarshmallowQuiz.repo.QuestionRepo;
import com.poecat.MarshmallowQuiz.repo.ResultRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class QuizService {

    @Autowired
    Question question;
    @Autowired
    QuestionForm qForm;
    @Autowired
    QuestionRepo qRepo;

    @Autowired
    Result result;
    @Autowired
    ResultRepo rRepo;

    public QuestionForm getQuestions() {
        List<Question> allQues = qRepo.findAll();
        List<Question> qList = new ArrayList<Question>();

        Random random = new Random();

        for(int i=0; i<5; i++) {
            int rand = random.nextInt(allQues.size());
            qList.add(allQues.get(rand));
            allQues.remove(rand);
        }
        qForm.setQuestions(qList);

        return qForm;
    }

    public int getResult(QuestionForm qForm) {
        int correct = 0;

        for(Question q: qForm.getQuestions())
            if(q.getAnswer() == q.getChoice())
                correct++;

        return correct;
    }

}
