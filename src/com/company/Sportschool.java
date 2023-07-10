package com.company;

import java.util.ArrayList;
import java.util.List;

class Sportschool {
    private List<Klant> klanten;

    public Sportschool() {
        this.klanten = new ArrayList<>();
    }

    public void voegKlantToe(Klant klant) {
        klanten.add(klant);
    }

    public List<Klant> getKlanten() {
        return klanten;
    }

    public Klant zoekKlant(int klantId) {
        for (Klant klant : klanten) {
            if (klant.getKlantId() == klantId) {
                return klant;
            }
        }
        return null;
    }
}
