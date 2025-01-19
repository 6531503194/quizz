package com.edtech.quizz.Service;

import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

import org.springframework.stereotype.Service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
//this class have lots of comment because I forgot after I wrote the code555

@Service
public class JWTService {

    private String secretKey = "";

//this is for generate the valid key But The Key will be in String format
    public JWTService(){
        try {
            KeyGenerator keyGen = KeyGenerator.getInstance("HmacSHA256");
            SecretKey sk = keyGen.generateKey();
            secretKey = Base64.getEncoder().encodeToString(sk.getEncoded());

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }
    
//This method change the string format key into the data Type of Key object
    private Key getKey() {
        byte[] keyBytes =  Decoders.BASE64.decode(secretKey) ; 
        return Keys.hmacShaKeyFor(keyBytes);
    }

/* For one JWT Token we have steps to built a token.
 * 1. We need to build the claims first , 
 * and then we have to claims the builder
 * and then we have to add our Map to the token
 * then you can add what you want to have in your token like subject, issuedAt and expiration
 * after the body you have to add the key signature of the toke to be valid
 * and you can compact the token Done!
 */

    public String generateToken(String username) {

        Map<String , Object> claims = new HashMap<>();

        return Jwts.builder()
                   .claims()
                   .add(claims)
                   .subject(username)
                   .issuedAt(new Date(System.currentTimeMillis()))
                   .expiration(new Date(System.currentTimeMillis() + 60 * 60 * 30))
                   .and()
                   .signWith(getKey())
                   .compact();
    }


    
}
