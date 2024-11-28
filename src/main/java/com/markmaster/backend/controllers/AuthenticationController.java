package com.markmaster.backend.controllers;

import com.markmaster.backend.helpers.HttpResponseMessageHandler;
import com.markmaster.backend.models.User;
import com.markmaster.backend.service.User.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {
    @Autowired
    private UserService userService;

    @Autowired
    private HttpResponseMessageHandler responseMessageHandler;

    @PostMapping("/register")
    public ResponseEntity<Map<String, Object>> register(@RequestBody User user) {
        return responseMessageHandler.updateHttpResponse("Success", HttpStatus.OK, userService.register(user));
    }

    @PostMapping("/login")
    public ResponseEntity<Map<String, Object>> login(@RequestBody User user) {
        try {

            String validatedUser = userService.login(user.getUsername(), user.getPassword());
            if (validatedUser != null) {
                return responseMessageHandler.updateHttpResponse("Success", HttpStatus.OK, validatedUser);
            }
            return responseMessageHandler.updateHttpResponse("Invalid username or password", HttpStatus.UNAUTHORIZED);
        } catch (BadCredentialsException e) {
            return responseMessageHandler.updateHttpResponse("Invalid username or password", HttpStatus.UNAUTHORIZED);

        }

    }
}
