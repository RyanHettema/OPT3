package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Menu {
    private Sportschool sportschool;
    private Scanner scanner;
    private List<Voedsel> beschikbareVoedingsmiddelen;

    public Menu(Sportschool sportschool) {
        this.sportschool = sportschool;
        this.scanner = new Scanner(System.in);

        // Maak lijst van beschikbare voedingsmiddelen
        beschikbareVoedingsmiddelen = new ArrayList<>();
        beschikbareVoedingsmiddelen.add(new Kwark());
        beschikbareVoedingsmiddelen.add(new Notenmix());
        beschikbareVoedingsmiddelen.add(new Kip());
        beschikbareVoedingsmiddelen.add(new Steak());
        beschikbareVoedingsmiddelen.add(new Eiwitshake());
        beschikbareVoedingsmiddelen.add(new Eieren());
        beschikbareVoedingsmiddelen.add(new RijstMetKip());
    }

    public void printKlanten() {
        System.out.println("Klanten:");
        for (Klant klant : sportschool.getKlanten()) {
            System.out.println(klant.getKlantId() + ": " + klant.getNaam());
        }
    }

    public void bekijkKlantData(int klantId) {
        Klant klant = sportschool.zoekKlant(klantId);
        if (klant != null) {
            System.out.println("Klantgegevens:");
            System.out.println("Naam: " + klant.getNaam());
            System.out.println("Leeftijd: " + klant.getLeeftijd());
            // Voeg andere klantgegevens toe
        } else {
            System.out.println("Klant niet gevonden.");
        }
    }

    public void genereerVoedingsschema(Klant klant) {
        Voedingsschema voedingsschema = klant.getVoedingsschema();
        if (voedingsschema != null) {
            VoedingsschemaGenerator generator;
            if (klant.isVegan()) {
                generator = new VeganVoedingsschemaGenerator();
            } else {
                generator = new StandaardVoedingsschemaGenerator();
            }
            generator.genereerVoedingsschema(klant);
        } else {
            System.out.println("Voedingsschema is niet beschikbaar voor deze klant.");
        }
    }


    public void bekijkVoedingsschema(int klantId) {
        Klant klant = sportschool.zoekKlant(klantId);
        if (klant != null) {
            System.out.println("Voedingsschema van " + klant.getNaam() + ":");
            Voedingsschema voedingsschema = klant.getVoedingsschema();
            if (voedingsschema != null) {
                List<Voedsel> voedingsschemaList = voedingsschema.getVoedingsschema();
                if (voedingsschemaList.isEmpty()) {
                    System.out.println("Het voedingsschema is leeg.");
                } else {
                    for (Voedsel voedsel : voedingsschemaList) {
                        System.out.println(voedsel.getNaam());
                    }
                }
            } else {
                System.out.println("Voedingsschema is niet beschikbaar voor deze klant.");
            }
        } else {
            System.out.println("Klant niet gevonden.");
        }
    }

    public void voegVoedselToeAanSchema(Klant klant) {
        Voedingsschema voedingsschema = klant.getVoedingsschema();
        if (voedingsschema != null) {
            System.out.println("Beschikbare voedingsmiddelen:");
            for (int i = 0; i < beschikbareVoedingsmiddelen.size(); i++) {
                System.out.println((i + 1) + ". " + beschikbareVoedingsmiddelen.get(i).getNaam());
            }

            System.out.print("Kies een voedingsmiddel (geef nummer): ");
            int keuze = Integer.parseInt(scanner.nextLine());

            if (keuze >= 1 && keuze <= beschikbareVoedingsmiddelen.size()) {
                Voedsel voedsel = beschikbareVoedingsmiddelen.get(keuze - 1);
                voedingsschema.addVoedsel(klant, voedsel);
                System.out.println("Voedsel '" + voedsel.getNaam() + "' is toegevoegd aan het voedingsschema van " + klant.getNaam() + ".");
            } else {
                System.out.println("Ongeldige keuze. Probeer opnieuw.");
            }
        } else {
            System.out.println("Voedingsschema is niet beschikbaar voor deze klant.");
        }
    }

    public void resetVoedingsschema(Klant klant) {
        Voedingsschema voedingsschema = klant.getVoedingsschema();
        if (voedingsschema != null) {
            voedingsschema.clear();
            System.out.println("Voedingsschema van " + klant.getNaam() + " is gereset.");
        } else {
            System.out.println("Voedingsschema is niet beschikbaar voor deze klant.");
        }
    }

    public void start() {
        System.out.println("Welkom bij het voedingsschema-systeem!");

        // Creëer gebruiker
        Gebruiker gebruiker = new Gebruiker("cool", "cool");

        // Inloggen
        boolean ingelogd = false;
        do {
            System.out.print("Gebruikersnaam: ");
            String gebruikersnaam = scanner.nextLine();
            System.out.print("Wachtwoord: ");
            String wachtwoord = scanner.nextLine();

            if (gebruiker.login(gebruikersnaam, wachtwoord)) {
                ingelogd = true;
            } else {
                System.out.println("Ongeldige gebruikersnaam of wachtwoord. Probeer opnieuw.");
            }
        } while (!ingelogd);

        // Hoofdmenu
        boolean doorgaan = true;
        while (doorgaan) {
            System.out.println("\nMaak een keuze:");
            System.out.println("1. Gegevens van klanten inzien en voedingsschema bekijken");
            System.out.println("2. Voedsel toevoegen aan een klant zijn voedingsschema");
            System.out.println("3. Voedingsschema generator");
            System.out.println("0. Afsluiten");

            int keuze = Integer.parseInt(scanner.nextLine());

            switch (keuze) {
                case 1:
                    printKlanten();
                    System.out.print("Kies een klant (geef klantId): ");
                    int klantId = Integer.parseInt(scanner.nextLine());
                    bekijkKlantData(klantId);
                    bekijkVoedingsschema(klantId);
                    break;
                case 2:
                    printKlanten();
                    System.out.print("Kies een klant (geef klantId)");
                    int klantId2 = Integer.parseInt(scanner.nextLine());
                    Klant klant2 = sportschool.zoekKlant(klantId2);
                    if (klant2 != null) {
                        voegVoedselToeAanSchema(klant2);
                    } else {
                        System.out.println("Klant niet gevonden.");
                    }
                    break;
                case 3:
                    printKlanten();
                    System.out.print("Kies een klant (geef klantId): ");
                    int klantId3 = Integer.parseInt(scanner.nextLine());
                    Klant klant3 = sportschool.zoekKlant(klantId3);
                    if (klant3 != null) {
                        resetVoedingsschema(klant3);
                        klant3.getVoedingsschema().addObserver(gebruiker);
                        genereerVoedingsschema(klant3);
                    } else {
                        System.out.println("Klant niet gevonden.");
                    }
                    break;
                case 0:
                    doorgaan = false;
                    break;
                default:
                    System.out.println("Ongeldige keuze. Probeer opnieuw.");
            }
        }

        System.out.println("Bedankt voor het gebruik van het voedingsschema-systeem!");
    }
}