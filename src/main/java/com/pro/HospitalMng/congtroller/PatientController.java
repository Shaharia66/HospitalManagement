package com.pro.HospitalMng.congtroller;

import com.pro.HospitalMng.entity.Patient;
import com.pro.HospitalMng.service.PatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class PatientController {
    private final PatientService patientService;

    @GetMapping("/all/{id}")
    public List<Patient> findAll(@PathVariable Long id){
        return patientService.findAll(id);
    }


}
