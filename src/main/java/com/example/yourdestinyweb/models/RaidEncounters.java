package com.example.yourdestinyweb.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "raidenc")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RaidEncounters {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "idraid", nullable = false)
    @JsonIgnore
    private Raid raid;

    @Column(name = "encounternumber")
    private int encounterNumber;

    @Column(name = "encountername")
    private String encounterName;

    @Column(name = "encounterdesc")
    private String encounterDesc;
}

