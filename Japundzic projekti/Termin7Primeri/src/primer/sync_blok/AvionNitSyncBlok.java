package primer.sync_blok;

/**
 * Created by lazar on 17.9.16..
 */
public class AvionNitSyncBlok extends Thread {

    private int sifraAviona;

    public AvionNitSyncBlok(int sifraAviona){
        this.sifraAviona = sifraAviona;
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
                if (AerodromSyncBlok.dozvoljenoSletanje){
                    // Citamo u synchronized bloku
                    synchronized (AerodromSyncBlok.dozvoljenoSletanje){
                        AerodromSyncBlok.dozvoljenoSletanje = false;
                    }

                    // Treba mu jedna sekunda da sleti
                    System.out.println("Avion " + sifraAviona + " slece.");
                    this.sleep(1000);

                    // Pisemo u synchronized bloku
                    synchronized (AerodromSyncBlok.dozvoljenoSletanje) {
                        AerodromSyncBlok.dozvoljenoSletanje = true;
                    }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        } while(!AerodromSyncBlok.dozvoljenoSletanje);


        System.out.println("Avion " + sifraAviona + " je sleteo.");
    }

    public void run() {
        poleti();
        sleti();
    }
}
