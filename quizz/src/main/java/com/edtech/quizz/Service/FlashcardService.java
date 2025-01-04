package com.edtech.quizz.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.edtech.quizz.Model.Flashcard;
import com.edtech.quizz.Repo.FlashcardRepo;

@Service
public class FlashcardService {
    
    @Autowired
    private FlashcardRepo Frepo;

    public List<Flashcard> allcards(){
        return Frepo.findAll();
    }

    // public List<Flashcard> getFlashcardByTopicId(int topicId){
    //     List<Flashcard> cardsBytopic = Frepo.findAllByTopicId(topicId);
    //     return cardsBytopic;
    // }

    // public List<Flashcard> getFlashcardByPhaseId(int phaseId) {
    //     List<Flashcard> cardsBytopic = Frepo.findAllByPhaseId();
    //     return cardsBytopic;
    // }
}
