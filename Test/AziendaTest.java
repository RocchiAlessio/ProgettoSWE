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
        Azienda a = new Azienda("Asdrubalini.sprla");
        Responsabile r = new Responsabile("Yulio", "Granello", a);

        a.assumiResponsabile(r);
        assertEquals(r, a.getResponsabile());
    }

    /**
     * Test of aggiungiTecnico method, of class Azienda.
     */
    @Test
    public void testAggiungiTecnico() {
        Azienda a = new Azienda("Asdrubalini.sprla");
        Tecnico t1 = new Tecnico("Yulio", "Granellicchio", a);
        Tecnico t2 = new Tecnico("Lallo", "Bellissimi", a);

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
        Azienda a = new Azienda("Asdrubalini.sprla");
        Amministratore amm = new Amministratore("Lello", "Scoliosi", a);
        Condominio c = new Condominio("Strutti 420", 10, 9, 2, 2, amm);
        
        a.generaRichiesta(c, amm);
        assertEquals(a.getRichieste().get(0).getAmministratore(), amm);
        assertEquals(a.getRichieste().get(0).getCondominio(), c);
    }

    /**
     * Test of revisionaOfferta method, of class Azienda.
     */
    @Test
    public void testRevisionaOfferta() {
        
    }

    /**
     * Test of revisionaRichiesta method, of class Azienda.
     */
    @Test
    public void testRevisionaRichiesta() {
    }

    /**
     * Test of faiOfferta method, of class Azienda.
     */
    @Test
    public void testFaiOfferta() {
    }

    /**
     * Test of inviaResponsoSopralluogo method, of class Azienda.
     */
    @Test
    public void testInviaResponsoSopralluogo() {
    }

}
