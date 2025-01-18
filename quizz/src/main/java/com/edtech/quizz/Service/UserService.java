package com.edtech.quizz.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.edtech.quizz.Model.Users;
import com.edtech.quizz.Repo.UsersRepo;

@Service
public class UserService {
    
    @Autowired
    private UsersRepo usersRepo;

    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);

    public Users register(Users user){
        user.setPassword(encoder.encode(user.getPassword()));
        return usersRepo.save(user);
    }

    public List<Users> getallUsers() {
        return usersRepo.findAll();
    }

}
