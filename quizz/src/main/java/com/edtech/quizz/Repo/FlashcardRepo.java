package com.edtech.quizz.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.edtech.quizz.Model.Flashcard;

@Repository
public interface FlashcardRepo extends JpaRepository<Flashcard,Integer>{

    // List<Flashcard> findAllByTopicId(int topicId);

    // List<Flashcard> findAllByPhaseId(int phaseId);
    
}
