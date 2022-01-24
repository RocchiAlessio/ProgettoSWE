package progettinoingsoftware;

public abstract class Mediator {
    
    public String nome;

    public Mediator(String nome) {
        this.nome = nome;
    }
    
    //per Amministratore
    public abstract void generaRichiesta(Condominio c, Amministratore a);
    
    public abstract void consultaRichieste(Amministratore a);
    
    public abstract void consultaRichieste(Condominio c);
    
    
    // per il Responsabile
    public abstract void consultaRichieste();
    
    public abstract void consultaTutteRichieste();
    
    public abstract void revisionaRichiesta(int index, boolean b);
    
    public abstract void consultaSopralluoghi();
    
    // per il Tecnico
    public abstract void inviaResponsoSopralluogo(Sopralluogo s);
    
    
}
