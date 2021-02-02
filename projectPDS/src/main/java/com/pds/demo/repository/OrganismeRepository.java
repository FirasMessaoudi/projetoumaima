package com.pds.demo.repository;

import com.pds.demo.domains.Jury;
import com.pds.demo.domains.OffreStage;
import com.pds.demo.domains.Organisme;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OrganismeRepository extends JpaRepository<Organisme,Integer> {

    @Override
    Optional<Organisme> findById(Integer id);


}
