package com.edtech.quizz.Controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.edtech.quizz.Model.Flashcard;
import com.edtech.quizz.Model.Topic;
import com.edtech.quizz.Repo.FlashcardRepo;
import com.edtech.quizz.Repo.TopicRepo;
import com.edtech.quizz.Service.FlashcardService;
import com.edtech.quizz.Service.PhaseService;
import com.edtech.quizz.Service.TopicService;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class LearningZoneController {
    
    @Autowired
    private FlashcardService Fservice;

    @Autowired
    private TopicService Tservice;
    
    @Autowired
    private PhaseService Pservice;

    @Autowired
    private TopicRepo topicRepo;

    @Autowired
    private FlashcardRepo flashcardRepo;

    @GetMapping("/learning")
    public String getLearningPhases(Model model){

        model.addAttribute( "phases" , Pservice.getAllPhase());

        return "Learningtest";
    }

    @GetMapping("/learning_zone")
    public String LearningZone(Model model){

        model.addAttribute( "phases" , Pservice.getAllPhase());

        return "learning_zone";
    }


    @GetMapping("/learning/{phaseId}")
    public String getcards(@PathVariable int phaseId, Model model) {

        System.out.println("======================");
        System.out.println(Tservice.getTopicByPhaseId(phaseId).size());
        System.out.println("======================");

        // Fetch topics for the phase
        List<Topic> topics = Tservice.getTopicByPhaseId(phaseId);
        model.addAttribute("topics", topics);

        if (!topics.isEmpty()) {
            // Fetch flashcards for the first topic in the list (or default logic)
            int firstTopicId = topics.get(0).getTopicId();
            System.out.println("======================");
            System.out.println(Fservice.getFlashcardByTopicId(firstTopicId).size());
            System.out.println("======================");
            model.addAttribute("cards", Fservice.getFlashcardByTopicId(firstTopicId));
        } else {
            // If no topics are available, send an empty list
            model.addAttribute("cards", new ArrayList<>());
        }

        return "card";
    }

    // @GetMapping("/learning/cards/{topicId}")
    // @ResponseBody
    // public Map<String, Object> getCardsByTopicId(@PathVariable int topicId) {
    //     Map<String, Object> response = new HashMap<>();
    //     System.out.println("======================");
    //     System.out.println("ResponseBody " + Fservice.getFlashcardByTopicId(topicId).size());
    //     System.out.println("======================");
    //     response.put("cards", Fservice.getFlashcardByTopicId(topicId));
    //     return response;
    // }
    


    @GetMapping("/learning/{phaseId}/cards")
    public String showCard(@PathVariable int phaseId, Model model) {
        System.out.println("Received phaseId::::::::: " + phaseId);
        // Fetch topics related to the selected phase
        var topics = topicRepo.findAllByPhasePhaseId(phaseId);
        model.addAttribute("topics", topics);


        // Load flashcards for the first topic (if any) as default
        if (!topics.isEmpty()) {
            var flashcards = flashcardRepo.findAllByTopicTopicId(topics.get(0).getTopicId());
            model.addAttribute("flashcards", flashcards);
        } else {
            model.addAttribute("flashcards", List.of());
        }
        System.out.println("Received phaseId::::::::: " + phaseId);
        return "card";
    }


    @GetMapping("/flashcards/{topicId}")
    @ResponseBody
    public List<Flashcard> getFlashcardsByTopic(@PathVariable int topicId) {
        return flashcardRepo.findAllByTopicTopicId(topicId);
    }


}