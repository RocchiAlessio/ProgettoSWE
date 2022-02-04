package progettinoingsoftware;

public class Condominio {
    
    private String via;
    private int numCondomini;
    private int UA;
    private int UC;
    private int garage;
    Amministratore amministratore;

    public Condominio(String via, int numCondomini, int UA, int UC, int garage, Amministratore amministratore) {
        this.via = via;
        this.numCondomini = numCondomini;
        this.UA = UA;
        this.UC = UC;
        this.garage = garage;
        this.amministratore = amministratore;
    }
    
    public void stampaInfo() {
        System.out.println("Condominio in via " + via + " con: ");
        System.out.println(" - numero condomini = " + numCondomini);
        System.out.println(" - unita abitative = " + UA);
        System.out.println(" - unita commerciali = " + UC);
        System.out.println(" - numero garage = " + garage);
    }
    
    public int getTotaleUnita(){
        return UA + UC;
    }
}
