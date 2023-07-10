package com.company;

import java.util.List;

class StandaardVoedingsschemaGenerator extends VoedingsschemaGenerator {
    @Override
    protected void voegVoedselToeAanSchema(Klant klant) {
        Voedingsschema voedingsschema = klant.getVoedingsschema();
        voedingsschema.addVoedsel(klant, new Kwark());
        voedingsschema.addVoedsel(klant, new Kip());
        voedingsschema.addVoedsel(klant, new Eieren());
        voedingsschema.addVoedsel(klant, new Steak());
    }

    @Override
    protected void printVoedingsschema(Klant klant) {
        System.out.println("Voedingsschema voor " + klant.getNaam() + ":");
        List<Voedsel> voedingsschema = klant.getVoedingsschema().getVoedingsschema();
        for (Voedsel voedsel : voedingsschema) {
            System.out.println(voedsel.getNaam());
        }
    }
}
