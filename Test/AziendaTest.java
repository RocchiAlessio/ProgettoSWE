package progettinoingsoftware;

import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Alessio Rocchi
 */
public class AziendaTest {

    public AziendaTest() {
    }

    /**
     * Test of assumiResponsabile method, of class Azienda.
     */
    @Test
    public void testAssumiResponsabile() {
        Azienda a = new Azienda("Test.Test");
        Responsabile r = new Responsabile("Test", "Test", a);

        a.assumiResponsabile(r);
        assertEquals(r, a.getResponsabile());
    }

    /**
     * Test of aggiungiTecnico method, of class Azienda.
     */
    @Test
    public void testAggiungiTecnico() {
        Azienda a = new Azienda("Test.Test");
        Tecnico t1 = new Tecnico("Test", "Test", a);
        Tecnico t2 = new Tecnico("Test", "Test", a);

        a.aggiungiTecnico(t1);
        a.aggiungiTecnico(t2);
        ArrayList<Tecnico> expected = new ArrayList<>();
        expected.add(t1);
        expected.add(t2);
        ArrayList<Tecnico> actual = a.getTecnici();
        for (int i = 0; i < actual.size(); i++) {
            assertEquals(expected.get(i), actual.get(i));
        }
    }

    /**
     * Test of generaRichiesta method, of class Azienda.
     */
    @Test
    public void testGeneraRichiesta() {
        Azienda a = new Azienda("Test.Test");
        Amministratore amm = new Amministratore("Test", "Test", a);
        Condominio c = new Condominio("Test", 10, 9, 2, 2, amm);
        
        a.generaRichiesta(c, amm);
        ArrayList<Richiesta> richieste = a.getRichieste();
        assertEquals(richieste.get(0).getAmministratore(), amm);
        assertEquals(c, richieste.get(0).getCondominio());
    }

    /**
     * Test of revisionaOfferta method, of class Azienda.
     */
    @Test
    public void testRevisionaOfferta() {
        Azienda a = new Azienda("Test");
        Responsabile r = new Responsabile("Test", "Test", a);
        a.assumiResponsabile(r);
        Tecnico t1 = new Tecnico("Test", "Test", a);
        a.aggiungiTecnico(t1);
        
        Amministratore amm = new Amministratore("Test", "Test", a);
        Condominio c = new Condominio("Test", 10, 9, 2, 2, amm);
        
        amm.aggiungiCondominio(c);
        amm.faiRichiesta(0);
        
        r.revisionaRichiesta(0, true);
        
        t1.faiSopralluogo(0);
        
        r.faiOfferta(0, 1000);
        
        amm.revisionaOfferta(0, true);
        
        ArrayList<Offerta> offerte = a.getOfferte();
        assertEquals(true, offerte.get(0).revisionata());
        assertEquals(true, offerte.get(0).accettata());
        assertEquals(amm, offerte.get(0).getAmministratore());
        assertEquals(c, offerte.get(0).getCondominio());
    }

    /**
     * Test of revisionaRichiesta method, of class Azienda.
     */
    @Test
    public void testRevisionaRichiesta() {
        Azienda a = new Azienda("Test");
        Responsabile r = new Responsabile("Test", "Test", a);
        a.assumiResponsabile(r);
        Tecnico t1 = new Tecnico("Test", "Test", a);
        a.aggiungiTecnico(t1);
        
        Amministratore amm = new Amministratore("Test", "Test", a);
        Condominio c = new Condominio("Test", 10, 9, 2, 2, amm);
        
        amm.aggiungiCondominio(c);
        amm.faiRichiesta(0);
        
        r.revisionaRichiesta(0, true);
        
        ArrayList<Richiesta> richieste = a.getRichieste();
        assertEquals(true, richieste.get(0).revisionata());
        assertEquals(true, richieste.get(0).accettata());
        assertEquals(amm, richieste.get(0).getAmministratore());
        assertEquals(c, richieste.get(0).getCondominio());
    }

    /**
     * Test of faiOfferta method, of class Azienda.
     */
    @Test
    public void testFaiOfferta() {
        Azienda a = new Azienda("Test");
        Responsabile r = new Responsabile("Test", "Test", a);
        a.assumiResponsabile(r);
        Tecnico t1 = new Tecnico("Test", "Test", a);
        a.aggiungiTecnico(t1);
        
        Amministratore amm = new Amministratore("Test", "Test", a);
        Condominio c = new Condominio("Test", 10, 9, 2, 2, amm);
        
        amm.aggiungiCondominio(c);
        amm.faiRichiesta(0);
        
        r.revisionaRichiesta(0, true);
        
        t1.faiSopralluogo(0);
        
        r.faiOfferta(0, 1000);
        ArrayList<Offerta> offerte = a.getOfferte();
        assertEquals(false, offerte.get(0).revisionata());
        assertEquals(false, offerte.get(0).accettata());
        assertEquals(amm, offerte.get(0).getAmministratore());
        assertEquals(c, offerte.get(0).getCondominio());
        assertEquals(1000, offerte.get(0).getOfferta());
    }

    /**
     * Test of inviaResponsoSopralluogo method, of class Azienda.
     */
    @Test
    public void testInviaResponsoSopralluogo() {
        Azienda a = new Azienda("Test");
        Responsabile r = new Responsabile("Test", "Test", a);
        a.assumiResponsabile(r);
        Tecnico t1 = new Tecnico("Test", "Test", a);
        a.aggiungiTecnico(t1);
        
        Amministratore amm = new Amministratore("Test", "Test", a);
        Condominio c = new Condominio("Test", 10, 9, 2, 2, amm);
        
        amm.aggiungiCondominio(c);
        amm.faiRichiesta(0);
        
        r.revisionaRichiesta(0, true);
        
        t1.faiSopralluogo(0);
        
        ArrayList<Sopralluogo> sopralluoghi = a.getSopralluoghi();
        assertEquals(t1, sopralluoghi.get(0).getTecnico());
        assertEquals(c, sopralluoghi.get(0).getCondominio());
    }

}
