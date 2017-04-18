package primer.volatile_polje;


/**
 * Created by lazar on 17.9.16..
 */
public class AvionNitVolatile extends Thread {

    private int sifraAviona;

    public AvionNitVolatile(int sifraAviona){
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
                if (AerodromVolatile.dozvoljenoSletanje){
                    AerodromVolatile.dozvoljenoSletanje = false;

                    // Treba mu jedna sekunda da sleti
                    System.out.println("Avion " + sifraAviona + " slece.");
                    this.sleep(1000);

                    AerodromVolatile.dozvoljenoSletanje = true;
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        } while(!AerodromVolatile.dozvoljenoSletanje);


        System.out.println("Avion " + sifraAviona + " je sleteo.");
    }

    public void run() {
        poleti();
        sleti();
    }
}
