package com.ynov.medical.patientws.daos;

import java.util.List;
import java.util.concurrent.ExecutionException;

import com.ynov.medical.patientws.models.Patient;

// import org.springframework.cloud.gcp.data.firestore.FirestoreReactiveRepository;
// import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPatientDao {

    public List<Patient> findAllPatient() throws InterruptedException, ExecutionException;

    public Patient findPatientById(Integer idPatient);

    public boolean addPatient(Patient patient);

    // public Patient save(Patient patient);
}
