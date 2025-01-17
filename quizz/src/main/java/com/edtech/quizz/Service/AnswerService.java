package com.edtech.quizz.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edtech.quizz.Model.Answer;
import com.edtech.quizz.Model.Question;
import com.edtech.quizz.Repo.AnswerRepo;


@Service
public class AnswerService {

    @Autowired
    private AnswerRepo AnswerRepo;

    public List<Answer> getAnswersByQuestion(List<Question> questions) {
        List<Answer> allAnswers = new ArrayList<>();
        
        for (Question question : questions) {
            List<Answer> answersForQuestion = AnswerRepo.findByQuestion(question);
            allAnswers.addAll(answersForQuestion);
        }
        
        return allAnswers;
    }

    public List<Answer> getAnswersByOneQuestion(Question q) {
        return AnswerRepo.findByQuestion(q);
    }
}