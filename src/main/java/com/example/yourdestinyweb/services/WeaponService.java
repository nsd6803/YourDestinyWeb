package com.example.yourdestinyweb.services;

import com.example.yourdestinyweb.models.Weapon;
import com.example.yourdestinyweb.repositories.WeaponRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WeaponService {

    private final WeaponRepository weaponRepository;

    public WeaponService(WeaponRepository weaponRepository) {
        this.weaponRepository = weaponRepository;
    }

    public List<Weapon> allWeapon() {
        List<Weapon> weapons = weaponRepository.findAllWeapon();
        return weaponRepository.findAllWeapon();
    }
}
