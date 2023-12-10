package com.example.yourdestinyweb.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "dungeon")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Dungeon {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "icon")
    @Lob
    private String icon;

    @Column(name = "predicat")
    private String predicat;

    @Column(name = "diff")
    private int diff;

    @ElementCollection
    @CollectionTable(name = "encounter_table", joinColumns = @JoinColumn(name = "dungeon_id"))
    @Column(name = "encountername")
    private List<String> encounter_names;

    @ElementCollection
    @CollectionTable(name = "encounter_table", joinColumns = @JoinColumn(name = "dungeon_id"))
    @Column(name = "encounterdesc")
    private List<String> encounter_desc;
}
