package com.edtech.quizz.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.edtech.quizz.Model.Phase;

@Repository
public interface PhaseRepo extends JpaRepository<Phase,Integer>{
    
}