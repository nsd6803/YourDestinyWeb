package com.example.yourdestinyweb.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Entity
@Table(name = "triumphtasks")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TriumphTasks {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "fortriumph", nullable = false)
    @JsonIgnore
    private Triumph triumph;

    @Column(name = "triumphnumber")
    private int triumphNumber;

    @Column(name = "triumphname")
    private String triumphName;

    @Column(name = "triumphdesc")
    private String triumphDesc;

    @Column(name = "isdone")
    private Boolean isDone;
}