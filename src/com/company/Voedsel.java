package com.company;

abstract class Voedsel {
    private String naam;
    private boolean isVegan;

    public Voedsel(String naam, boolean isVegan) {
        this.naam = naam;
        this.isVegan = isVegan;
    }



    public String getNaam() {
        return naam;
    }
    public boolean isVegan() {
        return isVegan;
    }
}


class Kwark extends Voedsel {
    public Kwark() {
        super("Kwark 500gr", false);
    }
}

class Notenmix extends Voedsel {
    public Notenmix() {
        super("Notenmix 250g", true);
    }
}

class Kip extends Voedsel {
    public Kip() {
        super("Kip 250gr", false);
    }
}

class Steak extends Voedsel {
    public Steak() {
        super("Steak 250gr", false);
    }
}

class Eiwitshake extends Voedsel {
    public Eiwitshake() {
        super("Eiwitshake 30gr eiwit", false);
    }
}

class Eieren extends Voedsel {
    public Eieren() {
        super("Eieren 5 maal", false);
    }
}

class RijstMetKip extends Voedsel {
    public RijstMetKip() {
        super("Rijst met kip", false);
    }
}
    class VeganMaaltijd extends Voedsel {
        public VeganMaaltijd() {
            super("Een 2000kcal maaltijd van vegan ingredienten", true);
        }
}

