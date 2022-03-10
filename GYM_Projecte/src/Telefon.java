public class Telefon {

    private String telefono;

    public Telefon(){

    }

    public Telefon(String telefono) {
        this.telefono = telefono;
    }

    // Seters i Geters
    // #######################################################################|
    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    


    // Validar Telefon
    // #######################################################################|
    public boolean validarTelefon(String telefono){

        if(telefono.length()!=9){

            System.out.println("El telefon ha de tenir 9 digits");
            return false;

        }else{

            for(int i=0; i<telefono.length();i++){

                if(!(telefono.charAt(i)>='0' && (telefono.charAt(i)<='9'))){

                    System.out.println("tots els digits han de ser numàrics");
                    return false;
                    
                }
            }
        }
        return true;


    }

    
}
