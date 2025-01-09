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

    @Autowired
    private QuestionService QService;

    @Autowired
    private AnswerService Aservice;

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
        int questionId = 1;
        model.addAttribute("questionId", questionId);
        return "game_set";
    }

    @GetMapping("/game/{phaseId}/quiz/{quizId}/{questionId}")
    public String quiz(Model model, @PathVariable("phaseId") int phaseId, @PathVariable("quizId") int quizId, @PathVariable("questionId") int questionId) {

        List<Question> questions = QService.getQuestionsByQuizId(quizId);
    
        Question currentQuestion = questions.stream()
                                            .filter(q -> q.getQuestionId() == questionId)
                                            .findFirst()
                                            .orElseThrow(() -> new IllegalArgumentException("Invalid questionId"));
        
        List<Answer> answers = Aservice.getAnswersByQuestion(List.of(currentQuestion));
        int A = answers.size();
        System.out.println("++++Size of answer ++++++++++  ");
        System.out.println(A);
        System.out.println("+++++++++++++++++++");

        model.addAttribute("questions", questions);
        model.addAttribute("question", currentQuestion);
        model.addAttribute("answers", answers);
        model.addAttribute("phaseId", phaseId);
        model.addAttribute("quizId", quizId);

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
