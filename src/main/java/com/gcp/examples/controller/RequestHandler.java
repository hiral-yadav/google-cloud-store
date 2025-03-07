package com.gcp.examples.controller;

import com.gcp.examples.service.StorageService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class RequestHandler {

    @Autowired
    private StorageService storageService;

    @GetMapping("/createBucket/{bucketName}")
    public ResponseEntity<String> createBucket(@PathVariable("bucketName") String bucketName) {
//        log.info("Creating bucket: {}", bucketName);
        storageService.createBucket(bucketName);
        return ResponseEntity.ok("Bucket created successfully");
    }


}
