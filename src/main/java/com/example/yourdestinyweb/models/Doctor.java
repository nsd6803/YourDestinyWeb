package com.example.yourdestinyweb.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "doctors")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long Id;
    @Column(name = "name")
    private String name;
    @Column(name = "price")
    private int price;
    @Column(name = "specialization")
    private String specialization;
    @OneToMany(mappedBy = "doctor", cascade = CascadeType.ALL)
    List<Appointment> appointments;

    public void addAppointment(Appointment appointment) {
        appointments.add(appointment);
    }

}
