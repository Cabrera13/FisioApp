package com.example.pep.fisioapp.Classes;

/**
 * Created by Pep on 19/03/2018.
 */

public class ObjectForms {
    String alergies;
    String farmacs;
    String habits;
    String patologies;
    String antecedents;

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

    public void setAlergies(String alergies) {
        this.alergies = alergies;
    }
}
