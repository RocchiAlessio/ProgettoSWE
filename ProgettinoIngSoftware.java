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
        Condominio c = new Condominio("Strutti 420", 10, 2, 2, 2, amm);
        Condominio c2 = new Condominio("Smarmelli 69", 69, 69, 69, 4690, amm);
        
        Impresa imp = new Impresa("AsbrubaliniMammoliniCarinini.srl.spa.ru.uk");
        Operaio o1 = new Operaio("Alino", "Brutti");
        Operaio o2 = new Operaio("Alano", "Strutti");
        Operaio o3 = new Operaio("Alieno", "Sbratti");
        
        imp.assumiOperaio(o1);
        imp.assumiOperaio(o2);
        imp.assumiOperaio(o3);
        
        amm.aggiungiCondominio(c);
        amm.aggiungiCondominio(c2);
        
        //amm.stampaCondomini();
        
        amm.faiRichiesta(0);
        amm.faiRichiesta(0);
        amm.faiRichiesta(1);
        
        //r.consultaRichieste();
        
        r.revisionaRichiesta(0, true);
        
        r.revisionaRichiesta(1, true);
        
        //t1.consultaRichieste();
        
        //amm.consultaRichieste();
        
        t1.faiSopralluogo(0);
        t1.faiSopralluogo(0);           //Perchè le richieste poi vengono tolte dalla coda quindi quando si fa 0
                                        //la 1 scala in posizione 0
        
        //amm.consultaOfferte();
        
        //r.consultaSopralluoghi();
        
        r.faiOfferta(0, 1000);
        r.faiOfferta(1, 2000);
        
        //r.consultaSopralluoghi();
        
        //amm.consultaOfferte();
        
        amm.revisionaOfferta(0, true);
        amm.revisionaOfferta(1, false);
        
        //amm.consultaTutteOfferte();
        
        //System.out.println("Vediamo se sono sincronizzate anche con il Responsabile:");
        //System.out.println();
        
        //r.consultaOfferte();
        
        
        imp.iniziaLavoro(c);
        
    }
    
}
