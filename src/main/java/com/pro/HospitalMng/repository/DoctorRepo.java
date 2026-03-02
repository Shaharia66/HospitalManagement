package com.pro.HospitalMng.repository;

import com.pro.HospitalMng.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepo extends JpaRepository<Doctor, Long> {
}