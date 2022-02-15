package progettinoingsoftware;

public class Responsabile extends Persona{

    public Responsabile(String nome, String cognome, Mediator azienda) {
        super(nome, cognome, azienda);
    }
    
    public void consultaRichieste(){
        azienda.consultaRichieste();
    }
    
    public void consultaTutteRichieste(){
        azienda.consultaTutteRichieste();
    }
    
    public void revisionaRichiesta(int index, boolean b){
        azienda.revisionaRichiesta(index, b);
    }
    
    public void consultaSopralluoghi(){
        azienda.consultaSopralluoghi();
    }
    
    public void consultaTuttiSopralluoghi(){
        azienda.consultaTuttiSopralluoghi();
    }
    
    public void faiOfferta(int index, int valoreOfferta){
        azienda.faiOfferta(index, valoreOfferta);
    }
    
    public void consultaOfferte(){
        azienda.consultaOfferte();
    }
    
    public void consultaImprese(){
        azienda.consultaImprese();
    }
    
    public void commissionaLavoro(int offIndex, int impIndex){
        azienda.commissionaLavoro(offIndex, impIndex);
    }
}
