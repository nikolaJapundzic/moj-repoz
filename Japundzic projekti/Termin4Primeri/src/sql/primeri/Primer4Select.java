package sql.primeri;

import java.sql.*;

public class Primer4Select {
    public static void main( String args[] )
    {
        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection(Konstante.DATABASE_URL);

            System.out.println("Uspesno konektovano na bazu");

            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery( "SELECT * FROM artikal" );
            while ( rs.next() ) {
                int id = rs.getInt("id");
                String naziv = rs.getString("naziv");
                String opis = rs.getString("opis");
                double cena = rs.getDouble("cena");
                System.out.println( "ID = " + id );
                System.out.println( "NAZIV = " + naziv );
                System.out.println( "OPIS = " + opis );
                System.out.println( "CENA = " + cena );
                System.out.println();
            }
            rs.close();
            stmt.close();

            System.out.println("Prikaz svih vrednosti kolona artikala kod " +
                    "kojih se u nazivu pojavljuje slovo e i" +
                    " sortiranih po nazivu u rastućem redosledu");
            stmt = c.createStatement();
            rs = stmt.executeQuery( "SELECT * FROM artikal WHERE naziv LIKE '%e%' ORDER BY naziv ASC" );
            Konstante.prikazUniverzalan(rs);
            rs.close();
            stmt.close();

            System.out.println("Prikaz svih vrednosti kolona stavki gde je" +
                    " vrednost količine veća od 2 i sortiranih po količini " +
                    "u rastućem redosledu");
            stmt = c.createStatement();
            rs = stmt.executeQuery( "SELECT * FROM stavka WHERE kolicina>2 ORDER BY kolicina" );
            Konstante.prikazUniverzalan(rs);
            rs.close();
            stmt.close();


            System.out.println("Prikaz svih vrednosti kolona artikala kod" +
                    " kojih se cena nalazi u intervalu od 30 do 60");
            stmt = c.createStatement();
            rs = stmt.executeQuery( "SELECT * FROM artikal WHERE cena BETWEEN 30 AND 60" );
            Konstante.prikazUniverzalan(rs);
            rs.close();
            stmt.close();

            System.out.println("Prikaz svih vrednosti iz tabele stavke");
            stmt = c.createStatement();
            rs = stmt.executeQuery( "SELECT * FROM stavka" );
            Konstante.prikazUniverzalan(rs);
            rs.close();
            stmt.close();

            System.out.println("Spajanje dve tabele eksplicitnim navodjenjem" +
                                " uslova u WHERE klauzuli");
            stmt = c.createStatement();
            rs = stmt.executeQuery( "SELECT * FROM artikal t1,stavka t2 " +
                                    "WHERE t1.id=t2.artikal_id" );
            Konstante.prikazUniverzalan(rs);
            rs.close();
            stmt.close();

            System.out.println("Koristeći JOIN operaciju spajanje dve tabele");   // Outer, left, right join dodatbne naredbe
            System.out.println("INNER JOIN primer artikal stavka");
            stmt = c.createStatement();
            rs = stmt.executeQuery( "SELECT * " +
                    "FROM artikal a INNER JOIN stavka s "+
                    "ON a.id=s.artikal_id ");
            Konstante.prikazUniverzalan(rs);
            rs.close();
            stmt.close();

            /*Zadatak4 napisati select izraz koji radi INNER JOIN izmedju tabela
            artikal, stavka i racun povezujuci odgovarajuce kolone na osnovu vrednosti
            stranih kljuceva artikal_id i racun_id u tabeli stavka i odgovarajucih
            id vrednosti kolona
            */
            System.out.println("Prikaz svih vrednosti kolona artikala kod " +
                    "kojih se u nazivu pojavljuje slovo e i" +
                    " sortiranih po nazivu u rastućem redosledu");
            stmt = c.createStatement();
            rs = stmt.executeQuery( "SELECT * FROM artikal INNER JOIN stavka ON stavka.artikal_id = artikal.id INNER JOIN racun ON stavka.racun_id = racun.id" );
            Konstante.prikazUniverzalan(rs);
            rs.close();
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
        System.out.println("Obavljene select naredbe");
    }

}
