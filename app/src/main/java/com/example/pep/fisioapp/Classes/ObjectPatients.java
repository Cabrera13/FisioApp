package com.example.pep.fisioapp.Classes;

import java.io.NotSerializableException;
import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Pep on 06/03/2018.
 */

public class ObjectPatients implements Serializable {
    String nom;
    String dni;
    String cognoms;
    Integer edat;
    String sexe;
    String poblacio;
    ArrayList<ObjectForms> forms;
    public ObjectPatients(){}
    public ObjectPatients(String dni, String nom, String cognoms, Integer edat, String sexe, String poblacio, ArrayList forms) {
        this.nom = nom;
        this.dni = dni;
        this.cognoms = cognoms;
        this.edat = edat;
        this.sexe = sexe;
        this.poblacio = poblacio;
        this.forms = forms;
    }


    public void setFormsk(ObjectForms p) {
        this.forms.add(p);
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

    public String getCognoms() {
        return cognoms;
    }

    public void setCognoms(String cognoms) {
        this.cognoms = cognoms;
    }

    public Integer getEdat() {
        return edat;
    }

    public void setEdat(Integer edat) {
        this.edat = edat;
    }

    public String getSexe() {
        return sexe;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public String getPoblacio() {
        return poblacio;
    }

    public void setPoblacio(String poblacio) {
        this.poblacio = poblacio;
    }

    public ArrayList<ObjectForms> getForms() {
        return forms;
    }

    public void setForms(ArrayList<ObjectForms> forms) {
        this.forms = forms;
    }

    @Override
    public String toString() {
        String x = "";
        for (int i = 0; i < getForms().size(); i++) {
            x = getForms().get(i).toString();
        }
        return  this.dni.toString() + "/"+ this.nom.toString() +"/"+ this.poblacio.toString()+"/" + x;
    }


}
