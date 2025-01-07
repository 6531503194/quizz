package com.edtech.quizz.Controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.edtech.quizz.Model.*;
import com.edtech.quizz.Service.*;


@Controller
public class GameZoneController {

    @Autowired
    private PhaseService Pservice;

    @Autowired
    private FlashcardService Fservice;

    @Autowired
    private TopicService Tservice;

    @Autowired
    private QuizService quizService;

    @GetMapping("/game_zone")
    public String gamezone(Model model){

        model.addAttribute( "phases" , Pservice.getAllPhase());

        return "game_zone";
    }

//Still coding (Not finish) This method will show the data for the quizset in One level or phase
    @GetMapping("/game_set/{phaseId}")
    public String getMethodName(@PathVariable int phaseId, Model model) {

        System.out.println("======================");
        String name = Pservice.getNameByPhaseId(phaseId);
        System.out.println(name);
        System.out.println("======================");

        if(name != null){
            model.addAttribute("name", name);
        }

        List<Topic> topics = Tservice.getTopicByPhaseId(phaseId);
        List<Quiz> quizzs = quizService.getQuizByTopicList(topics);
        System.out.println("======================");
        int Tsize = topics.size();
        System.out.println(Tsize);
        System.out.println("======================");
        int Qsize = quizzs.size();
        System.out.println(Qsize);
        System.out.println("======================");

        // model.addAttribute("quizzs", quizzs);

        // if (!topics.isEmpty()) {
        //     // Fetch flashcards for the first topic in the list (or default logic)
        //     int firstTopicId = topics.get(0).getTopicId();
        //     System.out.println("======================");
        //     System.out.println(Fservice.getFlashcardByTopicId(firstTopicId).size());
        //     System.out.println("======================");
        //     model.addAttribute("cards", Fservice.getFlashcardByTopicId(firstTopicId));
        // } else {
        //     // If no topics are available, send an empty list
        //     model.addAttribute("cards", new ArrayList<>());
        // }

        return "game_set";
    }
    
}
