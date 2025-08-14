package org.example.rest.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping
public class APUserController {

    @Autowired
    private APUserService APUserService;

    @PostMapping("/auth/login")
    public ResponseEntity authenticateUser(@RequestBody APUser user){
        return APUserService.authenticateUser(user);
    }

    @PostMapping("/user")
    public APUser createNewUser(@RequestBody APUser user){
        return APUserService.createNewUser(user);
    }
}
