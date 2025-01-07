package com.edtech.quizz.Service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edtech.quizz.Model.Quiz;
import com.edtech.quizz.Model.Topic;
import com.edtech.quizz.Repo.QuizRepo;

@Service
public class QuizService {

    @Autowired
    private QuizRepo quizRepo;

    @Autowired
    private TopicService Tservice;

public List<Quiz> getQuizByTopicList(List<Topic> topics) {

    List<Integer> topicIds = topics.stream()
                                       .map(Topic::getTopicId) 
                                       .collect(Collectors.toList());

        return quizRepo.findByTopicIdIn(topicIds);
    }
    
}
