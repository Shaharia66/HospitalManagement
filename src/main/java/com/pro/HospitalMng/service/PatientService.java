package com.pro.HospitalMng.service;

import com.pro.HospitalMng.entity.Patient;
import com.pro.HospitalMng.repository.PatientRepo;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PatientService {
    private final PatientRepo patientRepo;
    @Transactional
    public Patient getPatientById(Long id){
        Patient p1= patientRepo.findById(id).orElseThrow();

        p1.setName("Rahi");

        return p1;
    }

    public List<Patient> findAll(Long id) {
       patientRepo.findById(id).orElseThrow(()->new IllegalArgumentException("not found") );
       return patientRepo.findAll();
    }
}
