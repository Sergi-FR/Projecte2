import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Scanner;

import javax.xml.crypto.Data;

public class Client {

    private String nom;
    private String cognom;
    private Dni DNI;
    private LocalDate dataNaixament;
    private Correu correu;
    private String sexe;
    private Telefon telefon;
    private CompteBancari compteBancari;
    private boolean comunicacio;
    private String condicioFisica;
    private int edat;

    public void consultaClient() throws SQLException {

        Scanner entradateclat = new Scanner(System.in);

        String dni = entradateclat.nextLine();

        ConexioBD bd = new ConexioBD();
        Connection con = bd.conBD();

        System.out.println("Llistar tots els productes");

        String consulta = "SELECT * FROM client where DNI = ?";

        PreparedStatement sentencia = con.prepareStatement(consulta);

        sentencia.setString(1, dni);

        ResultSet rs = sentencia.executeQuery();

        if (rs.next()) {
            cargarDadesDeSentenciaEnClients(rs);
        }

    }

    public void altaClient() {

        Scanner entradateclat = new Scanner(System.in);

        Dni dniObj = new Dni();
        String dni;

        do {

            System.out.println("Introdueix el dni del client que vols donar d'alta");
            dni = entradateclat.next();

        } while (dniObj.validarDni(dni));

    }

    public void cargarDadesDeClientsEnSentencia(PreparedStatement ps) throws SQLException {

        ps.setString(1, this.DNI.getDni());
        ps.setString(2, this.nom);
        ps.setString(3, this.cognom);
        ps.setString(4, this.dataNaixament.toString());
        ps.setString(5, this.telefon.getTelefon());
        ps.setString(6, this.correu.getCorreu());
        ps.setString(7, this.sexe);
        ps.setString(8, this.condicioFisica);
        ps.setBoolean(9, this.comunicacio);
        // ps.setString(10, this.compteBancari.getCCC());

    }

    private void cargarDadesDeSentenciaEnClients(ResultSet rs) throws SQLException {

        this.DNI = new Dni(rs.getString("DNI"));
        this.nom = rs.getString("Nom");
        this.cognom = rs.getString("Cognom");
        this.dataNaixament = rs.getDate("Data_Naixament").toLocalDate();
        this.correu = new Correu(rs.getString("Correu_e"));
        this.sexe = rs.getString("Sexe");
        this.telefon = new Telefon(rs.getString("Tel."));
        this.condicioFisica = rs.getString("Condicio_Fisica");
        this.comunicacio = rs.getBoolean("Comunicació_comercial");
        // this.compteBancari = rs.getString("compteBancari");

    }

}
