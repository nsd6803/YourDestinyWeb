package com.example.yourdestinyweb.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "triumph")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Triumph {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "icon")
    @Lob
    private String icon;


    @ElementCollection
    @CollectionTable(name = "triumph_info", joinColumns = @JoinColumn(name = "triumph_id"))
    @Column(name = "triumphname")
    private List<String> triumph_names;

    @ElementCollection
    @CollectionTable(name = "triumph_info", joinColumns = @JoinColumn(name = "triumph_id"))
    @Column(name = "triumphdesc")
    private List<String> triumph_desc;

    @ElementCollection
    @CollectionTable(name = "triumph_info", joinColumns = @JoinColumn(name = "triumph_id"))
    @Column(name = "isdone")
    private List<Boolean> is_done;
}
