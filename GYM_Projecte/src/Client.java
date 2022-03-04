import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Client {

    private String nom;
    private String cognom;
    private String cognom2;
    private Dni dni;
    private LocalDate dataNaixament;
    private CorreuElectronic correu;
    private String sexe;
    private Telefon telefon;
    private CompteBancari compteBancari;
    private boolean comunicacio;
    private String condicioFisica;
    private int edat;


    // Seters i Geters
    // #######################################################################|

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getCognom() {
        return cognom;
    }

    public void setCognom(String cognom) {
        this.cognom = cognom;
    }

    public String getCognom2() {
        return cognom2;
    }

    public void setCognom2(String cognom2) {
        this.cognom2 = cognom2;
    }

    public Dni getDni() {
        return dni;
    }

    public void setDni(Dni dni) {
        this.dni = dni;
    }

    public LocalDate getDataNaixament() {
        return dataNaixament;
    }

    public void setDataNaixament(LocalDate dataNaixament) {
        this.dataNaixament = dataNaixament;
    }

    public CorreuElectronic getCorreu() {
        return correu;
    }

    public void setCorreu(CorreuElectronic correu) {
        this.correu = correu;
    }

    public String getSexe() {
        return sexe;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public Telefon getTelefon() {
        return telefon;
    }

    public void setTelefon(Telefon telefon) {
        this.telefon = telefon;
    }

    public CompteBancari getCompteBancari() {
        return compteBancari;
    }

    public void setCompteBancari(CompteBancari compteBancari) {
        this.compteBancari = compteBancari;
    }

    public boolean isComunicacio() {
        return comunicacio;
    }

    public void setComunicacio(boolean comunicacio) {
        this.comunicacio = comunicacio;
    }

    public String getCondicioFisica() {
        return condicioFisica;
    }

    public void setCondicioFisica(String condicioFisica) {
        this.condicioFisica = condicioFisica;
    }

    public int getEdat() {
        return edat;
    }

    public void setEdat(int edat) {
        this.edat = edat;
    }


    // Metodes
    // #######################################################################|


    public void consultaClient() throws SQLException {

        Scanner entradateclat = new Scanner(System.in);
        
        String dni = entradateclat.nextLine();

        Client client = consultaClientBD(dni);

        if (client != null) {

            System.out.println(client);

        }else{
            System.out.println("no");
        }


        entradateclat.close();

    }

    
    private Client consultaClientBD(String dni) throws SQLException {

        ConexioBD bd= new ConexioBD();
        Connection con = bd.conBD();

        String consulta = "SELECT * FROM client where DNI = ?";

        PreparedStatement sentencia = con.prepareStatement(consulta);

        sentencia.setString(1, dni);

        ResultSet rs =sentencia.executeQuery();

        if(rs.next()){
            cargarDadesDeSenteciaAClient(rs);
            return this;
        }

        return null;
    }

    public void altaClient() throws SQLException {

        Scanner entradateclat = new Scanner(System.in);

        String dni;

        Dni dniObj = new Dni();

        do {

            System.out.println("Introdueix el dni del client que vols donar d'alta");

            dni = entradateclat.next();

        } while (!dniObj.validarDni(dni));

        dniObj.setDni(dni);

        setDni(dniObj);

        if (consultaClientBD(dniObj.getDni()) != null) {

            System.out.println("El client amb aquest DNI ja existeix");

        } else {

            // Entrada nom
            // #######################################################################|
            this.nom = entradateclat.next();


            // Entrada cognoms
            // #######################################################################|
            this.cognom = entradateclat.next();

            this.cognom2 = entradateclat.next();


            // Validació de Data
            // #######################################################################|
            DateTimeFormatter formatdata = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            boolean dataCorrecta;

            do {
                dataCorrecta = true;
                System.out.println();
                try {
                    this.dataNaixament = LocalDate.parse(entradateclat.next(), formatdata);
                } catch (Exception e) {
                    dataCorrecta = false;
                }

            } while (!dataCorrecta);

            // Validació de Correu
            // #######################################################################|
            String correu;

            CorreuElectronic correuobj = new CorreuElectronic();

            System.out.println("Introdueix el dni del client que vols donar d'alta");

            correu = entradateclat.next();

            correuobj.validarCorreu(correu);

            correuobj.setCorreu(correu);

            setCorreu(correuobj);

            // Entrada Sexe
            // #######################################################################|
            this.sexe = entradateclat.next();
           

            // Validació de Telefon
            // #######################################################################|

            String telefon;

            Telefon telefonobj = new Telefon();
    
            do {
    
                System.out.println("Introdueix el dni del client que vols donar d'alta");
    
                telefon = entradateclat.nextLine();
    
            } while (telefonobj.validarTelefon(telefon));
    
            telefonobj.setTelefono(telefon);
    
            setTelefon(telefonobj);
            
            // Validació de CCC
            // #######################################################################|
            CompteBancari ccc = new CompteBancari();


            // Entrada Comunicació
            // #######################################################################|

            System.out.println("Entra la condició física que presenta el Client");

            this.comunicacio = entradateclat.nextBoolean();


            // Entrada Condició Fiscia
            // #######################################################################|
            System.out.println("Entra la condició física que presenta el Client");

            this.condicioFisica = entradateclat.nextLine();
            

        }

        entradateclat.close();

    }


    // Mapeig (Entarda de BDD a OBJ)
    // #######################################################################|
    private void cargarDadesDeSenteciaAClient(ResultSet rs) throws SQLException {

        this.setDni(new Dni(rs.getString("DNI")));

    }


    // Mapeig (Sortida de OBJ a BDD)
    // #######################################################################|
    private void cargarDadesDeClientASentencia(PreparedStatement ps) throws SQLException {

        ps.setString(1, this.dni.getDni());

    }

}
