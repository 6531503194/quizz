package com.edtech.quizz.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.edtech.quizz.Model.Users;

@Repository
public interface UsersRepo extends JpaRepository<Users,Integer>{
    
}