package progettinoingsoftware.UseExample;
import progettinoingsoftware.*;

/**
 *
 * @author Alessio Rocchi
 */

// Un tecnico riceve 2 Richieste di sopralluogo, a seguito delle 2 richieste del amministratore di condominio, 
// e ne effettua 1 quindi invia il responso del sopralluogo effettuato.

public class Example_1 {
    
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

        // Il Tecnico consulta le sue richieste
        System.out.println("Richieste di Sopralluogo: ");
        t1.consultaRichieste();
        
        // Il Responsabile consulta i sopralluoghi effettuati
        System.out.println("Sopralluoghi Effettuati: ");
        r.consultaSopralluoghi();
    }
}
