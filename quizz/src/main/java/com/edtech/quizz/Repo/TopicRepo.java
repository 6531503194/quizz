package com.edtech.quizz.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.edtech.quizz.Model.Topic;

@Repository
public interface TopicRepo extends JpaRepository<Topic,Integer>{

    List<Topic> findTopicByPhasePhaseId(int phaseId);

    List<Topic> findAllByPhasePhaseId(int phaseId);
    
}
