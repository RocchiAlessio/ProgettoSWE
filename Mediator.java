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
    
    public abstract void revisionaOfferta(Amministratore a, Condominio c, boolean b);
    
    
    // per il Responsabile
    public abstract void consultaRichieste();
    
    public abstract void consultaTutteRichieste();
    
    public abstract void revisionaRichiesta(int index, boolean b);
    
    public abstract void consultaSopralluoghi();
    
    public abstract void consultaTuttiSopralluoghi();
    
    public abstract void faiOfferta(int index, int valoreOfferta);
    
    public abstract void consultaOfferte();
    
    // per il Tecnico
    public abstract void inviaResponsoSopralluogo(Sopralluogo s);
    
    
}
