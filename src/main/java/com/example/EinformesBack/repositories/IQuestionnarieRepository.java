package com.example.EinformesBack.repositories;

import com.example.EinformesBack.entities.Questionnarie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IQuestionnarieRepository extends JpaRepository<Questionnarie, Long> {
}
