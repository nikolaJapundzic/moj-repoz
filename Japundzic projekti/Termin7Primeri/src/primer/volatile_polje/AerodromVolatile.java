package primer.volatile_polje;

/**
 * Created by lazar on 17.9.16..
 */
public class AerodromVolatile {
    public static volatile boolean dozvoljenoSletanje = true;

    public static void main(String[] args){
        AvionNitVolatile a1 = new AvionNitVolatile(1);
        AvionNitVolatile a2 = new AvionNitVolatile(2);
        AvionNitVolatile a3 = new AvionNitVolatile(3);
        AvionNitVolatile a4 = new AvionNitVolatile(4);

        a1.start();
        a2.start();
        a3.start();
        a4.start();
    }

}
