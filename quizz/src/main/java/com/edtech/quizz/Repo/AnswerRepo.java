package com.edtech.quizz.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.edtech.quizz.Model.Answer;
import com.edtech.quizz.Model.Question;

@Repository
public interface AnswerRepo extends JpaRepository<Answer,Integer>{
    
    List<Answer> findByQuestion(Question question); 

}
