package termin7paket1;

/**
 * Created by androiddevelopment on 11.4.17..
 */
public class Zadatak1 {

    //kaze pomocna funkcija

    public static void syncPrint(String s){
        synchronized (System.out){
            System.out.println(s);
        }


    }
}
