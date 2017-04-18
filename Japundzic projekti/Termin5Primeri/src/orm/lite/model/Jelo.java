package orm.lite.model;

import com.j256.ormlite.dao.ForeignCollection;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "jelo")
public class Jelo {

    public static final String POLJE_NAZIV="naziv";
    public static final String POLJE_OPIS="opis";
    public static final String POLJE_CENA="cena";

    @DatabaseField(generatedId = true)
    private int id;

    @DatabaseField(columnName = POLJE_NAZIV,canBeNull = false, unique=false)
    private String naziv;
    @DatabaseField(columnName = POLJE_OPIS)
    private String opis;
    @DatabaseField(columnName = POLJE_CENA,canBeNull = false)
    private double cena;

    @DatabaseField(foreign = true, foreignAutoRefresh = true, canBeNull = false)
    private Meni meni;

    @ForeignCollectionField(foreignFieldName = "jelo")
    private ForeignCollection<PorucenoJelo> porucenaJela;

    public Jelo() {
        //konstruktor bez parametara obavezan za ORMLite
    }

    public Jelo(String naziv, String opis, double cena, Meni meni) {
        this.naziv = naziv;
        this.opis = opis;
        this.cena = cena;
        this.meni = meni;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public double getCena() {
        return cena;
    }

    public void setCena(double cena) {
        this.cena = cena;
    }

    public Meni getMeni() {
        return meni;
    }

    public void setMeni(Meni meni) {
        this.meni = meni;
    }

    public ForeignCollection<PorucenoJelo> getPorucenaJela() {
        return porucenaJela;
    }

    public void setPorucenaJela(ForeignCollection<PorucenoJelo> porucenaJela) {
        this.porucenaJela = porucenaJela;
    }

    @Override
    public String toString() {
        return "Jelo{" +
                "id=" + id +
                ", naziv='" + naziv + '\'' +
                ", opis='" + opis + '\'' +
                ", cena=" + cena +
                ", meni=" + meni +
                '}';
    }
}
