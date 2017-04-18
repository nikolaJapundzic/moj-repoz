package termin7paket1;

/**
 * Created by androiddevelopment on 11.4.17..
 */
public class Viljuskari extends Thread{
    public static Integer trenutnoMasa = 0;

    public static void main(String[] args) {

        ViljuskarNit NS111 = new ViljuskarNit("NS111");
        ViljuskarNit NS222 = new ViljuskarNit("NS222");
        ViljuskarNit NS333 = new ViljuskarNit("NS333");

        NS111.start();
        NS222.start();
        NS333.start();




    }


}
