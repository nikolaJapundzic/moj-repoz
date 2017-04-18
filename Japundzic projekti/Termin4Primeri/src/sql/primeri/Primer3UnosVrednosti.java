package sql.primeri;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by zek on 8/23/16.
 */
public class Primer3UnosVrednosti {
    public static void main( String args[] )
    {
        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection(Konstante.DATABASE_URL);

            System.out.println("Uspesno konektovano na bazu");

            stmt = c.createStatement();
            String sql = "INSERT INTO artikal (id,naziv,opis,cena) " +
                    "VALUES (1, 'Mleko', 'Mleko u flasi 1L', 40.99 );";
            stmt.executeUpdate(sql);
            stmt.close();

            stmt = c.createStatement();
            sql = "INSERT INTO artikal (id,naziv,opis,cena) " +
                    "VALUES (2, 'Beli hleb', '400g', 50);";
            stmt.executeUpdate(sql);
            stmt.close();

            stmt = c.createStatement();
            sql = "INSERT INTO artikal (id,naziv,opis,cena) " +
                    "VALUES (3, 'Crni hleb', 'Crni razeni hleb', 60);";
            stmt.executeUpdate(sql);
            stmt.close();
//-------------------------
            stmt = c.createStatement();
            sql = "INSERT INTO racun ('id','naziv','datum')  VALUES ('1','racun 1',Date('now') ) ";
            stmt.executeUpdate(sql);
            stmt.close();

            stmt = c.createStatement();
            sql = "INSERT INTO racun ('id','naziv','datum')  VALUES ('2','racun 2',Date('now') ) ";
            stmt.executeUpdate(sql);
            stmt.close();

            /*Zadatak3 napisati INSERT izraze za ubacivanje vrednosti u tabelu
            racun
               Ubaciti 2 nova reda sa sledecim vrednostima:
               id: 1, oznaka 'Racun1' i datum: date('now')
               id: 2, oznaka 'Racun2' i datum: date('now')
               */






                /*

             Zadatak3a Izmeniti INSERT izraz za dodavanje vrednosti u tabelu stavke
             kako bi se ubacile vrednosti za kolonu stranog kljuca racun_id
             Izmeniti na sledeci nacin:
             Za vrednosti primarnog kljuca id ubaciti vrednosti za strani kljuc kolone
             racun_id kao sto je navedeno
                id       racun_id
                 1          1
                 2          1
                 3          2
            */

            stmt = c.createStatement();
            sql = "INSERT INTO stavka (id,kolicina,artikal_id, racun_id) " +
                    "VALUES (1, 1, 1, 1);";
            stmt.executeUpdate(sql);
            stmt.close();

            stmt = c.createStatement();
            sql = "INSERT INTO stavka (id,kolicina,artikal_id, racun_id) " +
                    "VALUES (2, 2, 2, 1 );";
            stmt.executeUpdate(sql);
            stmt.close();

            stmt = c.createStatement();
            sql = "INSERT INTO stavka (id,kolicina,artikal_id, racun_id) " +
                    "VALUES (3, 3, 3, 2);";
            stmt.executeUpdate(sql);

            stmt.close();

        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
        } finally{
            try {
                /*Zatvaramo konekciju sa bazom u slucaju da se desi neki
                   izuzetak ili ako sve uspe uspesno da se izvrsi
                 */
                c.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Uspesno ubacene vrednosti");
    }
}
