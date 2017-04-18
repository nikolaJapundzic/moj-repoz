package orm.lite.model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName="adresa_stanovanja")
public class AdresaStanovanja {

    public static final String POLJE_ULICA="ulica";
    public static final String POLJE_BROJ="broj";

    @DatabaseField(generatedId = true)
    public int id;
    @DatabaseField(columnName = POLJE_ULICA,canBeNull = false)
    public String ulica;
    @DatabaseField(columnName = POLJE_BROJ,canBeNull = false)
    public String broj;

    public AdresaStanovanja() {
        //konstruktor bez parametara obavezan za ORMLite
    }

    public AdresaStanovanja(String ulica, String broj) {
        this.ulica = ulica;
        this.broj = broj;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUlica() {
        return ulica;
    }

    public void setUlica(String ulica) {
        this.ulica = ulica;
    }

    public String getBroj() {
        return broj;
    }

    public void setBroj(String broj) {
        this.broj = broj;
    }

    @Override
    public String toString() {
        return "AdresaStanovanja{" +
                "id=" + id +
                ", ulica='" + ulica + '\'' +
                ", broj='" + broj + '\'' +
                '}';
    }
}
