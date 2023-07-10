package com.company;
import java.util.ArrayList;
import java.util.List;

class Voedingsschema {
    private List<VoedingsschemaObserver> observers;
    private List<Voedsel> voedingsschema;

    public Voedingsschema() {
        observers = new ArrayList<>();
        voedingsschema = new ArrayList<>();
    }

    public void addObserver(VoedingsschemaObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(VoedingsschemaObserver observer) {
        observers.remove(observer);
    }

    public void addVoedsel(Klant klant, Voedsel voedsel) {
        voedingsschema.add(voedsel);
        notifyObservers(klant, voedsel);
    }

    private void notifyObservers(Klant klant, Voedsel voedsel) {
        for (VoedingsschemaObserver observer : observers) {
            if (!voedsel.isVegan() && klant.isVegan()) {
                observer.notifyNonVeganVoedingToegevoegd(klant, voedsel);
            }
        }
    }


    public List<Voedsel> getVoedingsschema() {
        return voedingsschema;
    }

    public void clear() {
        voedingsschema.clear();
    }
}
