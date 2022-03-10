import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class Gimnas {

    private String CIF;
    ArrayList<Client> clients;
    ArrayList<Activitat> activitats;
    ArrayList<Reserva> reserva;

    public void gestionarGimnas() {

        Scanner menuteclat = new Scanner(System.in);
        boolean sortirmenu=false;

        do{

            System.out.println("\nIntrodueix el numero de l'opció");
            System.out.println("|________________________________________________________________");

            System.out.println("|\t\t\t\t\t\t\t\t|");

            System.out.println("|\tMenu Gestio Gimnas\t\t\t\t\t|");

            System.out.println("|\t\t\t\t\t\t\t\t|");
            
            System.out.println("|\t\t1.- Gestio de Clients\t\t\t\t|");
            System.out.println("|\t\t2.- Visualitzar Clients per Criteris\t\t|");
            System.out.println("|\t\t3.- Visualitzar Activitats del dia\t\t|");
            System.out.println("|\t\t4.- Sortir\t\t\t\t\t|");

            System.out.println("|\t\t\t\t\t\t\t\t|");

            int opcio = menuteclat.nextInt();

            switch(opcio){

                case 1:
                    gestioClients();
                break;

                case 2:
                    visualitzarOrdClientMenu();
                break;

                case 3:
                    activitatsDiaries();
                break;

                case 4:
                sortirmenu=true;
                break;

                default:
                System.out.println("Opció no valida");

            }


        }while(!sortirmenu);

        menuteclat.close();
    }

    private void gestioClients(){

        Scanner menuteclat = new Scanner(System.in);
        boolean sortirmenu=false;

        do{

            System.out.println("\nIntrodueix el numero de l'opció");
            System.out.println("|________________________________________________________________");

            System.out.println("|\t\t\t\t\t\t\t\t|");

            System.out.println("|\tMenu Gestio Clients\t\t\t\t\t|");

            System.out.println("|\t\t\t\t\t\t\t\t|");
            
            System.out.println("|\t\t1.- Consulta Client\t\t\t\t|");
            System.out.println("|\t\t2.- Alta Client\t\t\t\t\t|");
            System.out.println("|\t\t3.- Donar de Baixa a un Client\t\t\t|");
            System.out.println("|\t\t4.- Modificar Client\t\t\t\t|");
            System.out.println("|\t\t5.- Sortir\t\t\t\t\t|");
            

            System.out.println("|\t\t\t\t\t\t\t\t|");

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
            System.out.println("Error al donar d'Alta l'usuari");
            e.printStackTrace();
        }
        
    }

    private void activitatsDiaries(){

        Activitat act = new Activitat();
        this.activitats = act.visalitzaActivitats();
        visualitzarActivitats();

    }

    private void visualitzarActivitats(){

        for(int i= 0; i<activitats.size();i++){

            System.out.println(activitats.get(i));

        }
        
    }


    private void visualitzarOrdClientMenu(){
        Scanner menuteclat = new Scanner(System.in);
        boolean sortirmenu=false;

        do{
            
            System.out.println("\nIntrodueix el numero de l'opció");
            System.out.println("|________________________________________________________________");

            System.out.println("|\t\t\t\t\t\t\t\t|");

            System.out.println("|\tMenu Gestio Clients\t\t\t\t\t|");

            System.out.println("|\t\t\t\t\t\t\t\t|");

            System.out.println("|\t\t1.- Ordenat per Cognoms\t\t\t\t|");
            System.out.println("|\t\t2.- Ordenat per Edat\t\t\t\t|");
            System.out.println("|\t\t3.- Ordenat per Reserves\t\t\t|");
            System.out.println("|\t\t4.- Sortir\t\t\t\t\t|");      

            System.out.println("|\t\t\t\t\t\t\t\t|");
            

            int opcio = menuteclat.nextInt();

            Client client = new Client();

            switch(opcio){

                case 1:
                    try {
                        this.clients= client.getClientsOrdCognoms();
                        visualitzarClients();
                    } catch (Exception e) {
                        System.out.println("Error al Visualitzar els Clients per Cognoms");
                    }
                break;

                case 2:
                    try {
                        this.clients= client.getClientsOrdEdat();
                        visualitzarClients();
                    } catch (Exception e) {
                        System.out.println("Error al Visualitzar els Clients per Edat");
                    }
                break;

                case 3:
                    try {
                        this.clients= client.getClientsOrdReserves();
                        visualitzarClients();
                    } catch (Exception e) {
                        System.out.println("Error al Visualitzar els Clients per Reserves");
                    }
                break;

                case 4:
                    sortirmenu=true;
                break;

                default:
                System.out.println("Opció no valida");

            }


        }while(!sortirmenu);

        menuteclat.close();
    }

 

    private void visualitzarClients(){

        for(int i= 0; i<clients.size();i++){

            int contador = i+1;

            System.out.println("Client Num." + contador + " " + clients.get(i));

        }

    }




}


