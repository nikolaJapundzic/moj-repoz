package sql.primeri;

import java.sql.*;


public class Primer6BrisanjeVrednosti {
    public static void main( String args[] )
    {
        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection(Konstante.DATABASE_URL);

            System.out.println("Uspesno konektovano na bazu");

            stmt = c.createStatement();
            String sql = "DELETE FROM stavka where ID=1;";
            stmt.executeUpdate(sql);
            stmt.close();


            ResultSet rs = stmt.executeQuery( "SELECT * FROM stavka" );
            Konstante.prikazUniverzalan(rs);
            rs.close();

            stmt = c.createStatement();
            sql = "DELETE FROM artikal where ID=1;";
            stmt.executeUpdate(sql);
            stmt.close();


            rs = stmt.executeQuery( "SELECT * FROM artikal;" );
            Konstante.prikazUniverzalan(rs);
            rs.close();
            stmt.close();

             /*Zadatak6 Napisati DELETE izraz koji  brise red iz tabele racun
            sa vrednoscu primarnog kljuca 1 i takodje napisati SELECT izraz koji
             pronalazi sve vrednosti iz tabele racun i prikazuje na konzoli
             koristeci metodu Konstante.prikazUniverzalan i prosledjujuci
              ResultSet koji se dobije nakon poziva metode executeQuery
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
        System.out.println("Obavljeno brisanje vrednosti");
    }
}
