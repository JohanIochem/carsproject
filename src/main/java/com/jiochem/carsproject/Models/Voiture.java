package com.jiochem.carsproject.Models;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "voiture")
public class Voiture {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    @NotNull(message = "Veuillez choisir la marque")
    private String marque;


    public Voiture(int id, String marque, String modele) {
        this.id = id;
        this.marque = marque;
        this.modele = modele;
    }

    @Column(nullable = false)
    @NotNull(message = "Veuillez choisir le modèle")
    private String modele;

    public Voiture() {

    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public String getModele() {
        return modele;
    }

    public void setModele(String modele) {
        this.modele = modele;
    }

}
