public class CorreuElectronic {

    private String correu;

    public CorreuElectronic() {
    }

    public CorreuElectronic(String correu) {
        this.correu = correu;
    }

    // Seters i Geters
    // #######################################################################|
    public String getCorreu() {
        return correu;
    }

    public void setCorreu(String correu) {
        this.correu = correu;
    }

    // Metodes
    // #######################################################################
    public boolean validarCorreu(String correu) {

        if (!correu.contains("@")) {
            System.out.println("Falet un @");
            return false;
        }

        if (!correu.contains(".")) {
            System.out.println("Falte un punt");
            return false;
        }

        return true;

    }
}
