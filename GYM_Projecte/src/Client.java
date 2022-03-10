import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class Client {

    private String nom;
    private String cognom;
    private Dni dni;
    private LocalDate dataNaixament;
    private CorreuElectronic correu;
    private String sexe;
    private Telefon telefon;
    private CompteBancari compteBancari;
    private boolean comunicacio;
    private String condicioFisica;
    private int edat;

    public Client(){

        dni = new Dni();
        dataNaixament = LocalDate.now();
        correu = new CorreuElectronic();
        telefon = new Telefon();
        compteBancari = new CompteBancari();

    }
    

    @Override
    public String toString() {
        return "Cognom: " + cognom + ", Compte Bancari: " + compteBancari.getCCC() + ", Comunicació: " + comunicacio
                + ", Condició Física: " + condicioFisica + ", Correu Electronic: " + correu.getCorreu() + ", Data Naixament: " + dataNaixament
                + ", DNI: " + dni.getDni() + ", Edat: " + edat + ", Nom: " + nom + ", Genere: " + sexe + ", Tel: " + telefon.getTelefono();
    }


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

        System.out.println("Indica DNI que vols consultar");
        
        String dni = entradateclat.nextLine();

        Client client = consultaClientBD(dni);

        if (client != null) {

            System.out.println(client);

        }else{
            System.out.println("Elclient consultat no existeix");
        }


        entradateclat.close();

    }

    
    private Client consultaClientBD(String dni) throws SQLException {

        ConexioBD bd= new ConexioBD();
        Connection con = bd.conBD();

        String consulta = "SELECT * FROM clients where DNI = ?";

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
            CompteBancari CCC = new CompteBancari();

            String ccc;

            do{

                System.out.println("Introdueix el CCC delcompte bancari");
                ccc = entradateclat.next();

            }while(!CCC.validarCCC(ccc));

            CCC.setCCC(ccc);
            setCompteBancari(CCC);


            // Entrada Comunicació
            // #######################################################################|

            System.out.println("Entra la condició física que presenta el Client");

            this.comunicacio = entradateclat.nextBoolean();


            // Entrada Condició Fiscia
            // #######################################################################|
            System.out.println("Entra la condició física que presenta el Client");

            this.condicioFisica = entradateclat.nextLine();

            altaClientBD();
            
        }

        entradateclat.close();

    }

    private void altaClientBD(){

        ConexioBD bd= new ConexioBD();
        Connection con = bd.conBD();

        String consulta = "INSERT INTO Clients VALUES (?, ?, ? , ?, ?, ?, ?, ?, ?)";

        try {

            PreparedStatement ps = con.prepareStatement(consulta);

            cargarDadesDeClientASentencia(ps);
    
            ps.execute();
            
        } catch (Exception e) {

            System.out.println("Error al llançar la comanda de alta a la base de dades");

        }

    }

    private void baixaClient(){

        Scanner entradateclat = new Scanner(System.in);

        System.out.println("Indica el DNI del client que vols donar de baixa");
        String dni = entradateclat.nextLine();

        try {

            Client c = consultaClientBD(dni);

            if(c != null){
                boolean baixa = comprovacioBaixa(dni);
    
                if (baixa) {
                    baixaClientBD(dni);
                    System.out.println("El clietn s'ha donat de baixa");
                }else{
                    System.out.println("El client ja esta donat de baixa");
                }
    
            }else{
                System.out.println("El client no existeix a la base de dades");
            }
            
        } catch (Exception e) {
            System.out.println("Error al compreovar la baixa del client");
        }


            
    }

    private void baixaClientBD(String dni){

        ConexioBD bd= new ConexioBD();
        Connection con = bd.conBD();

        String consulta = "UPDATE registres set Data_Baixa = localtime() where DNI = ?";


        try {

            PreparedStatement ps = con.prepareStatement(consulta);
            ps.setString(1, dni);
            ps.execute();
            
        } catch (Exception e) {

            System.out.println("Error al llançar la comanda de baixa a la base de dades");

        }


    }

    private boolean comprovacioBaixa(String dni){

        ConexioBD bd= new ConexioBD();
        Connection con = bd.conBD();

        String consulta= "SELECT * FROM Registres where DNI = ?";

        try{

            PreparedStatement ps = con.prepareStatement(consulta);

            ps.setString(1, dni);

            ResultSet rs = ps.executeQuery();


            while(rs.next()) {

                if(rs.getDate("Data_Baixa")== null){
                    return true;
                }
    
            }

        } catch (Exception e) {

            System.out.println("Error al comprovar el client de baixa a la base de dades");
            
        }

        return false;
        
    }

    private void calcularEdat(){

        LocalDate avui = LocalDate.now();
        this.edat = Period.between(dataNaixament, avui).getYears();

    }

    
    public ArrayList<Client> getClientsOrdCognoms() throws SQLException{

        ArrayList<Client> clients = new ArrayList<>();

        ConexioBD bd= new ConexioBD();
        Connection con = bd.conBD();

        String consulta ="SELECT * from clients order by Cognom";

        PreparedStatement sentencia = con.prepareStatement(consulta);

        ResultSet rs = sentencia.executeQuery();

        try {

            while(rs.next()){
                Client cl = new Client();
                cl.cargarDadesDeSenteciaAClient(rs);
                clients.add(cl);
            }
            
        } catch (Exception e) {

            System.out.println("Error al Cargar els clients ordenats en Cognom");
        }

        return clients;

    }

    public ArrayList<Client> getClientsOrdEdat() throws SQLException{

        ArrayList<Client> clients = new ArrayList<>();

        ConexioBD bd= new ConexioBD();
        Connection con = bd.conBD();

        String consulta ="SELECT * from clients order by Data_naixement";
        PreparedStatement sentencia = con.prepareStatement(consulta);

        ResultSet rs = sentencia.executeQuery();

        try {

            while(rs.next()){
                Client cl = new Client();
                cl.cargarDadesDeSenteciaAClient(rs);
                clients.add(cl);
            }
            
        } catch (Exception e) {
            System.out.println("Error al Cargar els clients ordenats per edat");
        }
        return clients;

    }

    public ArrayList<Client> getClientsOrdReserves() throws SQLException{

        ArrayList<Client> clients = new ArrayList<>();

        ConexioBD bd= new ConexioBD();
        Connection con = bd.conBD();

        String consulta ="SELECT C.*,count(R.id_act) FROM reserva R right join clients C on R.DNI = C.DNI GROUP BY R.dni ORDER BY count(R.id_act) desc";
        PreparedStatement sentencia = con.prepareStatement(consulta);

        ResultSet rs = sentencia.executeQuery();

        try {

            while(rs.next()){
                Client cl = new Client();
                cl.cargarDadesDeSenteciaAClient(rs);
                clients.add(cl);
            }
            
        } catch (Exception e) {
            System.out.println("Error al Cargar els clients ordenats en Reserves");
        }


        return clients;

    }


    // Mapeig (Entarda de BDD a OBJ)
    // #######################################################################|
    private void cargarDadesDeSenteciaAClient(ResultSet rs) throws SQLException {

        this.setDni(new Dni(rs.getString("DNI")));
        this.setNom(rs.getString("Nom"));
        this.setCognom(rs.getString("Cognom"));
        this.setDataNaixament(rs.getDate("Data_naixement").toLocalDate());
        this.setTelefon(new Telefon(rs.getString("Tel")));
        this.setCorreu(new CorreuElectronic(rs.getString("Correu_e")));
        this.setSexe(rs.getString("Sexe"));
        this.setCondicioFisica(rs.getString("Condicio_Fisica"));
        this.setComunicacio(rs.getBoolean("Comunicació_comercial"));
        calcularEdat();


    }


    // Mapeig (Sortida de OBJ a BDD)
    // #######################################################################|
    private void cargarDadesDeClientASentencia(PreparedStatement ps) throws SQLException {

        ps.setString(1, this.dni.getDni());
        ps.setString(2, nom);
        ps.setString(3, cognom);
        ps.setString(4, dataNaixament.toString());
        ps.setString(5, this.telefon.getTelefono());
        ps.setString(6, this.correu.getCorreu());
        ps.setString(7, sexe);
        ps.setString(8, condicioFisica);
        ps.setBoolean(9, comunicacio);

    }

}
