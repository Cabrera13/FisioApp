package com.example.pep.fisioapp.Classes;

import java.util.ArrayList;

/**
 * Created by Pep on 06/03/2018.
 */

public class ObjectPatients {
    String nom;
    String dni;
    String cognoms;
    Integer edat;
    String sexe;
    String poblacio;
    ArrayList<ObjectForms> forms;

    public ObjectPatients(String dni, String nom, String cognoms, Integer edat, String sexe, String poblacio, ArrayList forms) {
        this.nom = nom;
        this.dni = dni;
        this.cognoms = cognoms;
        this.edat = edat;
        this.sexe = sexe;
        this.poblacio = poblacio;
        this.forms = forms;
    }

    public ArrayList getForms() {
        return forms;
    }

    public void setForms(ObjectForms p) {
        this.forms.add(p);
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getCognoms() {
        return cognoms;
    }

    public void setCognoms(String cognoms) {
        this.cognoms = cognoms;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }
}
