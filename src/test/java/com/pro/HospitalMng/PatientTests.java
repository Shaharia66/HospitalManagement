package com.pro.HospitalMng;

import com.pro.HospitalMng.entity.Patient;
import com.pro.HospitalMng.entity.type.BloodGroupType;
import com.pro.HospitalMng.repository.PatientRepo;
import com.pro.HospitalMng.service.PatientService;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Sort;

import java.time.LocalDate;
import java.util.List;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@SpringBootTest
public class PatientTests {
    @Autowired
    private PatientRepo patientRepo;
    @Test
    public void testPatientRepo(){
        List<Patient> patients = patientRepo.findAll();
        System.out.println(patients);
    }
    @Autowired
    private PatientService patientService;
    @Test
    public void testMethod(){
//        Patient P=patientService.getPatientById(3L);
//        System.out.println(P);
        Patient p=patientRepo.findByName("Rahi");
        p.setEmail("rahi123@gmail.com");
        patientRepo.save(p);
        System.out.println(p);
    }
    @Test
    public void testFind(){
        List<Patient> patients=patientRepo.findByBirthDateOrEmail(LocalDate.of(1999,06,23),"kajol@gmail.som");
        System.out.println(patients);
    }
    @Test
    public void testFindByBloodGroup(){
        List<Patient> p=patientRepo.findByBloodGroup(BloodGroupType.B_P);
        System.out.println(p);
    }
    @Test
    public void testAfterDate(){
        List<Patient> p=patientRepo.findAfterBirthDate(LocalDate.of(1999,6,20));
        System.out.println(p);
    }
    @Test
    public void testBG(){
        List<Object[]> bg=patientRepo.countEachBloodGroup();
        for(Object[] obj:bg) {
            System.out.println(obj[0] + " " + obj[1]);
        }
    }
    @Test
    public void testBySql(){
        List<Patient> p=patientRepo.findAllPat();
        System.out.println(p);
    }
    @Test
    public void testByUpdate(){
        int  upd=patientRepo.updateNameById("shaha",102L);
        System.out.println(upd);
    }
    @Test
    public void testPage(){
        Page<Patient> p=patientRepo.findAllPat(PageRequest.of(1,3, Sort.by("name")));
        System.out.println(p.getContent());
    }
    @Test
    public void testDelete() {
        patientRepo.deleteById(102L); // pass the id you want to delete
        System.out.println("Deleted Successfully!");
    }
}

