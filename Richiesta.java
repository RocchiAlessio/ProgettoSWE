package progettinoingsoftware;

public class Richiesta {

    private Amministratore amministratore;
    private Condominio condominio;
    private boolean accettata = false;
    private boolean revisionata = false;

    public Richiesta(Amministratore amministratore, Condominio condominio) {
        this.amministratore = amministratore;
        this.condominio = condominio;
    }

    public void revisiona(boolean b){
        accettata = b;
        revisionata = true;
    }
    
    public boolean accettata() {
        return accettata;
    }

    public boolean revisionata() {
        return revisionata;
    }

    public Amministratore getAmministratore(){
        return amministratore;
    }
    
    public Condominio getCondominio(){
        return condominio;
    }
    
    public void stampaInfo() {
        condominio.stampaInfo();
        if (accettata) {
            System.out.println("Accettata");
        }
        if (revisionata) {
            System.out.println("Revisionata");
        }
    }
}
