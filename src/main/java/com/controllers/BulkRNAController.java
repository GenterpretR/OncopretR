package com.controllers;

import com.models.BulkRNA;
import com.models.User;
import com.repository.BulkRNARepository;
import com.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/bulkRNA")
@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
public class BulkRNAController {
    @Autowired
    BulkRNARepository bulkRNARepository;
    @Autowired
    UserRepository userRepository;


    @GetMapping("/tasks/{userId}")

    public List<BulkRNA> getAllJobs(@PathVariable Long userId) {
        Optional<User> user = userRepository.findById(userId);
        if (user.isPresent()) {
            return bulkRNARepository.findAllByUser(user.get());
        }
        return null;
    }

    @PostMapping(value = "/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public List<BulkRNA> uploadBulkRNACSVFile(@RequestParam("file") MultipartFile file, @RequestParam("userId") Long userId) throws IOException {
        User user = userRepository.getOne(userId);
        BulkRNA task = new BulkRNA();
        task.setUser(user);
        task.setFileContent(file.getBytes());
        bulkRNARepository.save(task);
        return null;

//        return userRepository.findAll();
    }

//    @PostMapping("/user")
//    @PreAuthorize("hasRole('ADMIN')")
//    public String userAccess() {
//        return "User Content.";
//    }
//
//    @GetMapping("/user/activate/{userId}")
//    @PreAuthorize("hasRole('ADMIN')")
//    public ResponseEntity<String> activateUser(@PathVariable Long userId) throws Exception {
//        Optional<User> user = userRepository.findById(userId);
//        if (user.isPresent()) {
//            User userObject = user.get();
//            userObject.setEnabled(true);
//            userRepository.save(userObject);
//        } else {
//            throw new Exception("User Not Found");
//        }
//        return ResponseEntity.ok("User activated");
//    }
//
//    @GetMapping("/user/deactivate/{userId}")
//    @PreAuthorize("hasRole('ADMIN')")
//    public ResponseEntity<String> deActivateUser(@PathVariable Long userId) throws Exception {
//        Optional<User> user = userRepository.findById(userId);
//        if (user.isPresent()) {
//            User userObject = user.get();
//            userObject.setEnabled(false);
//            userRepository.save(userObject);
//        } else {
//            throw new Exception("User Not Found");
//        }
//        return ResponseEntity.ok("User activated");
//    }
//
//    @DeleteMapping("/user/delete/{userId}")
//    @PreAuthorize("hasRole('ADMIN')")
//    public ResponseEntity<String> deleteUser(@PathVariable Long userId) throws Exception {
//        Optional<User> user = userRepository.findById(userId);
//        if (user.isPresent()) {
//            User userObject = user.get();
//            userRepository.deleteById(userId);
//        } else {
//            throw new Exception("User Not Found");
//
//        }
//        return ResponseEntity.ok("User Deleted");
//    }
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
