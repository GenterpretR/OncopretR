package com.controllers;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.fasterxml.jackson.databind.util.JSONWrappedObject;
import com.models.BulkRNA;
import com.models.Drug;
import com.models.User;
import com.payload.JobResult;
import com.repository.BulkRNARepository;
import com.repository.DrugRepository;
import com.repository.UserRepository;
import org.h2.util.json.JSONBytesSource;
import org.h2.util.json.JSONItemType;
import org.h2.util.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.net.URL;
import java.util.*;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/bulkRNA")

public class BulkRNAController {
    @Autowired
    BulkRNARepository bulkRNARepository;
    @Autowired
    UserRepository userRepository;

    @Autowired
    DrugRepository drugRepository;

    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    @GetMapping("/jobs/{userId}")
    public List<BulkRNA> getAllJobs(@PathVariable UUID userId) {
        Optional<User> user = userRepository.findById(userId);
        if (user.isPresent()) {
            List<BulkRNA> results = bulkRNARepository.findAllByUser(user.get());
            return results.size() > 0 ? results : Arrays.asList();

        }
        return null;
    }

    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    @GetMapping("/jobs/results/{taskId}")
    public BulkRNA getAllJobs(@PathVariable Long taskId) {
        Optional<BulkRNA> task = bulkRNARepository.findById(taskId);
        if (task.isPresent()) {
            return task.get();
        }
        return null;
    }

    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    @GetMapping("/drugs")
    public List<Drug> getAllDrugs() {
        return drugRepository.findAll();
    }

    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    @PostMapping(value = "/create-new-job", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public void uploadBulkRNACSVFile(@RequestParam("file") MultipartFile uploadedFile, @RequestParam("userId") UUID userId,
                                     @RequestParam("selectedDrugs") String selectedDrugs) throws IOException {
        User user = userRepository.getOne(userId);
        BulkRNA task = new BulkRNA();
        task.setProcessed(false);
        task.setUser(user);
        task.setFileContent(uploadedFile.getBytes());
        bulkRNARepository.save(task);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.MULTIPART_FORM_DATA);
        MultiValueMap<String, Object> body
                = new LinkedMultiValueMap<>();
        body.add("taskId", task.getId());

//        Iterator<String> itr = request.getFileNames();
//        MultipartFile file = request.getFile(itr.next());
//        formData .add("files", );
        body.add("uploadedFile", new ByteArrayResource(uploadedFile.getBytes()));
        body.add("selectedDrugs", selectedDrugs);
        HttpEntity<MultiValueMap<String, Object>> requestEntity
                = new HttpEntity<>(body, headers);
        String serverUrl = "http://20.198.107.58:8080/create-new-task";
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate
                .postForEntity(serverUrl, requestEntity, String.class);
    }

    @PostMapping(value = "/save-result/{taskId}")
    public void saveResultOfTask(@RequestBody String result, @PathVariable Long taskId) throws IOException {
        BulkRNA task = bulkRNARepository.getOne(taskId);
        if (task != null) {
            task.setProcessed(true);
            task.setResult(result);
            bulkRNARepository.save(task);
        }
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