package com.company;

class Gebruiker implements VoedingsschemaObserver {
    private String gebruikersnaam;
    private String wachtwoord;

    public Gebruiker(String gebruikersnaam, String wachtwoord) {
        this.gebruikersnaam = gebruikersnaam;
        this.wachtwoord = wachtwoord;
    }

    public boolean login(String gebruikersnaam, String wachtwoord) {
        return this.gebruikersnaam.equals(gebruikersnaam) && this.wachtwoord.equals(wachtwoord);
    }

    @Override
    public void notifyNonVeganVoedingToegevoegd(Klant klant, Voedsel voedsel) {
        if (klant.isVegan() && !voedsel.isVegan()) {
            System.out.println("Waarschuwing: Non-vegan voeding toegevoegd aan een vegan klant!");
            System.out.println("Klant: " + klant.getNaam());
            System.out.println("Voedsel: " + voedsel.getNaam());
        }
    }


}
