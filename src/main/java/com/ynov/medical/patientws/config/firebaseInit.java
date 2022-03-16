package com.ynov.medical.patientws.config;

import java.io.FileInputStream;
import java.io.InputStream;

import javax.annotation.PostConstruct;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

@Service
public class firebaseInit {

    @Autowired
    ResourceLoader resourceLoader;

    @PostConstruct
    public void initialize() {
        try {

            Resource resource = resourceLoader.getResource("classpath:spring-boot-project-1ec7e-firebase-adminsdk-wg14k-6e36798a24.json");
            InputStream serviceAccount = resource.getInputStream();

            FirebaseOptions options = FirebaseOptions.builder()
                    .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                    .build();

            FirebaseApp.initializeApp(options);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
