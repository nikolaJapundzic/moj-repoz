package model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.sql.*;
import java.util.Date;


@DatabaseTable(tableName = "stavka")
public class Stavka {

    public static final String POLJE_KOLICINA = "kolicina";


    @DatabaseField(generatedId = true)
    private int id;

    @DatabaseField(columnName = POLJE_KOLICINA, canBeNull = false, unique = false)
    private int kolicina;

    @DatabaseField(foreign = true, foreignAutoRefresh = true, canBeNull = false)
    private Racun racun;

    public Stavka(int kolicina) {
        this.kolicina = kolicina;
    }

    public void setRacun(Racun racun) {
        this.racun = racun;
    }

    public Stavka() {
    }
}
