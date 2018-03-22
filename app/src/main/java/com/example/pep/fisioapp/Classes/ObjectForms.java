package com.example.pep.fisioapp.Classes;

import java.io.Serializable;

/**
 * Created by Pep on 19/03/2018.
 */

public class ObjectForms implements Serializable {
    String alergies;
    String farmacs;
    String habits;
    String patologies;
    String antecedents;

    public ObjectForms () {}

    public ObjectForms(String alergies, String farmacs, String habits, String patologies, String antecedents) {
        this.alergies = alergies;
        this.farmacs = farmacs;
        this.habits = habits;
        this.patologies = patologies;
        this.antecedents = antecedents;

    }

    public String getAlergies() {
        return alergies;
    }

    public String getFarmacs() {
        return farmacs;
    }

    public void setFarmacs(String farmacs) {
        this.farmacs = farmacs;
    }

    public String getHabits() {
        return habits;
    }

    public void setHabits(String habits) {
        this.habits = habits;
    }

    public String getPatologies() {
        return patologies;
    }

    public void setPatologies(String patologies) {
        this.patologies = patologies;
    }

    public String getAntecedents() {
        return antecedents;
    }

    public void setAntecedents(String antecedents) {
        this.antecedents = antecedents;
    }

    public void setAlergies(String alergies) {
        this.alergies = alergies;
    }

    @Override
    public String toString() {
        return  this.alergies.toString() + this.farmacs.toString() ;
    }
}
