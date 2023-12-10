package com.example.yourdestinyweb.repositories;

import com.example.yourdestinyweb.models.Triumph;
import com.example.yourdestinyweb.models.Weapon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface WeaponRepository extends JpaRepository<Weapon, Long> {
    @Query("SELECT d FROM Weapon d LEFT JOIN FETCH d.weaponStats de")
    List<Weapon> findAllWeapon();
}