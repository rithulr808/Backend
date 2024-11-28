package com.markmaster.backend.controllers;

import com.markmaster.backend.helpers.HttpResponseMessageHandler;
import com.markmaster.backend.models.User;
import com.markmaster.backend.service.User.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/user")
public class UserDetailsController {
    private final UserDetailsServiceImpl userDetailsService;
    private final HttpResponseMessageHandler httpResponseUpdater;

    @Autowired
    public UserDetailsController(UserDetailsServiceImpl userDetailsService, HttpResponseMessageHandler httpResponseUpdater) {
        this.userDetailsService = userDetailsService;
        this.httpResponseUpdater = httpResponseUpdater;
    }

    @GetMapping("/all")
    public ResponseEntity<Map<String, Object>> getAllUsers() {
        return httpResponseUpdater.updateHttpResponse("Success", HttpStatus.OK, userDetailsService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Map<String, Object>> getUserById(@PathVariable int id) {
        Optional<User> userOptional = userDetailsService.findById(id);
        if (userOptional.isPresent()) {
            return httpResponseUpdater.updateHttpResponse("Success", HttpStatus.OK, userOptional.get());
        }
        return httpResponseUpdater.updateHttpResponse("User not found", HttpStatus.NOT_FOUND);
    }

    @PostMapping("/{userId}/register-course/{courseId}")
    public ResponseEntity<Map<String, Object>> registerCourse(
            @PathVariable int userId,
            @PathVariable Long courseId) {
        try {
            User updatedUser = userDetailsService.registerCourseForUser(userId, courseId);
            return httpResponseUpdater.updateHttpResponse(
                    "Course registered successfully",
                    HttpStatus.OK,
                    updatedUser
            );
        } catch (RuntimeException e) {
            return httpResponseUpdater.updateHttpResponse(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }


    @PostMapping("/")
    public ResponseEntity<Map<String, Object>> createUser(@RequestBody User userDetails) {
        User savedUser = userDetailsService.save(userDetails);
        return httpResponseUpdater.updateHttpResponse("User created successfully", HttpStatus.CREATED, savedUser);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Map<String, Object>> updateUser(@PathVariable int id, @RequestBody User updatedDetails) {
        Optional<User> userOptional = userDetailsService.findById(id);

        if (userOptional.isPresent()) {
            User existingUser = userOptional.get();
            existingUser.setUsername(updatedDetails.getUsername());
            // Update other fields as needed
            userDetailsService.save(existingUser);

            return httpResponseUpdater.updateHttpResponse("User updated successfully", HttpStatus.OK, existingUser);
        }
        return httpResponseUpdater.updateHttpResponse("User not found", HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Object>> deleteUser(@PathVariable int id) {
        Optional<User> userOptional = userDetailsService.findById(id);
        if (userOptional.isPresent()) {
            userDetailsService.deleteById(id);
            return httpResponseUpdater.updateHttpResponse("User deleted successfully", HttpStatus.OK);
        }
        return httpResponseUpdater.updateHttpResponse("User not found", HttpStatus.NOT_FOUND);
    }
}

