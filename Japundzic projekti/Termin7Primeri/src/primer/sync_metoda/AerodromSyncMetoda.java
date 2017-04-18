package primer.sync_metoda;

/**
 * Created by lazar on 17.9.16..
 */
public class AerodromSyncMetoda {

    private boolean dozvolaZaSletanje = true;

    public static void main(String[] args){
        AerodromSyncMetoda aerodrom = new AerodromSyncMetoda();
        AvionNitSyncMetoda a1 = new AvionNitSyncMetoda(1, aerodrom);
        AvionNitSyncMetoda a2 = new AvionNitSyncMetoda(2, aerodrom);
        AvionNitSyncMetoda a3 = new AvionNitSyncMetoda(3, aerodrom);
        AvionNitSyncMetoda a4 = new AvionNitSyncMetoda(4, aerodrom);

        a1.start();
        a2.start();
        a3.start();
        a4.start();
    }

    public synchronized boolean isDozvolaZaSletanje() {
        return dozvolaZaSletanje;
    }

    public synchronized void setDozvolaZaSletanje(boolean dozvolaZaSletanje) {
        this.dozvolaZaSletanje = dozvolaZaSletanje;
    }
}
