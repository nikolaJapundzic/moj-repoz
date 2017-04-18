package orm.lite.primeri;

import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;
import orm.lite.model.*;

import java.io.IOException;


public class Primer1KreiranjeTabela {

    public static void main(String[] args){
        ConnectionSource connectionSource = null;
        try {
            // create our data-source for the database
            connectionSource = new JdbcConnectionSource("jdbc:sqlite:restoran.db");

            TableUtils.dropTable(connectionSource, PorucenoJelo.class,true);
            TableUtils.dropTable(connectionSource, Jelo.class,true);
            TableUtils.dropTable(connectionSource, Meni.class,true);
            TableUtils.dropTable(connectionSource, AdresaStanovanja.class,true);
            TableUtils.dropTable(connectionSource, Radnik.class,true);

            TableUtils.createTable(connectionSource,PorucenoJelo.class);
            TableUtils.createTable(connectionSource,Jelo.class);
            TableUtils.createTable(connectionSource,Meni.class);
            TableUtils.createTable(connectionSource,Radnik.class);
            TableUtils.createTable(connectionSource,AdresaStanovanja.class);
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            if (connectionSource != null) {
                try {
                    connectionSource.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
