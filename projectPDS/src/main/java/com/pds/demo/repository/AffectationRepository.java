package com.pds.demo.repository;


import com.pds.demo.domains.Affectation;
import com.pds.demo.domains.RapportJuryId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AffectationRepository  extends JpaRepository<Affectation, RapportJuryId> {
}
