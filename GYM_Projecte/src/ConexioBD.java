import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexioBD {

    private Connection ConBD;

    private String servidor="jdbc:mysql://localhost:3306/";
    private String bbdd= "projecte2";
    private String user= "root";
    private String password= "root";


    public Connection conBD() {

        try {

            ConBD = DriverManager.getConnection(servidor + bbdd, user, password);
            System.out.println("Connexio amb exit");

        } catch (SQLException ex) {

            System.out.println("No sa pogut connectar");
            ex.printStackTrace(); 

        }
        return ConBD;
    }

    public void desBD() {

        try {     

            ConBD.close();

        } catch (SQLException e) {

            System.out.println("No sa pogut tancar la conexio amb la base de dades");
            e.printStackTrace();
            
        }
    }
    

}
