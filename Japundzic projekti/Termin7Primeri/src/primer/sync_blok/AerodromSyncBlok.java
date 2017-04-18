package primer.sync_blok;

/**
 * Created by lazar on 17.9.16..
 */
public class AerodromSyncBlok {
    public static Boolean dozvoljenoSletanje = true;

    public static volatile boolean volatileDozvoljenoSletanje = true;

    public static void main(String[] args){
        AvionNitSyncBlok a1 = new AvionNitSyncBlok(1);
        AvionNitSyncBlok a2 = new AvionNitSyncBlok(2);
        AvionNitSyncBlok a3 = new AvionNitSyncBlok(3);
        AvionNitSyncBlok a4 = new AvionNitSyncBlok(4);

        a1.start();
        a2.start();
        a3.start();
        a4.start();
    }

}
