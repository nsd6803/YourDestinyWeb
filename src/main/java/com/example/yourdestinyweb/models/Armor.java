package com.example.yourdestinyweb.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "armor")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Armor {
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

    @Column(name = "predicat")
    private String predicat;

    @Column(name = "exoticicon")
    @Lob
    private String exotic_icon;

    @Column(name = "perkname")
    private String perk_name;

    @Column(name = "perkdesc")
    private String perk_desc;

    @Column(name = "forclass")
    private String for_class;

    @Column(name = "lore")
    private String lore;
}
