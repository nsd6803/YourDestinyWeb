package com.example.yourdestinyweb.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "weaponstats")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class WeaponStats {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "weapon_id", nullable = false)
    @JsonIgnore
    private Weapon weapon;

    // Add your weapon stats fields here
    // For example:
    @Column(name = "impact")
    private int impact;

    @Column(name = "range_")
    private int range;

    @Column(name = "stability")
    private int stability;

    @Column(name = "handling")
    private int handling;

    @Column(name = "reloadspeed")
    private int reload_speed;

    @Column(name = "aimassist")
    private int aim_assist;

    @Column(name = "airborne")
    private int airborne;

    @Column(name = "rpm")
    private int rpm;

    @Column(name = "mag")
    private int mag;

}
