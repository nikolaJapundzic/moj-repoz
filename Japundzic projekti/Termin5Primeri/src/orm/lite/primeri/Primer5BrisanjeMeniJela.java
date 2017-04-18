package orm.lite.primeri;

import com.j256.ormlite.dao.CloseableIterator;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.dao.ForeignCollection;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.misc.TransactionManager;
import com.j256.ormlite.stmt.PreparedQuery;
import com.j256.ormlite.support.ConnectionSource;
import orm.lite.model.Jelo;
import orm.lite.model.Meni;
import orm.lite.model.PorucenoJelo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;


public class Primer5BrisanjeMeniJela {
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

            List<Jelo> jela = jeloDao.queryForAll();
            for (Jelo j:jela)
                System.out.println(j);

            PreparedQuery<Meni> meniPripremljen=meniDao.queryBuilder().where().eq(Meni.POLJE_NAZIV,"Restoran2").prepare();
            final Meni m2 = meniDao.queryForFirst(meniPripremljen);
            if (m2 != null) {

                final ArrayList<Jelo> zaBrisanje = new ArrayList<Jelo>();

                ForeignCollection<Jelo> jelaMenija=m2.getJela();
                CloseableIterator<Jelo> iterator = jelaMenija.closeableIterator();

                try {

                    while (iterator.hasNext()) {
                        Jelo j=iterator.next();
                        zaBrisanje.add(j);
                        System.out.println("Jelo za brisanje: " + j);
                    }
                } catch(Exception e)
                {
                    System.out.println("Greska prilikom iteracije");
                }
                finally {
                    iterator.close();
                }

                TransactionManager.callInTransaction(connectionSource,
                        new Callable<Void>() {
                            public Void call() throws Exception {

                                jeloDao.delete(zaBrisanje);

                                meniDao.delete(m2);

                                return null;
                            }
                        });


            }
            jela = jeloDao.queryForAll();
            for (Jelo j:jela)
                System.out.println(j);

            /*Zadatak5
              Koristeci transakcije obrisati porudjbinu "Marko Markovic" i
              njena porucena jela.
             */

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
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
