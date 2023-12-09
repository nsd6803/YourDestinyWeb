package com.example.yourdestinyweb.repositories;

import com.example.yourdestinyweb.models.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {
    List<Doctor> findAllBySpecialization(String specialization);
}
