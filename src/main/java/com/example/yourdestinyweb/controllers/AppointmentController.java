package com.example.yourdestinyweb.controllers;

import com.example.yourdestinyweb.models.Appointment;
import com.example.yourdestinyweb.models.Doctor;
import com.example.yourdestinyweb.models.User;
import com.example.yourdestinyweb.services.DoctorService;
import com.example.yourdestinyweb.services.AppointmentService;
import com.example.yourdestinyweb.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;
import java.util.List;

@Controller
public class AppointmentController {
    @Autowired
    private AppointmentService appointmentsService;
    @Autowired
    private DoctorService doctorService;
    @Autowired
    private UserService userService;

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/appointment/list/{id}")
    public String appointmentsList(Model model, @PathVariable Long id) {
        Doctor doctor = doctorService.getDoctorById(id);
        List<Appointment> appointments = appointmentsService.listAppointments(doctor);
        model.addAttribute("doctor", doctor);
        model.addAttribute("appointments", appointments);
        return "doctor-appointments";
    }

    @GetMapping("/appointment")
    public String showAppointments(Model model, Principal principal) {
        User user = userService.getUserByPrincipal(principal);
        List<Appointment> appointments = appointmentsService.userAppointments(user);;
        model.addAttribute("user", user);
        model.addAttribute("appointments", appointments);
        return "appointments";
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping("/appointment/add/")
    public String addNewAppointment(@RequestParam("doctorId") Doctor doctor,
                                   @RequestParam("date") String date,
                                   @RequestParam("time") String time) {
        appointmentsService.addAppointment(doctor, date, time);
        return "redirect:/appointment/list/" + doctor.getId();
    }

    @PostMapping("/appointment/cancel")
    public String cancelAppointment(@RequestParam("appointmentId") Appointment appointment) {
        appointmentsService.cancelAppointment(appointment);
        return "redirect:/appointment";
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping("/appointment/delete/{id}")
    public String deleteAppointment(@PathVariable Long id,
                                   @RequestParam("doctorId") Doctor doctor) {
        appointmentsService.deleteAppointment(id);
        return "redirect:/appointment/list/" + doctor.getId();
    }

    @PostMapping("/appointment/add/user")
    public String addAppointment(@RequestParam("appointmentId") Appointment appointment,
                                 Principal principal) {
        User user = userService.getUserByPrincipal(principal);
        appointmentsService.addUser(appointment, user);
        return "redirect:/appointment";
    }
}
