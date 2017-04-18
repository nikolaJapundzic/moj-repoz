package orm.lite.model;

import com.j256.ormlite.dao.ForeignCollection;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;

import java.util.Date;

@DatabaseTable(tableName = "meni")
public class Meni {

    public static final String POLJE_DATUM="datum";
    public static final String POLJE_NAZIV="naziv";

    @DatabaseField(generatedId = true)
    private int id;
    @DatabaseField(columnName = POLJE_DATUM,canBeNull = false)
    private Date datum;
    @DatabaseField(columnName = POLJE_NAZIV,canBeNull = false)
    private String naziv;

    @ForeignCollectionField(foreignFieldName = "meni",eager=false,maxEagerLevel = 1)
    private ForeignCollection<Jelo> jela;
    //eger poziva ako je true sva jela uz pozivanje menija i njegovih top (iznad) oznaka

    //ako je eger level 1 ponda se samo jedno jell o ucitava, ako je 4 onda 4 bla bla
    public Meni() {
        //konstruktor bez parametara obavezan za ORMLite
    }

    public Meni(Date datum, String naziv) {
        this.datum = datum;
        this.naziv = naziv;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public ForeignCollection<Jelo> getJela() {
        return jela;
    }

    public void setJela(ForeignCollection<Jelo> jela) {
        this.jela = jela;
    }

    @Override
    public String toString() {
        return "Meni{" +
                "id=" + id +
                ", datum=" + datum +
                ", naziv='" + naziv + '\'' +
                '}';
    }
}
