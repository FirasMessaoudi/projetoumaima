package com.pds.demo.domains;


import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "etatRapport")
public class EtatRapport {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;


    private String libelle;
}
