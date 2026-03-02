package com.pro.HospitalMng.repository;

import com.pro.HospitalMng.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepo extends JpaRepository<Department, Long> {
}