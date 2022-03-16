package com.ynov.medical.patientws.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

import com.ynov.medical.patientws.daos.IPatientDao;
import com.ynov.medical.patientws.daos.PatientDao;
// import com.ynov.medical.patientws.daos.PatientDao;
import com.ynov.medical.patientws.models.Patient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// import reactor.core.publisher.Flux;

@RestController
public class PatientController {

    // IPatientDao patientDao;

    public static List<Patient> patients = new ArrayList<Patient>();

    static {
        Patient patient1 = new Patient("1", "patient1", 23);
        Patient patient2 = new Patient("2", "patient2", 24);
        Patient patient3 = new Patient("3", "patient3", 25);
        Patient patient4 = new Patient("4", "patient4", 26);

        patients.add(patient1);
        patients.add(patient2);
        patients.add(patient3);
        patients.add(patient4);
    }

    @Autowired
    PatientDao patientDao;

    @GetMapping("/patients")
    public List<Patient> getAllPatients() throws InterruptedException, ExecutionException {

        // Patient patient = new Patient();
        // patient.setId(1);
        // patient.setNom("patient1");
        // patient.setAge(23);
        // Patient patient2 = new Patient();
        // patient2.setId(2);
        // patient2.setNom("patient2");
        // patient2.setAge(25);

        // List<Patient> list = new ArrayList<Patient>();
        // list.add(patient);
        // list.add(patient2);

        // return PatientController.patients;
        return patientDao.findAllPatient();
    }

    @GetMapping("/patients/{idPatient}")
    public Patient getOnePatient(@PathVariable String idPatient) throws InterruptedException, ExecutionException {

        // for (Patient patient : PatientController.patients) {
        //     if (patient.getId().equals(idPatient)) {
        //         return patient;
        //     }
        // }
        return patientDao.findPatientById(idPatient);
    }

    @PostMapping("/addPatient")
    public boolean addPatient(@RequestBody Patient patient) {
        patientDao.addPatient(patient);
        return true;
    }
}
