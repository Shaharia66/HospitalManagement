package com.pro.HospitalMng.service;

import com.pro.HospitalMng.entity.Insurance;
import com.pro.HospitalMng.entity.Patient;
import com.pro.HospitalMng.repository.InsuranceRepo;
import com.pro.HospitalMng.repository.PatientRepo;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InsuranceService {
    private final InsuranceRepo insuranceRepo;
    private final PatientRepo patientRepo;

    @Transactional
    public Patient assignInsurance(Insurance insurance,Long patientId) {
        Patient patient = patientRepo.findById(patientId).orElseThrow();
        patient.setInsurance(insurance);
        insurance.setPatient(patient);
        return patient;
    }
}
