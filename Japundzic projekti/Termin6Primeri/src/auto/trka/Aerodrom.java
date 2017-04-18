package auto.trka;

/**
 * Created by androiddevelopment on 8.4.17..
 */
public class Aerodrom {
    public static void main(String[] args) {
        AvionNit a1 = new AvionNit("airBus");
        AvionNit a2 = new AvionNit("cesna");
        AvionNit a3 = new AvionNit("utva");

        a1.start();
        a2.start();
        a3.start();

    }
}
