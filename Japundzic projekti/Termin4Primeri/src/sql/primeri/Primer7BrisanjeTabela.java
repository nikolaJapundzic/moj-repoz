package sql.primeri;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Primer7BrisanjeTabela {
    public static void main( String args[] )
    {
        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection(Konstante.DATABASE_URL);
            System.out.println("Uspesno konektovano na bazu");

            stmt = c.createStatement();
            String sql = "DROP TABLE IF EXISTS stavka";
            stmt.executeUpdate(sql);
            stmt.close();

            stmt = c.createStatement();
            sql = "DROP TABLE IF EXISTS artikal";
            stmt.executeUpdate(sql);
            stmt.close();

            stmt = c.createStatement();
            sql = "DROP TABLE IF EXISTS racun";
            stmt.executeUpdate(sql);
            stmt.close();
            /*Zadatak7 Napisati DROP izraz koji  brise tabelu racun
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
        System.out.println("Tabele obrisane");
    }
}
