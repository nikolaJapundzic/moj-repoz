package primer3;

public class Automobil {
    int maksimalnaBrzina;
    boolean radi;

    public Automobil(){
        radi=true;
    }

    public Automobil(int maksimalnaBrzina, boolean radi) {
        this.maksimalnaBrzina = maksimalnaBrzina;
        this.radi = radi;
    }
    //konstruktori predstavljaju metode klasa

    public Automobil(Automobil a) { //kopi konstruktor, nova stvar :)
        this.maksimalnaBrzina = a.maksimalnaBrzina;
        this.radi = a.radi;
    }
}
