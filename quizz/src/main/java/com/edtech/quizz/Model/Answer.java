package com.edtech.quizz.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class Answer {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int answerId;
    private String answerText;
    private boolean iscorrect;

    @ManyToOne
    @JoinColumn(name = "question_id", nullable = false)
    private Question question;

}
