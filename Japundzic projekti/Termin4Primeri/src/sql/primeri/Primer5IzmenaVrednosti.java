package sql.primeri;

import java.sql.*;

/**
 * Created by zek on 8/23/16.
 */
public class Primer5IzmenaVrednosti {
    public static void main( String args[] )
    {
        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection(Konstante.DATABASE_URL);

            System.out.println("Uspesno konektovano na bazu");

            stmt = c.createStatement();
            String sql = "UPDATE artikal SET " +
                         "cena = 30.0,opis='Beli hleb 300g' " +
                         "WHERE id=2;";
            stmt.executeUpdate(sql);
            stmt.close();


            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery( "SELECT * FROM artikal;" );
            Konstante.prikazUniverzalan(rs);
            rs.close();
            stmt.close();

            /*Zadatak5 Napisati UPDATE izraz koji za red iz tabele racun
            sa vrednoscu primarnog kljuca 1 menja vrednost kolone oznaka na
            'RacunPrvi' i takodje napisati SELECT izraz koji pronalazi sve
             vrednosti iz tabele racun i prikazuje na konzoli koristeci metodu
             Konstante.prikazUniverzalan i prosledjujuci ResultSet koji se dobije
             nakon poziva metode executeQuery
             */
            stmt = c.createStatement();
            sql = " UPDATE racun SET " +
                    " naziv = 'RacunPrvi' " +
                    " WHERE id=1; ";
            stmt.executeUpdate(sql);
            stmt.close();

            System.out.println("Izmena");
            stmt = c.createStatement();
            rs = stmt.executeQuery( "SELECT * FROM racun;" );
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
        System.out.println("Obavljena izmena vrednosti");
    }
}
