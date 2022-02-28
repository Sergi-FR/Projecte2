import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class Gimnas {

    private String nom;
    private String CIF;
    private String telefon;

    ArrayList<Client> clients;
    // ArrayList<Sala> Sales;

    public void gestionarGimnas() {

        Scanner menuteclat = new Scanner(System.in);
        boolean sortirmenu=false;

        do{

            System.out.println("\nIntrodueix el numero de l'opció");
            System.out.println("|________________________________________________");

            System.out.println("|\t\t\t\t\t\t|");

            System.out.println("|\tMenu Gestio Gimnas\t\t\t|");

            System.out.println("|\t\t\t\t\t\t|");
            
            System.out.println("|\t\t1.- Gestio de Clients\t\t|");
            System.out.println("|\t\t2.- Sortir\t\t\t|");

            System.out.println("|\t\t\t\t\t\t|");

            int opcio = menuteclat.nextInt();

            switch(opcio){

                case 1:
                    gestioClients();
                break;

                case 2:

                break;

                case 3:

                break;

                default:
                System.out.println("Opció no valida");

            }


        }while(!sortirmenu);

        menuteclat.close();
    }

    static void gestioClients(){

        Scanner menuteclat = new Scanner(System.in);
        boolean sortirmenu=false;

        do{


            System.out.println("\nIntrodueix el numero de l'opció");
            System.out.println("|________________________________________________");

            System.out.println("|\t\t\t\t\t\t|");

            System.out.println("|\tMenu Gestio Clients\t\t\t|");

            System.out.println("|\t\t\t\t\t\t|");

            System.out.println("|\t\t1.- Resgistre\t\t\t|");
            System.out.println("|\t\t2.- Sortir\t\t\t|");

            System.out.println("|\t\t\t\t\t\t|");

            int opcio = menuteclat.nextInt();

            switch(opcio){

                case 1:
                    consultaClients();
                break;

                case 2:
                    altaClients();
                break;

                case 3:
                    //baixaClients();
                break;

                case 4:
                    //modificarClients();
                break;

                case 5:
                    //visualitzarClients();
                break;

                case 6:
                    sortirmenu=true;
                break;


                default:
                System.out.println("Opció no valida");

            }


        }while(!sortirmenu);

        menuteclat.close();
    }

    private static void consultaClients() {

        Client c = new Client();
        try {
            c.consultaClient();
        } catch (SQLException e) {
            System.out.println("Error al Consultar el usuari");
            e.printStackTrace();
        }
        
    }

    private static void altaClients() {

        Client c = new Client();
        try {
            c.altaClient();
        } catch (SQLException e) {
            System.out.println("Error aldonar d'Alta l'usuari");
            e.printStackTrace();
        }
        
    }




}


