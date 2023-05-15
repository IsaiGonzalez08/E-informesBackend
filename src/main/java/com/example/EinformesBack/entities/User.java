package com.example.EinformesBack.entities;

import com.example.EinformesBack.entities.pivots.UserDocument;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "users")
@Getter @Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_User;
    private String username;
    private String password;
    private String email;

    @OneToMany(mappedBy = "user")
    private List<UserDocument> userDocuments;

}
