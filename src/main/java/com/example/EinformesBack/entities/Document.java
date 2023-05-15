package com.example.EinformesBack.entities;

import com.example.EinformesBack.entities.pivots.UserDocument;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "documents")
@Getter @Setter
public class Document {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_Document;
    private String name_Document;

    @OneToMany(mappedBy = "document")
    private List<UserDocument> userDocuments;

}
