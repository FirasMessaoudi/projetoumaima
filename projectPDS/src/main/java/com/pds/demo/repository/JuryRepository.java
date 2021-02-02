package com.pds.demo.repository;


import com.pds.demo.domains.Jury;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JuryRepository extends JpaRepository<Jury,Integer> {

}
