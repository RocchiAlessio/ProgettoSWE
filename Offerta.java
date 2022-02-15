package progettinoingsoftware;

public class Offerta {
    
    private Condominio condominio;
    private Amministratore amministratore;
    private int offerta;
    private boolean accettata = false;
    private boolean revisionata = false;

    public Offerta(Condominio condominio, Amministratore amministratore, int offerta) {
        this.condominio = condominio;
        this.amministratore = amministratore;
        this.offerta = offerta;
    }
    
    public void stampaInfo(){
        System.out.println("sul Condominio: ");
        condominio.stampaInfo();
        System.out.println("Amministrato da: ");
        amministratore.stampaInfo();
        System.out.println("di valore: € " + offerta);
        if(revisionata){
            System.out.println("Revisionata");
            if(accettata){
                System.out.println("Accettata");
            } else {
                System.out.println("Non Accettata");
            }
        }
    }
    
    public boolean revisionata(){
        return revisionata;
    }
    
    public void setRevisionata(){
        this.revisionata = true;
    }
    
    public void setAccettata(boolean b){
        this.accettata = b;
    }
    
    public boolean accettata(){
        return accettata;
    }
    
    public Amministratore getAmministratore(){
        return amministratore;
    }
    
    public Condominio getCondominio(){
        return condominio;
    }
}
