package com.edtech.quizz.Model;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString(exclude = {"leaderboard", "quiz"})
public class Users {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int userId;
    private String email;
    private String password;
    private int level;
    private int userXp;
    private Timestamp timeSpent;
    private int quizSet;
    private int highestScore;
    private String pfPicture;
    private Date createdDate;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Leaderboard> leaderboards;
}
