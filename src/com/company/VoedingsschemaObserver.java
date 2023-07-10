package com.company;

interface VoedingsschemaObserver {
    void notifyNonVeganVoedingToegevoegd(Klant klant, Voedsel voedsel);
}
