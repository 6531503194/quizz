package com.edtech.quizz.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.edtech.quizz.Service.FlashcardService;
import com.edtech.quizz.Service.PhaseService;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class LearningZoneController {
    
    @Autowired
    private FlashcardService Fservice;
    
    @Autowired
    private PhaseService Pservice;

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

    // @GetMapping("/learning/{phaseId}")
    // public String getMethodName(@PathVariable int phaseId,Model model) {
    //     model.addAttribute( "phases" , Pservice.getAllPhase());
    //     model.addAttribute("cards", Fservice.allcards());
    //     return "LearningTest";
    // }
    

}
