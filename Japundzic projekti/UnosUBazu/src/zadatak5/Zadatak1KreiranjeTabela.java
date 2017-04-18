package zadatak5;

import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;
import model.Racun;
import model.Stavka;

import java.io.IOException;

/**
 * Created by androiddevelopment on 6.4.17..
 */
public class Zadatak1KreiranjeTabela {

    public static void main(String[] args) {
        ConnectionSource connectionSource = null;
        try {
            connectionSource = new JdbcConnectionSource("jdbc:sqlite:restoran.db");

            TableUtils.dropTable(connectionSource, Stavka.class, true);
            TableUtils.dropTable(connectionSource, Racun.class, true);

            TableUtils.createTable(connectionSource, Stavka.class);
            TableUtils.createTable(connectionSource, Racun.class);

        }catch(Exception e){
            e.printStackTrace();
        }finally {
            try {
                connectionSource.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }



    }
}
