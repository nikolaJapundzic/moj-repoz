package auto.trka;

/**
 * Created by lazar on 11.9.16..
 */
public class AutoTrka {

    public static void main(String [] args){
        AutomobilNit mitsubishi = new AutomobilNit("Mitsubishi");
        AutomobilNit ferari = new AutomobilNit("Ferarri");
        AutomobilNit jugo = new AutomobilNit("Jugic");

        mitsubishi.start();
        ferari.start();
        jugo.start();

        //TODO: Ovde napisati kod koji ceka sve automobile da zavrse i pokrece novi krug trke


        try {
            mitsubishi.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            ferari.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            jugo.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }



        //Drugi krug

        System.out.println("Automobili su krenuli u drugi krug trke!");

        mitsubishi = new AutomobilNit("Mitsubishi");
        ferari = new AutomobilNit("Ferarri");
        jugo = new AutomobilNit("Jugic");

        mitsubishi.start();
        ferari.start();
        jugo.start();


        System.out.println("Svi su zavrsili.");


    }
}
