package com.company;
import java.util.List;

abstract class VoedingsschemaGenerator {
    public void genereerVoedingsschema(Klant klant) {
        voegVoedselToeAanSchema(klant);
        printVoedingsschema(klant);
    }

    protected abstract void voegVoedselToeAanSchema(Klant klant);

    protected abstract void printVoedingsschema(Klant klant);
}
