package progettinoingsoftware;

public class ProgettinoIngSoftware {

    public static void main(String[] args) {
        
        Azienda a = new Azienda("Bruttoloni.org");
        Responsabile r = new Responsabile("Calogero", "Cartelli", a);
        a.assumiResponsabile(r);
        Tecnico t1 = new Tecnico("Vladimiro", "Sterconi", a);
        Tecnico t2 = new Tecnico("Andrea", "Salamelli", a);
        a.aggiungiTecnico(t1);
        a.aggiungiTecnico(t2);
        
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
        
        r.revisionaRichiesta(0, true);
        
        //t1.consultaRichieste();
        //t2.consultaRichieste();
        
        //amm.consultaRichieste();
        
        t1.faiSopralluogo(0);
        t2.faiSopralluogo(0);
        
        amm.consultaOfferte();
        
        r.consultaSopralluoghi();
        
        r.faiOfferta(0, 1000);
        
        r.consultaSopralluoghi();
        
        amm.consultaOfferte();
        
        amm.revisionaOfferta(0, true);
        
        amm.consultaTutteOfferte();
    }
    
}
