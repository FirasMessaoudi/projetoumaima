package com.pds.demo.domains;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "organisme")
public class Organisme {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String email;
    private String codePostal;
    private String Gouvernerat;
    private String imageOrganisme;
    private String nom;
    private String nomResponsable;
    private String adresse;
    private String specialite;
    private typeOrganisme type;

    @JsonIgnore
    @OneToMany(mappedBy = "organisme")
    private List<OffreStage> offreStageList;

}
