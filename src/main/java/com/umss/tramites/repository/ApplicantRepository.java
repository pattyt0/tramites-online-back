package com.umss.tramites.repository;

import com.umss.tramites.entity.Applicant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ApplicantRepository extends JpaRepository<Applicant, Integer> {
    Optional<Applicant> findByNombre(String nombre);
    boolean existsByNombre(String nombre);
}
