package com.gcp.examples.service;

import com.google.cloud.storage.BucketInfo;
import com.google.cloud.storage.Storage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StorageService {

    @Autowired
    private Storage storage;

    private static final Logger log = LoggerFactory.getLogger(StorageService.class);
    public void createBucket(String bucketName) {
        try {
            String location = "ASIA";
            //create a bucket with the default storage class
            BucketInfo bucket = BucketInfo.newBuilder(bucketName)
                    .setLocation(location)
                    .build();
            storage.create(bucket);
            log.info("Creating bucket: {}", bucketName);
        } catch (Exception e) {
            log.error("Exception occurred while creating bucket: {}", e.getMessage());
        }
    }
}