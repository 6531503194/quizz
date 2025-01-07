package com.edtech.quizz.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.edtech.quizz.Model.Quiz;

@Repository
public interface QuizRepo extends JpaRepository<Quiz,Integer>{
    List<Quiz> findByTopicIdIn(List<Integer> topicIds);
}
