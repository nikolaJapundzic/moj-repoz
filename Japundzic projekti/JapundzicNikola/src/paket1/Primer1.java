package paket1;

/**
 * Created by androiddevelopment on 28.3.17..
 */
public class Primer1 {
    enum semafor {CRVENO, ZUTO_CRVENO, ZELENO, ZUTO_ZELENO};
    public static void main(String[] args) {

        switch(semafor)
        {
            case semafor.CRVENO;
                System.out.println("Signal je : [" +semafor.CRVENO+ "]");
                break;
        }
    }
}
