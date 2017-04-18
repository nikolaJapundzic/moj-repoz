package orm.lite.model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "radnik")
public class Radnik {

    public static final String POLJE_IME="ime";
    public static final String POLJE_PREZIME="prezime";

    @DatabaseField(generatedId = true)
    private int id;
    @DatabaseField(columnName = POLJE_IME,canBeNull = false)
    private String ime;
    @DatabaseField(columnName = POLJE_PREZIME,canBeNull = false)
    private String prezime;

    @DatabaseField(foreign = true, foreignAutoRefresh = true, canBeNull = false)
    private AdresaStanovanja adresa;
    //foreignAutoRefresh ostavljamo true ako znamo da cemo za radnika da koristimo adresu stanovanja

    public Radnik(){
        //konstruktor bez parametara obavezan za ORMLite
    }

    public Radnik(String ime, String prezime) {
        this.ime = ime;
        this.prezime = prezime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public AdresaStanovanja getAdresa() {
        return adresa;
    }

    public void setAdresa(AdresaStanovanja adresa) {
        this.adresa = adresa;
    }

    @Override
    public String toString() {
        return "Radnik{" +
                "id=" + id +
                ", ime='" + ime + '\'' +
                ", prezime='" + prezime + '\'' +
                '}';
    }
}
