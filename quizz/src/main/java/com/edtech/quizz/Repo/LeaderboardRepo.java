package com.edtech.quizz.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.edtech.quizz.Model.Leaderboard;

@Repository
public interface LeaderboardRepo extends JpaRepository<Leaderboard,Integer> {
    
}
