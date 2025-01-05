package com.edtech.quizz.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class FroentEndTestingController {
    
    @GetMapping({"/","/home"})
    public String homePage(){
        return "home";
    }

    // @GetMapping("/learning_zone")
    // public String learningZone(){
    //     return "learning_zone";
    // }

    // @GetMapping("/card")
    // public String cardList(){
    //     return "card";
    // }

    @GetMapping("/card_collection")
    public String favIcon(){
        return "card_collection";
    }

}
