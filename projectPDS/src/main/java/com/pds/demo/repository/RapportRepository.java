package com.pds.demo.repository;


import com.pds.demo.domains.OffreStage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.pds.demo.domains.Rapport;

import java.util.List;

@Repository
public interface RapportRepository extends JpaRepository<Rapport,Integer> {


}
