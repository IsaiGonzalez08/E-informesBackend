package com.example.EinformesBack.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "questionnaries")
@Getter @Setter
public class Questionnarie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_Questionnarie;

    private String name_Questionnarie;
}
