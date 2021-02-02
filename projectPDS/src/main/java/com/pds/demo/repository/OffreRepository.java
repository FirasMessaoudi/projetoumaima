package com.pds.demo.repository;


import com.pds.demo.domains.OffreStage;
import com.pds.demo.domains.Organisme;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface OffreRepository   extends JpaRepository<OffreStage, Integer>, JpaSpecificationExecutor<OffreStage>{

    List<OffreStage>  findAllByOrganismeId (Integer id);

}
