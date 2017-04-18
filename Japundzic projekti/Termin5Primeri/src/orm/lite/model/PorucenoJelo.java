package orm.lite.model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "poruceno_jelo")
public class PorucenoJelo {

    public static final String POLJE_KOLICINA="kolicina";


    @DatabaseField(generatedId = true)
    private int id;

    @DatabaseField(columnName = POLJE_KOLICINA,canBeNull = false)
    private int kolicina;
    @DatabaseField(foreign = true,foreignAutoRefresh = true,canBeNull = false)
    private Jelo jelo;


    public PorucenoJelo() {
        //konstruktor bez parametara obavezan za ORMLite
    }

    public PorucenoJelo(int kolicina, Jelo jelo) {
        this.kolicina = kolicina;
        this.jelo = jelo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Jelo getJelo() {
        return jelo;
    }

    public void setJelo(Jelo jelo) {
        this.jelo = jelo;
    }

    public int getKolicina() {
        return kolicina;
    }

    public void setKolicina(int kolicina) {
        this.kolicina = kolicina;
    }

    @Override
    public String toString() {
        return "PorucenoJelo{" +
                "id=" + id +
                ", kolicina=" + kolicina +
                '}';
    }
}
