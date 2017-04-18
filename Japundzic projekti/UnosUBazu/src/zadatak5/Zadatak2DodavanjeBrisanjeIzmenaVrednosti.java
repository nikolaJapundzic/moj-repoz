package zadatak5;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;
import model.Racun;
import model.Stavka;

import java.io.IOException;
import java.util.Date;
import java.util.List;

/**
 * Created by androiddevelopment on 6.4.17..
 */
public class Zadatak2DodavanjeBrisanjeIzmenaVrednosti {
    public static void main(String[] args) {
        ConnectionSource connectionSource = null;
        try {
            connectionSource = new JdbcConnectionSource("jdbc:sqlite:restoran.db");


            Dao<Racun, Integer> racunDao = DaoManager.createDao(connectionSource, Racun.class);
            Dao<Stavka, Integer> stavkaDao = DaoManager.createDao(connectionSource, Stavka.class);

            Racun r1 = new Racun("R1", new Date());
            racunDao.create(r1);

            Racun r2 = new Racun("R2", new Date());
            racunDao.create(r2);

            List<Racun> racuni = racunDao.queryForAll();
            for(Racun r : racuni)
            {
                System.out.println("racun : " + r);
            }

            Stavka s1= new Stavka(1);
            s1.setRacun(r1);
            stavkaDao.create(s1);
            /*
            TableUtils.dropTable(connectionSource, Stavka.class, true);
            TableUtils.dropTable(connectionSource, Racun.class, true);

            TableUtils.createTable(connectionSource, Stavka.class);
            TableUtils.createTable(connectionSource, Racun.class);
            */

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
