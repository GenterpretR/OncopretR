package com.controllers.admin;

import com.models.User;
import com.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/v1/admin")
public class UserController {
    @Autowired
    UserRepository userRepository;

    @GetMapping("/getAllUsers")
    @PreAuthorize("hasRole('ADMIN')")
    public List<User> allAccess() {
        return userRepository.findAll();
    }

    @PostMapping("/user")
    @PreAuthorize("hasRole('ADMIN')")
    public String userAccess() {
        return "User Content.";
    }

    @GetMapping("/user/activate/{userId}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<String> activateUser(@PathVariable Long userId) throws Exception {
        Optional<User> user = userRepository.findById(userId);
        if (user.isPresent()) {
            User userObject = user.get();
            userObject.setEnabled(true);
            userRepository.save(userObject);
        } else {
            throw new Exception("User Not Found");
        }
        return ResponseEntity.ok("User activated");
    }

    @GetMapping("/user/deactivate/{userId}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<String> deActivateUser(@PathVariable Long userId) throws Exception {
        Optional<User> user = userRepository.findById(userId);
        if (user.isPresent()) {
            User userObject = user.get();
            userObject.setEnabled(false);
            userRepository.save(userObject);
        } else {
            throw new Exception("User Not Found");
        }
        return ResponseEntity.ok("User activated");
    }

    @DeleteMapping("/user/delete/{userId}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<String> deleteUser(@PathVariable Long userId) throws Exception {
        Optional<User> user = userRepository.findById(userId);
        if (user.isPresent()) {
            User userObject = user.get();
            userRepository.deleteById(userId);
        } else {
            throw new Exception("User Not Found");

        }
        return ResponseEntity.ok("User Deleted");
    }
//
//    @GetMapping("/mod")
//    @PreAuthorize("hasRole('MODERATOR')")
//    public String moderatorAccess() {
//        return "Moderator Board.";
//    }
//
//    @GetMapping("/admin")
//    @PreAuthorize("hasRole('ADMIN')")
//    public String adminAccess() {
//        return "Admin Board.";
//    }
}
