package com.pro.HospitalMng.repository;

import com.pro.HospitalMng.entity.Insurance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InsuranceRepo extends JpaRepository<Insurance, Long> {
}