package progettinoingsoftware;

public class ProgettinoIngSoftware {

    public static void main(String[] args) {
        
        Azienda a = Azienda.getIstanza();
        Responsabile r = new Responsabile("RespMain", "Main", a);
        a.assumiResponsabile(r);
        Tecnico t1 = new Tecnico("TecnMain", "1", a);
        Tecnico t2 = new Tecnico("TecnMain", "2", a);
        a.aggiungiTecnico(t1);
        a.aggiungiTecnico(t2);
        
        Amministratore amm = new Amministratore("AmmMain", "Main", a);
        Condominio c = new Condominio("CondMain 1", 10, 9, 2, 2, amm);
        Condominio c2 = new Condominio("CondMain 2", 50, 10, 10, 10, amm);
        
        Impresa imp = new Impresa("ImpMain.spa");
        Operaio o1 = new Operaio("OpMain", "1");
        Operaio o2 = new Operaio("OpMain", "2");
        Operaio o3 = new Operaio("OpMain", "3");
        
        a.aggiungiImpresa(imp);
        
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
        amm.revisionaOfferta(1, true);
        
        //amm.consultaTutteOfferte();
        
        //System.out.println("Vediamo se sono sincronizzate anche con il Responsabile:");
        //System.out.println();
        
        //r.consultaOfferte();
        //r.consultaImprese();
        
        r.commissionaLavoro(0, 0);
        r.commissionaLavoro(1, 0);
         
        imp.consultaRichieste();  
        //imp.stampaOperai();
        
        imp.iniziaLavoro(0);
        imp.iniziaLavoro(1);
        
        //imp.stampaOperai();        
        
        //imp.terminaCantiere(0);
        
        //imp.stampaCantieri();
        
        imp.stampaOperaiDisponibili();
    }
    
}
