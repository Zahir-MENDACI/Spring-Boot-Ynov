package com.ynov.medical.patientws.daos;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.cloud.FirestoreClient;
import com.ynov.medical.patientws.models.Patient;

import org.springframework.stereotype.Repository;

@Repository
public class PatientDao implements IPatientDao {

    public List<Patient> findAllPatient() throws InterruptedException, ExecutionException {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        List<Patient> patients = new ArrayList<Patient>();
        ApiFuture<QuerySnapshot> future = dbFirestore.collection("patients").get();
        List<QueryDocumentSnapshot> documents = future.get().getDocuments();
        if (!documents.isEmpty()) {
            for (QueryDocumentSnapshot document : documents) {
                Map<String,Object> result = document.getData();
                Patient patient = new Patient(result);
                patients.add(patient);
            }            
            return patients;
        } else {
            return null;
        }
    }

    public Patient findPatientById(String idPatient) throws InterruptedException, ExecutionException {
        System.out.println("-------------" +idPatient);
        Firestore dbFirestore = FirestoreClient.getFirestore();
        ApiFuture<DocumentSnapshot> future = dbFirestore.collection("patients").document(idPatient).get();
        DocumentSnapshot documentSnapshot = future.get();
        if (documentSnapshot.exists()) {           
            Patient patient = new Patient(documentSnapshot.getData());
            System.out.println("-------------" +patient);
            return patient;
        } else {
            return null;
        }
    }

    public boolean addPatient(Patient patient) {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        DocumentReference ref = dbFirestore.collection("patients").document();
        patient.setId(ref.getId());
        ApiFuture<WriteResult> future = ref.set(patient);
        return future.isDone();
    }

    @Override
    public Patient findPatientById(Integer idPatient) {
        // TODO Auto-generated method stub
        return null;
    }

}
