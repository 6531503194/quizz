package com.edtech.quizz.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.edtech.quizz.Model.Topic;
import com.edtech.quizz.Service.FlashcardService;
import com.edtech.quizz.Service.PhaseService;
import com.edtech.quizz.Service.TopicService;



@Controller
public class FroentEndTestingController {


       
    @Autowired
    private FlashcardService Fservice;

    @Autowired
    private TopicService Tservice;
    
    @Autowired
    private PhaseService Pservice;

     @GetMapping({"/","/home"})
    public String homePage(){
        return "home";
    }

    // @GetMapping("/learning_zone")
    // public String learningZone(){
    //     return "learning_zone";
    // }

    @GetMapping("/card_collection")
    public String favIcon(){
        return "card_collection";
    }

    @GetMapping("/quiz_result")
    public String getMethodName() {
        return "quiz_result";
    }
    

        @GetMapping("/test/learning/{phaseId}")
    public String getMethodName(@PathVariable int phaseId, Model model) {

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
            // model.addAttribute("cards", Fservice.getFlashcardByTopicId(firstTopicId));
        } else {
            // If no topics are available, send an empty list
            // model.addAttribute("cards", new ArrayList<>());
        }

        return "test";
    }


}
