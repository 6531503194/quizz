package com.edtech.quizz.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edtech.quizz.Model.Topic;
import com.edtech.quizz.Repo.TopicRepo;

@Service
public class TopicService {
    
    @Autowired
    private TopicRepo TopicRepo;

    public List<Topic> getTopicByPhaseId(int phaseId){
        return TopicRepo.findTopicByPhasePhaseId(phaseId);
    }
}
