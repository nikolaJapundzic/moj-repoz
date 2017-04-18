package auto.trka;

/**
 * Created by androiddevelopment on 8.4.17..
 */
public class AvionNit extends  Thread {
    String sifraAviona;

    public AvionNit (String sifraAviona){
        this.sifraAviona = sifraAviona;
    }

    @Override
    public void run(){
        System.out.println("Avion " + sifraAviona + " je poleteo.");

        try {
            this.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Avion " + sifraAviona + " trazi dozvolu za sletanje.");

        try {
            this.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Avion " + sifraAviona + " je sleteo.");


    }//zamp sql
}
