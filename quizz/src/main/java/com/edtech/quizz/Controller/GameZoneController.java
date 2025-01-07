package com.edtech.quizz.Controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

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
        model.addAttribute("quizs", quizzs);
        return "game_set";
    }

    //Below this code are not done(This method is just for testing)
    @GetMapping("/game/1/quiz/1")
    public String quiz(){
        return "quiz";
    }

    // @GetMapping("/check/{questionId}/{answerId}")
    // @ResponseBody
    // public Map<String, Object> checkQuiz(@PathVariable("questionId") int questionId,@PathVariable("answerId") int answerId) {
    //     Map<String, Object> response = new HashMap<>();
    //     System.out.println("======================");
    //     System.out.println("ResponseBody " +Fservice.getFlashcardByTopicId(questionId).size());
    //     System.out.println("======================");
    //     response.put("cards", Fservice.getFlashcardByTopicId(questionId));
    //     return response;
    // }

    
}
