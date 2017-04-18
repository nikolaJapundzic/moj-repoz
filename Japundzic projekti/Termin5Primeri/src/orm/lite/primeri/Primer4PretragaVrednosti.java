package orm.lite.primeri;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.stmt.PreparedQuery;
import com.j256.ormlite.stmt.QueryBuilder;
import com.j256.ormlite.stmt.SelectArg;
import com.j256.ormlite.stmt.Where;
import com.j256.ormlite.support.ConnectionSource;
import orm.lite.model.Jelo;
import orm.lite.model.Meni;
import orm.lite.model.PorucenoJelo;

import java.io.IOException;
import java.util.List;


public class Primer4PretragaVrednosti {

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


            QueryBuilder<Jelo,Integer> jeloCenaNazivQuery=jeloDao.queryBuilder();
            Where<Jelo,Integer> where=jeloCenaNazivQuery.where();
            where.eq(Jelo.POLJE_CENA,200).and().like(Jelo.POLJE_NAZIV,"%e%");
            PreparedQuery<Jelo> jeloCenaPripremljen=jeloCenaNazivQuery.prepare();
            List<Jelo> jela=jeloDao.query(jeloCenaPripremljen);
            for(Jelo j:jela)
                System.out.println("j = " + j);


            SelectArg selectZaOpis=new SelectArg();
            PreparedQuery<Jelo> jeloQueryPripremljen=jeloDao.queryBuilder().where().like(Jelo.POLJE_OPIS,selectZaOpis).prepare();
            selectZaOpis.setValue("%mesom%");
            jela=jeloDao.query(jeloQueryPripremljen);
            for(Jelo j:jela)
                System.out.println("j = " + j);

            selectZaOpis.setValue("%sa%");
            jela=jeloDao.query(jeloQueryPripremljen);
            for(Jelo j:jela)
                System.out.println("j = " + j);


            QueryBuilder<Jelo,Integer> jeloQuery=jeloDao.queryBuilder();

            QueryBuilder<PorucenoJelo,Integer> porucenoJeloQuery=porucenoJeloDao.queryBuilder();

            porucenoJeloQuery.where().eq(PorucenoJelo.POLJE_KOLICINA,2);

            jela=jeloQuery.join(porucenoJeloQuery).query();
            for(Jelo j:jela)
                System.out.println("j = " + j);


            /*
            Zadatak4
            Napisati join select izraz koji spaja porudzbinu sa porucenim jelima
            i prikazuje porudzbine kod kojih je za poruceno jelo postavljena kolicina
            veca od 1
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
