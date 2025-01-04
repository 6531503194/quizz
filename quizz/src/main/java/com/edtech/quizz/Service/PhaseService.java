package com.edtech.quizz.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edtech.quizz.Model.Phase;
import com.edtech.quizz.Repo.PhaseRepo;

@Service
public class PhaseService {
    
    @Autowired
    private PhaseRepo Prepo;

    public List<Phase> getAllPhase(){
        return Prepo.findAll();
    }
}
