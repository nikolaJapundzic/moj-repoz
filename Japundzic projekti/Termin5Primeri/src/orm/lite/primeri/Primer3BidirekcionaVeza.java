package orm.lite.primeri;

import com.j256.ormlite.dao.CloseableIterator;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.dao.ForeignCollection;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;
import orm.lite.model.Jelo;
import orm.lite.model.Meni;
import orm.lite.model.PorucenoJelo;

import java.io.IOException;
import java.util.List;


public class Primer3BidirekcionaVeza {

    static Dao<Jelo,Integer> jeloDao;
    static Dao<Meni,Integer> meniDao;
    static Dao<PorucenoJelo,Integer> porucenoJeloDao;

    public static void main(String[] args) {
        ConnectionSource connectionSource = null;
        try {
            // create our data-source for the database
            connectionSource = new JdbcConnectionSource(Konstante.DATABASE_URL);
            jeloDao = DaoManager.createDao(connectionSource, Jelo.class);
            meniDao = DaoManager.createDao(connectionSource, Meni.class);
            porucenoJeloDao = DaoManager.createDao(connectionSource, PorucenoJelo.class);

            List<Meni> meni=meniDao.queryForAll();
            for(Meni m:meni)
                System.out.println(m);

            meni=meniDao.queryForEq(Meni.POLJE_NAZIV,"Restoran2");
            ForeignCollection<Jelo> jelaMenija=meni.get(0).getJela();

            CloseableIterator<Jelo> iterator=jelaMenija.closeableIterator() ;

            try {

                while (iterator.hasNext()) {
                    Jelo j = iterator.next();
                    System.out.println("j = " + j);
                }
            }catch(Exception e){
                System.out.println("Greska prilikom iteracije");
            }
            finally {
                iterator.close();
            }

            /*Zadatak3
              Za objekat klase Porudjbina "Marko Markovic" prikazati sva porucena
              jela koristeci CloseableIterator<PorucenoJelo>

             */

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

