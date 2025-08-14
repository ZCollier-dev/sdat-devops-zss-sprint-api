package org.example.rest.user;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import org.mindrot.jbcrypt.BCrypt;

import java.security.Key;
import java.util.Map;
import java.util.Date;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepo;

    private final Key secretKey = Keys.secretKeyFor(SignatureAlgorithm.HS256);

    public User findUserByEmail(String email){
        return userRepo.findByEmail(email);
    }

    private String generateToken(String email){
        long nowMillis = System.currentTimeMillis();
        long expirationMillis = 1000 * 60 * 60;

        return Jwts.builder()
                .setSubject(email)
                .setIssuedAt(new Date(nowMillis))
                .setExpiration(new Date(nowMillis + expirationMillis))
                .signWith(secretKey)
                .compact();
    }

    public ResponseEntity authenticateUser(String email, String password){
            User foundUser = findUserByEmail(email);

            if (foundUser != null && BCrypt.checkpw(password, foundUser.getPassword())){
                return ResponseEntity
                        .status(HttpStatus.OK)
                        .body(Map.of("token", generateToken(email)));
            } else {
                return ResponseEntity
                        .status(HttpStatus.UNAUTHORIZED)
                        .body(Map.of("message", "Invalid credentials"));
            }
    }

    public User createNewUser(User user){
        user.setPassword(BCrypt.hashpw(user.getPassword(), BCrypt.gensalt()));
        return userRepo.save(user);
    }
}
