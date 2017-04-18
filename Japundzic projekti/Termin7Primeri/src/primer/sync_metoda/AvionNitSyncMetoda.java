package primer.sync_metoda;

import primer.sync_blok.AerodromSyncBlok;

/**
 * Created by lazar on 17.9.16..
 */
public class AvionNitSyncMetoda extends Thread {

    private AerodromSyncMetoda aerodrom;
    private int sifraAviona;

    public AvionNitSyncMetoda(int sifraAviona, AerodromSyncMetoda aerodrom){
        this.sifraAviona = sifraAviona;
        this.aerodrom = aerodrom;
    }

    private void poleti(){
        System.out.println("Avion " + sifraAviona + " je poleteo.");

        try {
            this.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

     private void sleti(){
        System.out.println("Avion " + sifraAviona + " trazi dozvolu za sletanje.");
        do{
            try {
                // Svake sekudne proveravaj dozvolu za sletanje
                this.sleep(1000);
                if (aerodrom.isDozvolaZaSletanje()){
                    // Citamo u synchronized bloku
                    aerodrom.setDozvolaZaSletanje(false);

                    // Treba mu jedna sekunda da sleti
                    System.out.println("Avion " + sifraAviona + " slece.");
                    this.sleep(1000);

                    // Pisemo u synchronized bloku
                    aerodrom.setDozvolaZaSletanje(true);

                    System.out.println("Avion " + sifraAviona + " je sleteo.");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        } while(!aerodrom.isDozvolaZaSletanje());
    }


    public void run() {
        poleti();
        sleti();
    }
}
