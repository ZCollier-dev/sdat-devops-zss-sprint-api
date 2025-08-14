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
public class APUserService {

    @Autowired
    private APUserRepository APUserRepo;

    private final Key secretKey = Keys.secretKeyFor(SignatureAlgorithm.HS256);

    public APUser findUserByEmail(String email){
        return APUserRepo.findByEmail(email);
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

    public ResponseEntity authenticateUser(APUser user){
            APUser foundUser = findUserByEmail(user.getEmail());

            if (foundUser != null && BCrypt.checkpw(user.getPassword(), foundUser.getPassword())){
                return ResponseEntity
                        .status(HttpStatus.OK)
                        .body(Map.of("token", generateToken(user.getEmail())));
            } else {
                return ResponseEntity
                        .status(HttpStatus.UNAUTHORIZED)
                        .body(Map.of("message", "Invalid credentials"));
            }
    }

    public APUser createNewUser(APUser user){
        APUser newUser = user;
        newUser.setPassword(BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt()));
        return APUserRepo.save(newUser);
    }
}
