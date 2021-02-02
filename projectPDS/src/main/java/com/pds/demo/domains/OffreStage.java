package com.pds.demo.domains;


import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "offre")
public class OffreStage {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String titreOffre;
    private String description;
    private String niveau;
    private String duree;
    private String languages;

    @ManyToOne
    private Organisme organisme;

}
