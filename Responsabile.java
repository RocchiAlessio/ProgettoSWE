package progettinoingsoftware;

public class Responsabile extends Persona{

    public Responsabile(String nome, String cognome, Mediator azienda) {
        super(nome, cognome, azienda);
    }
    
    public void consultaRichieste(){
        azienda.consultaRichieste();
    }
    
    public void revisionaRichiesta(int index, boolean b){
        azienda.revisionaRichiesta(index, b);
    }
    
    public void consultaSopralloghi(){
        azienda.consultaSopralluoghi();
    }
}
