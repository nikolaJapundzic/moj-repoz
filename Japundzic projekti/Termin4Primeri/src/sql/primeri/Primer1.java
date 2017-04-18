package sql.primeri;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Primer1 {
    public static void main( String args[] )
    {
        Connection c = null;
        try {
            //Inicjalizujemo drajver za SQLite
            Class.forName("org.sqlite.JDBC");
            //Upostavljamo konekciju sa bazom
            c = DriverManager.getConnection("jdbc:sqlite:prodavnicaSQLite.db");
            //SQL naredbe koje zelimo da posaljemo bazi
        } catch ( Exception e )
        /*Hvatamo bilo kakav izuzetak koji moze da znaci
           da ne mozemo da uspostavimo konekciju sa bazom
         */
        {
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
        System.out.println("Uspesno kreirao bazu podataka");
    }
}
//ako se ni jedna od klasas ne potrefi uvek dce se uhvatiti u try catch bloku, exeption je na vrhu uvek za sql