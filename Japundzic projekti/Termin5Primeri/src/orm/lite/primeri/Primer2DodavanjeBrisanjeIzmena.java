package orm.lite.primeri;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;
import orm.lite.model.*;

import java.awt.*;
import java.io.IOException;
import java.util.Date;
import java.util.List;


public class Primer2DodavanjeBrisanjeIzmena {

    static Dao<Jelo,Integer> jeloDao;
    static Dao<Meni,Integer> meniDao;
    static Dao<PorucenoJelo,Integer> porucenoJeloDao;
    static Dao<Radnik,Integer> radnikDao;
    static Dao<AdresaStanovanja,Integer> adresaStanovanjaDao;

    public static void main(String[] args) {
        ConnectionSource connectionSource = null;
        try {
            // create our data-source for the database
            connectionSource = new JdbcConnectionSource(Konstante.DATABASE_URL);
            jeloDao = DaoManager.createDao(connectionSource, Jelo.class);
            meniDao = DaoManager.createDao(connectionSource, Meni.class);
            porucenoJeloDao = DaoManager.createDao(connectionSource, PorucenoJelo.class);

            adresaStanovanjaDao = DaoManager.createDao(connectionSource, AdresaStanovanja.class);
            radnikDao = DaoManager.createDao(connectionSource, Radnik.class);


            TableUtils.clearTable(connectionSource, PorucenoJelo.class);
            TableUtils.clearTable(connectionSource, Jelo.class);
            TableUtils.clearTable(connectionSource, Meni.class);
            TableUtils.clearTable(connectionSource, Radnik.class);
            TableUtils.clearTable(connectionSource, AdresaStanovanja.class);


            AdresaStanovanja as1=new AdresaStanovanja("Bulevar Jase Tomica","13a");
            adresaStanovanjaDao.create(as1);

            AdresaStanovanja as2=new AdresaStanovanja("Bulevar Oslobodjenja","134");
            adresaStanovanjaDao.create(as2);

            Radnik r1=new Radnik("Nemanja","Nemanjic");
            r1.setAdresa(as1);
            radnikDao.create(r1);

            Radnik r2=new Radnik("Stanko","Stankovic");
            r2.setAdresa(as2);
            radnikDao.create(r2);

            List<Radnik> radnici=radnikDao.queryForAll();
            for(Radnik r:radnici) {
                System.out.println("Radnik = " +r);
                System.out.println("Adresa Radnika = "+r.getAdresa());
                System.out.println();
            }

            Meni m1 = new Meni(new Date(), "Restoran1");
            meniDao.create(m1);

            Meni m2 = new Meni(new Date(), "Restoran2");
            meniDao.create(m2);

            Jelo j1 = new Jelo("Spagete", "Testo sa mesom", 400, m1);
            jeloDao.create(j1);

            Jelo j2 = new Jelo("Cevapi", "Meso", 350, m1);
            jeloDao.create(j2);

            Jelo j3 = new Jelo("Kolac", "Kolac sa orasima", 200, m1);
            jeloDao.create(j3);

            Jelo j4 = new Jelo("Pljeskavica", "Lepinja sa mesom", 200, m2);
            jeloDao.create(j4);

            Jelo j5 = new Jelo("Belo meso", "Belo meso", 200, m2);
            jeloDao.create(j5);

            /*
            Zadatak 1 napisati klasu Porudzbina sa atributima

              id tipa int
              konobar tipa String
              datum tipa Date
            dodati i atribut porucenaJela ForeignCollection<PorucenoJelo>


            Zadatak 1a izmeniti klasu PorucenoJelo da ima atribut
            porudzbina i u konstrukotru sa parametrima dodati da
             ocekuje parametar porudzbina
             dodati i get i set metode za atribut porudzbina
              */
            /*
              Zadatak 2 instancirati dva objekta klase Prudzbina
              sa sledecim vrednostima
              konobar:"Marko Markovic", datum:new Date()
              konobar:"Petar Petrovic", datum: new Date()

              Zadatak 2a dodati prilikom instanciranja klase PrucenoJelo da
              se prosledjuju i Porudzbina "Marko Markovic" za prvo PorucenoJelo i
              Porudzbina "Petar Petrovic" za drugo poruceno jelo
             */

            PorucenoJelo pj1 = new PorucenoJelo(1, j1);
            porucenoJeloDao.create(pj1);

            PorucenoJelo pj2 = new PorucenoJelo(2, j3);
            porucenoJeloDao.create(pj2);

            Jelo jeloZaIzmenu = jeloDao.queryForId(j1.getId());
            jeloZaIzmenu.setOpis("Rezanci sa mesom");
            jeloDao.update(jeloZaIzmenu);

            List<Jelo> jela = jeloDao.queryForAll();
            for (Jelo j : jela)
                System.out.println(j);

            Jelo j6 = new Jelo("Slatka palacinka", "Palacinka sa orasima", 200, m1);
            jeloDao.create(j6);

            jela = jeloDao.queryForAll();
            for (Jelo j : jela)
                System.out.println(j);


            Jelo jeloZaBrisanje = jeloDao.queryForId(j6.getId());
            jeloDao.delete(jeloZaBrisanje);

            jela = jeloDao.queryForAll();
            for (Jelo j : jela)
                System.out.println(j);

            jela=jeloDao.queryForEq(Jelo.POLJE_CENA,200);
            for (Jelo j : jela)
                System.out.println(j);

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
