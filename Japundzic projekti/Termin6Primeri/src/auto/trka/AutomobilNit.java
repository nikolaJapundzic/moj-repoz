package auto.trka;

import java.util.Random;

/**
 * Created by lazar on 11.9.16..
 */
public class AutomobilNit extends Thread {

    private String ime;

    public AutomobilNit(String ime){
        this.ime = ime;
    }

    private void pitStop(){
        System.out.println("Automobil " + ime + " ulazi u pit stop!");
        try {
            this.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Automobil " + ime + " izlazi iz pit stopa!");
    }

    private void vozi(){
        try {
            Random random = new Random();
            // random.nextDouble() vraca nasumicnu vrednost izmedju 0 i 1
            // Pomozimo sa 2000 da dobijemo period od 0 do 2 sekunde
            long vreme = Math.round(random.nextDouble() * 2000);
            this.sleep(vreme);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        System.out.println("Automobil " + ime + " je krenuo!");

        vozi();
        pitStop();
        vozi();

        System.out.println("Automobil " + ime + " je zavrsio trku!");
    }
}
