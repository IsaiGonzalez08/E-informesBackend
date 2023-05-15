package com.example.EinformesBack.entities.pivots;


import com.example.EinformesBack.entities.Document;
import com.example.EinformesBack.entities.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "users_documents")
@Getter @Setter
public class UserDocument {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private User user;

    @ManyToOne
    private Document document;
}
