package com.company;

import java.util.List;

class VeganVoedingsschemaGenerator extends VoedingsschemaGenerator {
    protected void voegVoedselToeAanSchema(Klant klant) {
        Voedingsschema voedingsschema = klant.getVoedingsschema();
        voedingsschema.addVoedsel(klant, new Notenmix());
        voedingsschema.addVoedsel(klant, new VeganMaaltijd());
    }

    protected void printVoedingsschema(Klant klant) {
        System.out.println("Veganistisch voedingsschema voor " + klant.getNaam() + ":");
        List<Voedsel> voedingsschema = klant.getVoedingsschema().getVoedingsschema();
        for (Voedsel voedsel : voedingsschema) {
            System.out.println(voedsel.getNaam());
        }
    }
}
