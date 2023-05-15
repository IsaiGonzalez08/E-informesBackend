package com.example.EinformesBack.repositories;

import com.example.EinformesBack.entities.pivots.UserDocument;
import com.example.EinformesBack.entities.projections.DocumentProjection;
import com.example.EinformesBack.entities.projections.UserProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IUserDocumentRepository extends JpaRepository<UserDocument, Long> {

}
