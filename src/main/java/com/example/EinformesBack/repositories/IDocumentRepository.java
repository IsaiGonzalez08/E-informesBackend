package com.example.EinformesBack.repositories;

import com.example.EinformesBack.entities.Document;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDocumentRepository extends JpaRepository<Document, Long> {
}
