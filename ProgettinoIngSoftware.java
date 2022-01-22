package progettinoingsoftware;

public class ProgettinoIngSoftware {

    public static void main(String[] args) {
        
        Azienda a = new Azienda("Bruttoloni.org");
        Responsabile r = new Responsabile("Calogero", "Cartelli", a);
        a.assumiResponsabile(r);
        
        Amministratore amm = new Amministratore("Beppe", "Fracico", a);
        Condominio c = new Condominio("Strutti 420", 10, 5, 5, 420, amm);
        Condominio c2 = new Condominio("Strutti 69", 69, 69, 69, 4690, amm);
        
        amm.aggiungiCondominio(c);
        amm.aggiungiCondominio(c2);
        
        //amm.stampaCondomini();
        
        amm.faiRichiesta(0);
        amm.faiRichiesta(0);
        amm.faiRichiesta(1);
        
        //r.consultaRichieste();
        
        r.revisionaRichiesta(1, true);
        
        amm.consultaRichieste();
    }
    
}
