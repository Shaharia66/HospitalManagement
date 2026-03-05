package com.pro.HospitalMng.service;

import com.pro.HospitalMng.entity.Appointment;
import com.pro.HospitalMng.entity.Doctor;
import com.pro.HospitalMng.entity.Patient;
import com.pro.HospitalMng.repository.AppointmentRepo;
import com.pro.HospitalMng.repository.DoctorRepo;
import com.pro.HospitalMng.repository.PatientRepo;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AppoinmentService {
    private final AppointmentRepo appointmentRepo;
    private final DoctorRepo doctorRepo;
    private final PatientRepo patientRepo;

    @Transactional
    public Appointment createAppointment(Appointment appointment,Long doctorId,Long patientId) {
        Patient patient = patientRepo.findById(patientId).orElseThrow();
        Doctor doctor = doctorRepo.findById(doctorId).orElseThrow();
        if(appointment.getId()!=null) throw new IllegalArgumentException("appoinment should not have id");
        appointment.setDoctor(doctor);
        appointment.setPatient(patient);
        appointmentRepo.save(appointment);
        patient.getAppointment().add(appointment);
        return appointment;
    }
}
