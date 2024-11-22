package com.markmaster.backend.service.User;

import com.markmaster.backend.models.User;
import com.markmaster.backend.repository.UserRepo;
import com.markmaster.backend.service.JWT.JWTService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;
    private final BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(12);
    @Autowired
    private final AuthenticationManager authManager;
    @Autowired
    private JWTService jwtService;

    public UserService(AuthenticationManager authManager) {
        this.authManager = authManager;
    }

    public User register(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        return userRepo.save(user);
    }

    public String login(String username, String password) {
        Authentication authentication = authManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        User user = userRepo.findByUsername(username);
        return authentication.isAuthenticated() ? jwtService.generateToken(username) : null;
    }
}
