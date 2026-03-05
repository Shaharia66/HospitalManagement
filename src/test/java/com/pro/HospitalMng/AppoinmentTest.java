package com.pro.HospitalMng;

import com.pro.HospitalMng.entity.Appointment;
import com.pro.HospitalMng.service.AppoinmentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

@SpringBootTest
public class AppoinmentTest {
    @Autowired
    private AppoinmentService appoinmentService;
    @Test
    public void testAppoinment(){
        Appointment appointment = Appointment.builder()
                .appointmentDateTime(LocalDateTime.of(2026,3,12,12,0,0))
                .reason("gastric problem")
                .build();
        Appointment app=appoinmentService.createAppointment(appointment,2L,2L);
        System.out.println(app);
    }

}
