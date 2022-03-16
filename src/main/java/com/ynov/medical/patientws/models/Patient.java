package com.ynov.medical.patientws.models;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

// import com.google.cloud.firestore.annotation.DocumentId;

// import org.springframework.cloud.gcp.data.firestore.Document;


// @Document
public class Patient implements Serializable{
    // @DocumentId
    private String id;
    private String nom;
    private long age;
    // private List<Pathologie> listPaths;

    public Patient () {

    }

    public Patient (String id, String nom, long age) {
        this.id = id;
        this.nom = nom;
        this.age = age;
    }

    public Patient(Map<String, Object> map) {
        this.id = (String) map.get("id");
        this.nom = (String) map.get("nom");
        this.age = (long) map.get("age");
      }
    
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public long getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    // public List<Pathologie> getListPaths() {
    //     return listPaths;
    // }
    // public void setListPaths(List<Pathologie> listPaths) {
    //     this.listPaths = listPaths;
    // }
    
    
}