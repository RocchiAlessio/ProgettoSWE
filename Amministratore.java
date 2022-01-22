package progettinoingsoftware;

import java.util.ArrayList;

public class Amministratore extends Persona {

    private ArrayList<Condominio> condominio = new ArrayList<>();
    
    public Amministratore(String nome, String cognome, Mediator azienda) {
        super(nome, cognome, azienda);
    }
    
    public void aggiungiCondominio(Condominio c){
        condominio.add(c);
    }
    
    public void stampaCondomini(){
        for(int i=0; i<condominio.size(); i++){
            System.out.println("Numero " + i + " :");
            condominio.get(i).stampaInfo();
            System.out.println();
        }
    }
    
    public void faiRichiesta(int index){
        if(index < 0 || index > condominio.size())
            System.out.println("Condominio selezionato non è valido");
        else
            azienda.generaRichiesta(condominio.get(index), this);
    }
    
    public void consultaRichieste(){
        azienda.consultaRichieste(this);
    }
    
    public void consultaRichieste(int index){
        azienda.consultaRichieste(condominio.get(index));
    }
}
