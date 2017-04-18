package model;

import com.j256.ormlite.dao.ForeignCollection;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;

import java.sql.*;
import java.util.Date;



@DatabaseTable(tableName = "racun")
public class Racun {

    public static final String POLJE_OZNAKA = "oznaka";
    public static final String POLJE_DATUM = "datum";

    @DatabaseField(generatedId = true)
    private int id;

    @DatabaseField(columnName = POLJE_OZNAKA, canBeNull = false, unique = false)
    private String oznaka;

    @DatabaseField(columnName = POLJE_DATUM, canBeNull = false, unique = false)
    private Date datum;

    @ForeignCollectionField(foreignFieldName = "racun", eager = false, maxEagerLevel = 1)
    private ForeignCollection<Stavka> stavke;

    public Racun() {
        //obavezno za ORMLite
    }

    public Racun(String oznaka, Date datum) {
        this.oznaka = oznaka;
        this.datum = datum;
    }

}
