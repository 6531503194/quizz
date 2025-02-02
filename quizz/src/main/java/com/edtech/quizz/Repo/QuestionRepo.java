package com.edtech.quizz.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.edtech.quizz.Model.Question;

@Repository
public interface QuestionRepo extends JpaRepository<Question,Integer>{
    List<Question> findByQuizQuizId(int quizId);
}
