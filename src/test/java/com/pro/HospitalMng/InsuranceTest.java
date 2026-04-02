package com.pro.HospitalMng;

import com.pro.HospitalMng.entity.Insurance;
import com.pro.HospitalMng.entity.Patient;
import com.pro.HospitalMng.service.InsuranceService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

@SpringBootTest

public class InsuranceTest {
    @Autowired
    private InsuranceService insuranceService;
    @Test
    public void insertInsurance() {
        Insurance insurance =Insurance.builder()
                .policyNumber("HDFC_1234")
                .provider("HDBC")
                .expiryDate(LocalDate.of(2026,3,10))
                .build();
        Patient patient = insuranceService.assignInsurance(insurance,1L);
        System.out.println(patient);
    }
}
