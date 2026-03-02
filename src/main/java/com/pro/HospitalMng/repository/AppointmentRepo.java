package com.pro.HospitalMng.repository;

import com.pro.HospitalMng.entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepo extends JpaRepository<Appointment, Long> {
}