package sql.primeri;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Primer2KreiranjeTabela {
    public static void main( String args[] )
    {
        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection(Konstante.DATABASE_URL);
            System.out.println("Uspesno konektovano na bazu");

            /*
               Sve kolone imaju postavljeno NOT NULL mora se svakoj
               koloni navesti vrednost
               Kolona id je proglasena za primarni kljuc sa kljucnim recima
               PRRIMARY KEY
             */

            stmt = c.createStatement();
            String sql = "CREATE TABLE artikal " +
                    "( id      INT PRIMARY KEY     NOT NULL, " +
                    " naziv   TEXT    NOT NULL, " +
                    " opis    TEXT     NOT NULL, " +
                    " cena    REAL)";
            stmt.executeUpdate(sql);
            stmt.close();


            /*Za stavku treba navesti i kolonu za strani kljuc iz tabele
            artikal i naredbu za ocuvanje referencijalnog integriteta
            FOREIGN KEY(artikal_id) REFERENCES artikal(id)
            */


           // id,kolicina,artikal_id, racun_id

            stmt = c.createStatement();
            sql = "CREATE TABLE stavka " +
                    "(id             INT PRIMARY KEY     NOT NULL, " +
                    " kolicina       INT     NOT NULL, " +
                    " artikal_id     INT     NOT NULL, "+
                    " racun_id      INT     NOT NULL, " +
                    " FOREIGN KEY(artikal_id) REFERENCES artikal(id), "+
                    " FOREIGN KEY(racun_id) REFERENCES racun(id)) ";
            stmt.executeUpdate(sql);
            stmt.close();

            //Zadatak1 kreirati novu CREATE TABLE naredbu za kreiranje

            stmt = c.createStatement();
            sql = "CREATE TABLE racun "+
                    " (id  INT PRIMARY KEY NOT NULL, "+
                    " naziv TEXT NOT NULL, "+
                    " datum NUMERIC NOT NULL) ";
            stmt.executeUpdate(sql);
            stmt.close();


             /*

               Zadatak2 izmeniti CREATE TABLE naredbu za tabela stavka i dodati
                atribut
                racun_id      INT     NOT NULL
                i naredbu za ocuvanje referencijalnog integriteta:
                FOREIGN KEY(racun_id) REFERENCES racun(id)
             */



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
        System.out.println("Tabele kreirane uspesno");
    }
}
