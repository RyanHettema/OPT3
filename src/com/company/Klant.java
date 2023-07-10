package com.company;

class Klant {
    private int klantId;
    private String naam;
    private int leeftijd;
    private int gewicht;
    private Voedingsschema voedingsschema;

    private boolean vegan;

    public Klant(int klantId, String naam, int leeftijd, int gewicht, boolean vegan) {
        this.klantId = klantId;
        this.naam = naam;
        this.leeftijd = leeftijd;
        this.gewicht = gewicht;
        this.vegan = vegan;
        this.voedingsschema = new Voedingsschema();
    }

    public int getKlantId() {
        return klantId;
    }

    public String getNaam() {
        return naam;
    }

    public int getLeeftijd() {
        return leeftijd;
    }

    public Voedingsschema getVoedingsschema() {
        return voedingsschema;
    }

    public boolean isVegan() {
        return vegan;
    }
}
