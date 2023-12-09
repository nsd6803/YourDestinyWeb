package com.example.yourdestinyweb.services;

import lombok.AllArgsConstructor;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
@EnableScheduling
@AllArgsConstructor
public class ScheduleService {
    private final AppointmentService appointmentsService;




    @Scheduled(fixedRate = 1000 * 60 * 15)
    public void updateAppointments() {
        appointmentsService.deleteOld();
    }


}