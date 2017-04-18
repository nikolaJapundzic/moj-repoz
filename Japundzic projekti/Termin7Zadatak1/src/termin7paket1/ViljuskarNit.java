package termin7paket1;

/**
 * Created by androiddevelopment on 11.4.17..
 */
public class ViljuskarNit extends Thread {
    String registracija;

    ViljuskarNit(String registracija){
        this.registracija = registracija;
    }



    private void cekanje(){





        while(Viljuskari.trenutnoMasa<10000){
            try {


                synchronized (Viljuskari.trenutnoMasa){

                    synchronized (System.out){

                        System.out.println("Viljuskar " + registracija + " utovara.");

                    }

                    Viljuskari.trenutnoMasa += 500;

                }
                this.sleep(1000);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Viljuskari.trenutnoMasa);
        }


        System.out.println("Viljuskari su natovarili kamion sa 10 tona.");
    }

    public void run() {

        cekanje();
    }

    public static void syncPrint(String s){
        synchronized (System.out){
            System.out.println(s);
        }


    }

    //syncPrint(registracija);

}
