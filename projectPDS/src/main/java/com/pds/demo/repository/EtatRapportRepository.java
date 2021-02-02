package com.pds.demo.repository;

import com.pds.demo.domains.EtatRapport;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface EtatRapportRepository  extends JpaRepository<EtatRapport,Integer> {
}
