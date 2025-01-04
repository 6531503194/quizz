package com.edtech.quizz.Model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Flashcard {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int cardId;
    private String cardName;
    private String cardImg;
    private String definition;
    
    @ManyToOne
    @JoinColumn(name = "topic_id", nullable = false)
    private Topic topic;
    
}
