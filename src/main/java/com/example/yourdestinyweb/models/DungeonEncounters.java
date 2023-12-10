package com.example.yourdestinyweb.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "dungeonenc")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DungeonEncounters {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "iddungeon", nullable = false)
    @JsonIgnore
    private Dungeon dungeon;

    @Column(name = "encounternumber")
    private int encounter_number;

    @Column(name = "encountername")
    private String encounter_name;

    @Column(name = "encounterdesc")
    private String encounter_desc;
    @Override
    public String toString() {
        return "DungeonEncounters{" +
                "id=" + id +
                ", encounter_number=" + encounter_number +
                ", encounter_name='" + encounter_name + '\'' +
                ", encounter_desc='" + encounter_desc + '\'' +
                '}';
    }
}
