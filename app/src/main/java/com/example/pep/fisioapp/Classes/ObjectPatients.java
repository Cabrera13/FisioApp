package com.example.pep.fisioapp.Classes;

/**
 * Created by Pep on 06/03/2018.
 */

public class ObjectPatients {
    String nom;
    String dni;
    public ObjectPatients(String dni, String nom) {
        this.nom = nom;
        this.dni = dni;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }
}
