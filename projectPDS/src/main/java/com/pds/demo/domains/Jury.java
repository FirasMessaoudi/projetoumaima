package com.pds.demo.domains;


import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "jury")
public class Jury {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String nom;
    private String prenom;
    private String email;
    private String specialite;
    private typeJury type;

    @OneToMany(mappedBy="jury")
    private List<Affectation> affectations;

}
