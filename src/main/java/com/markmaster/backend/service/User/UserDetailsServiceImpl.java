//package com.markmaster.backend.service.User;
//
//import com.markmaster.backend.models.User;
//import org.springframework.stereotype.Service;
//import com.markmaster.backend.repository.UserRepo;
//
//
//import java.util.List;
//import java.util.Optional;
//
//@Service
//public class UserDetailsService {
//    private final UserRepo userRepo;
//
//    public UserDetailsService( UserRepo userRepo) {
//        this.userRepo = userRepo;
//    }
//
//
//
//    public List<User> findAll() {
//        return userRepo.findAll();
//    }
//
//    public Optional<User> findById(int id) {
//        return userRepo.findById(id);
//    }
//
//    public User save(User userDetails) {
//        return userRepo.save(userDetails);
//    }
//
//    public void deleteById(int id) {
//        userRepo.deleteById(id);
//    }
//}
package com.markmaster.backend.service.User;

import com.markmaster.backend.models.User;
import com.markmaster.backend.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    private final UserRepo userRepo;

    @Autowired
    public UserDetailsServiceImpl(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    // Method required by Spring Security
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepo.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }

        return org.springframework.security.core.userdetails.User
                .withUsername(user.getUsername())
                .password(user.getPassword())
                .authorities("ROLE_USER") // You can dynamically fetch roles if needed
                .accountExpired(false)
                .accountLocked(false)
                .credentialsExpired(false)
                .disabled(false)
                .build();
    }

    // Additional CRUD methods
    public List<User> findAll() {
        return userRepo.findAll();
    }

    public Optional<User> findById(int id) {
        return userRepo.findById(id);
    }

    public User save(User userDetails) {
        return userRepo.save(userDetails);
    }

    public void deleteById(int id) {
        userRepo.deleteById(id);
    }
}
