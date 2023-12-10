package com.example.yourdestinyweb.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "weapon")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Weapon {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long Id;

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


    @Column(name = "stats")
    private int[] stats;


    @Column(name = "isexotic")
    private Boolean is_exotic;

    @Column(name = "exoticicon")
    @Lob
    private String exotic_icon;

    @Column(name = "perkname")
    private String perk_name;

    @Column(name = "perkdesc")
    private String perk_desc;


    @Column(name = "lore")
    private String lore;
}
