package com.pds.demo.domains;


import lombok.Data;
import net.minidev.json.annotate.JsonIgnore;

import javax.persistence.*;

import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "Rapport")
public class Rapport {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String codeRapport;
    private Date dateRapport;
    private String specialite;
    private String tag;
    private String  document;
    private String titre;
    private TypeRapport typeRapport;


    @ManyToOne
    private EtatRapport etat;


    @ManyToMany(mappedBy="rapports")
    @JsonIgnore
    private List<Utilisateur> utilisateurs;
    @OneToMany(mappedBy="rapport")
    private List<Affectation> affectations;




















}
