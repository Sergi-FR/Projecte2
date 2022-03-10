import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalTime;
import java.util.ArrayList;

public class Activitat {

    int id_act;
    String nom;
    LocalTime durada;
    LocalTime horaI;
    LocalTime horaFi;

    public Activitat(){

        durada = LocalTime.now();
        horaI = LocalTime.now();
        horaFi = LocalTime.now();

    }

    @Override
    public String toString() {
        return "Activitat [durada=" + durada + ", horaFi=" + horaFi + ", horaI=" + horaI + ", id_act=" + id_act
                + ", nom=" + nom + "]";
    }

    public ArrayList<Activitat> visalitzaActivitats(){
        ArrayList<Activitat> activitats = new ArrayList<>();

        ConexioBD bd = new ConexioBD();
        Connection con = bd.conBD();

        String consulta = "SELECT A.*,count(R.dni) FROM reserva R right join activitats A on R.id_act = A.ID_Act GROUP BY R.ID_Act ORDER BY count(R.DNI) desc";

        try {
            PreparedStatement ps = con.prepareStatement(consulta);

            ResultSet rs = ps.executeQuery();
    
            while (rs.next()) {
                Activitat a1 = new Activitat();
                a1.cargarDadesDeSentenciaEnActivitat(rs);
    
                activitats.add(a1);
            }
    
            return activitats;
            
        } catch (Exception e) {

            System.out.println("Error al realitzar la consulta a activitats");
            
        }
        return activitats;

    }

    // Mapeig
    // #######################################################################|
    private void cargarDadesDeSentenciaEnActivitat(ResultSet rs) {

        try {
            
            this.id_act = rs.getInt("ID_Act");
            this.nom = rs.getString("Descipció");
            this.durada = rs.getTime("Durada").toLocalTime();
            this.horaFi = rs.getTime("Hora_Fi").toLocalTime();
            this.horaI = rs.getTime("Hora_i").toLocalTime();

        } catch (Exception e) {

            System.out.println("Error al cargar les dades d'activitat");

        }
        


    }


    
}
