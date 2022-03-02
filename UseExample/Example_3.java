package progettinoingsoftware.UseExample;
import progettinoingsoftware.*;

/**
 *
 * @author Alessio Rocchi
 */

// Un Amministratore a seguito delle richieste fatte e dei sopralluoghi effettutati riceve 2 offerte, ne
// accetta una e rifiuta l'altra. Il responsabile in seguito può vedere che le sue offerte sono state valutate
// e che c'è stata una risposta.

public class Example_3 {
    public static void main(String[] args) {
        
        Azienda a = Azienda.getIstanza();
        Responsabile r = new Responsabile("Example", "Example", a);
        a.assumiResponsabile(r);
        Tecnico t1 = new Tecnico("Example", "Example", a);
        a.aggiungiTecnico(t1);
        
        Amministratore amm = new Amministratore("Example", "Example", a);
        Condominio c = new Condominio("Example 3", 10, 9, 2, 2, amm);
        Condominio c2 = new Condominio("Example 5", 10, 19, 40, 10, amm);
        amm.aggiungiCondominio(c);
        amm.aggiungiCondominio(c2);
        
        // L'amministratore fa richiesta per i suoi condomini
        amm.faiRichiesta(0);
        amm.faiRichiesta(1);
        
        // Il Responsabile accetta le due richieste e vengono mandate delle richieste di
        // sopralluogo al tecnico
        r.revisionaRichiesta(0, true);
        r.revisionaRichiesta(1, true);
        
        // Il Tecnico effettua il sopralluogo relativo alla seconda richiesta
        t1.faiSopralluogo(1);
        t1.faiSopralluogo(0);

        // Il Responsabile fa le offerte relative ai due sopralluoghi effettuati all'amministratore
        r.faiOfferta(0, 1000);
        r.faiOfferta(1, 2000);
        
        // L'amministratore visualizza le offerte fatte dal responsabile
        System.out.println("Offerte sui due condomini: ");
        amm.consultaOfferte();
        
        // L'amministratore ne accetta quella da 1000 € e rifiuta l'altra da 2000 €
        amm.revisionaOfferta(0, true);
        amm.revisionaOfferta(1, false);
        
        // Il responsabile vede che le due offerte sono state accettate/rifiutate
        System.out.println("Le Offerte visualizzate dal Responsabile: ");
        r.consultaOfferte();
    }
}
