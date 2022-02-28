import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Client {

    private String nom;
    private String cognom;
    private String cognom2;
    private Dni dni;
    private String dataNaixament;
    private String correu;
    private char sexe;
    private String telefon;
    private String compteBancari;
    private boolean comunicacio;
    private String condicioFisica;


    public  void consultaClient() throws SQLException {

        Scanner entradateclat = new Scanner(System.in);

        this.dni = entradateclat.nextLine();

        ConexioBD bd = new ConexioBD();
        Connection con = bd.conBD();

        System.out.println("Llistar tots els productes");

        String consulta="SELECT * FROM client where DNI = ?";

        PreparedStatement sentencia = con.prepareStatement(consulta);

        sentencia.setString(1, Dni);

        ResultSet rs=sentencia.executeQuery();

        if(rs.next()){


        }

    }

    public void altaClient(){

        Scanner entradateclat = new Scanner(System.in);

        Dni dniObj = new Dni();

        do{

            System.out.println("Introdueix el dni del client que vols donar d'alta");
            String dni =entradateclat.next();

            dniObj.validarDni(dni);


    }








    


    
}
