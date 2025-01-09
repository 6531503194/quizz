package com.edtech.quizz.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edtech.quizz.Model.Question;
import com.edtech.quizz.Repo.QuestionRepo;

@Service
public class QuestionService {
    
    @Autowired
    private QuestionRepo QRepo;

    public List<Question> getQuestionsByQuizId(int quizId) {
        return QRepo.findByQuizQuizId(quizId);
    }
    
}
