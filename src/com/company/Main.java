package com.company;

public class Main {
    public static void main(String[] args) {
        Sportschool sportschool = new Sportschool();

        // Maak klanten aan
        Klant klant1 = new Klant(1, "John Doe", 30, 60, true);
        Klant klant2 = new Klant(2, "Jane Smith", 25, 70, false);
        Klant klant3 = new Klant(3, "Mike Johnson", 35, 80, false);
        Klant klant4 = new Klant(4, "Sarah Davis", 28, 90, false);
        Klant klant5 = new Klant(5, "David Wilson", 32, 240, false);

        // Voeg klanten toe aan de sportschool
        sportschool.voegKlantToe(klant1);
        sportschool.voegKlantToe(klant2);
        sportschool.voegKlantToe(klant3);
        sportschool.voegKlantToe(klant4);
        sportschool.voegKlantToe(klant5);

        Menu menu = new Menu(sportschool);
        menu.start();
    }
}