package auto.trka;

import java.util.Random;

/**
 * Created by androiddevelopment on 8.4.17..
 */
public class KontejnerNit implements Runnable {
    int brojKontejnera;
    public KontejnerNit (int brojKontejnera){
        this.brojKontejnera = brojKontejnera;
    }
    @Override
    public void run() {

        double rand;
        int randI;

        do{
            rand = Math.random() * 5000;
            randI = (int)rand;
        }while(randI<1000);

        System.out.println("Pocinje utovar kontejnera sa brojem " + brojKontejnera);

        try {
            Thread.sleep(randI); // uspavljuje tred koji pokrece taj ranabl
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Utovar kontejnera sa brojem " + brojKontejnera + " je završen.");


    }
}
