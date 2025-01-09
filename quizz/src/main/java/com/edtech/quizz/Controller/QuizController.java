package com.edtech.quizz.Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edtech.quizz.Model.Answer;
import com.edtech.quizz.Model.Question;
import com.edtech.quizz.Service.AnswerService;
import com.edtech.quizz.Service.QuestionService;

@RestController
@RequestMapping("/game")
public class QuizController {

    
    @Autowired
    private QuestionService QService;

    @Autowired
    private AnswerService Aservice;
    
    @GetMapping("/{phaseId}/quiz/{quizId}/{questionId}/data")
    public ResponseEntity<?> getQuizData(@PathVariable("phaseId") int phaseId,
                                         @PathVariable("quizId") int quizId,
                                         @PathVariable("questionId") int questionId) {

        List<Question> questions = QService.getQuestionsByQuizId(quizId);

        Question currentQuestion = questions.stream()
                .filter(q -> q.getQuestionId() == questionId)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Invalid questionId"));

        List<Answer> answers = Aservice.getAnswersByQuestion(List.of(currentQuestion));

        Map<String, Object> response = new HashMap<>();
        response.put("question", currentQuestion);
        response.put("answers", answers);
        response.put("totalQuestions", questions.size());

        return ResponseEntity.ok(response);
    }
}
