package primer2;

public class Automobil {

    int maksimalnaBrzina ;
    boolean radi ;

    public int getMaksimalnaBrzina ()
    {
        return maksimalnaBrzina ;
    }
    public void setMaksimalnaBrzina( int maksimalnaBrzina )
    {
        this.maksimalnaBrzina = maksimalnaBrzina ;
    }

    public boolean isRadi()
    {
        return radi;
    }

    public void setRadi(boolean radi)
    {
        this.radi = radi;
    }
    //ako parametar ima naziv isti kao i atribut onda se mora koristiti kljucna rec this
}
