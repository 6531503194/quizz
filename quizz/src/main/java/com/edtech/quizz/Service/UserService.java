package com.edtech.quizz.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.edtech.quizz.Model.Users;
import com.edtech.quizz.Repo.UsersRepo;

@Service
public class UserService {
    
    @Autowired
    private UsersRepo usersRepo;

    @Autowired
    private JWTService jwtService;

    @Autowired
    private AuthenticationManager authManager;

    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);

    public Users register(Users user){
        user.setPassword(encoder.encode(user.getPassword()));
        return usersRepo.save(user);
    }

    public List<Users> getallUsers() {
        return usersRepo.findAll();
    }

    public String verify(Users user) {
        Authentication authentication = 
                authManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
        
        if(authentication.isAuthenticated()){
            return  jwtService.generateToken(user.getUsername());
        }else{
            return "Login not successful";
        }
    }

}
