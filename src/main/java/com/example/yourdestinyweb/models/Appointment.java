package com.example.yourdestinyweb.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
@Table(name = "appointments")
@Data
@AllArgsConstructor
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "doctor_id")
    private Doctor doctor;
    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "user_id")
    private User user;
    @Column(name = "available")
    private Boolean available;
    @Column(name = "time")
    private Date time;

    public Appointment(Doctor doctor, Date time) {
        this.doctor = doctor;
        this.available = true;
        this.time = time;
    }

    public Appointment() {
        this.available = true;
    }

    public String getDate() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        return formatter.format(this.time);
    }

    public void setUser(User user) {
        this.user = user;
        this.available = false;
    }

}
