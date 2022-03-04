public class CompteBancari {

    private String CCC;

    
    //Seters i Geters
    //-----------------------------------|
    public String getCCC() {
        return CCC;
    }

    public void setCCC(String cCC) {
        CCC = cCC;
    }
    //-----------------------------------|





    //Constructors
    //-----------------------------------|
    public CompteBancari(){

    }

    public CompteBancari(String cCC) {
        CCC = cCC;
    }
    //-----------------------------------|

    public boolean validarCCC(){

        return true;

    }



}