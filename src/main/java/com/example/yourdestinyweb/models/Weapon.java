package com.example.yourdestinyweb.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "weapon")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Weapon {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "icon")
    @Lob
    private String icon;

    @Column(name = "picture")
    @Lob
    private String picture;

    @Column(name = "type")
    private String type;

    @Column(name = "element")
    private String element;

    @Column(name = "predicat")
    private String predicat;

    @Column(name = "isexotic")
    private Boolean isExotic;

    @Column(name = "exoticicon")
    @Lob
    private String exoticIcon;

    @Column(name = "perkname")
    private String perkName;

    @Column(name = "perkdesc")
    private String perkDesc;

    @Column(name = "lore")
    private String lore;

    @OneToMany(mappedBy = "weapon", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<WeaponStats> weaponStats;
}