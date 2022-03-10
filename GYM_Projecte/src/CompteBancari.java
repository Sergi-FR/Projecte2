public class CompteBancari {

    private String CCC;

    public CompteBancari(){

    }

    public CompteBancari(String cCC) {
        CCC = cCC;
    }

    // Seters i Geters
    // #######################################################################
    public String getCCC() {
        return CCC;
    }

    public void setCCC(String cCC) {
        CCC = cCC;
    }

    // Metodes
    // #######################################################################
    public boolean validarCCC(){

        return true;

    }



}