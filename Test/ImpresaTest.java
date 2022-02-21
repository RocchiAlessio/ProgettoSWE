package progettinoingsoftware;

import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Alessio Rocchi
 */
public class ImpresaTest {
    
    public ImpresaTest() {
    }
    
    /**
     * Test of assumiOperaio method, of class Impresa.
     */
    @Test
    public void testAssumiOperaio() {
        Impresa imp = new Impresa("Test.spa");
        Operaio o1 = new Operaio("Test", "Test");
        
        imp.assumiOperaio(o1);
        ArrayList<Operaio> operai = imp.getOperai();
        assertEquals(operai.get(0), o1);
    }

    /**
     * Test of getOperaiDisponibili method, of class Impresa.
     */
    @Test
    public void testGetNumOperaiDisponibili() {
        Impresa imp = new Impresa("Test.spa");
        Operaio o1 = new Operaio("Test1", "Test");
        Operaio o2 = new Operaio("Test2", "Test");
        Operaio o3 = new Operaio("Test3", "Test");
        
        imp.assumiOperaio(o1);
        imp.assumiOperaio(o2);
        imp.assumiOperaio(o3);
        
        int actual = imp.getNumOperaiDisponibili();
        assertEquals(actual, 3);
    }

    /**
     * Test of aggiungiRichiesta method, of class Impresa.
     */
    @Test
    public void testAggiungiRichiesta() {
        Impresa imp = new Impresa("Test.spa");
        Operaio o1 = new Operaio("Test1", "Test");
        Operaio o2 = new Operaio("Test2", "Test");
        Operaio o3 = new Operaio("Test3", "Test");
        
        imp.assumiOperaio(o1);
        imp.assumiOperaio(o2);
        imp.assumiOperaio(o3);
        
        Condominio c = new Condominio("Test", 10, 9, 2, 2);
        imp.aggiungiRichiesta(c);
        ArrayList<Condominio> richieste = imp.getRichieste();
        assertEquals(c, richieste.get(0));
    }

    /**
     * Test of iniziaLavoro method, of class Impresa.
     */
    @Test
    public void testIniziaLavoro() {
        Impresa imp = new Impresa("Test.spa");
        Operaio o1 = new Operaio("Test1", "Test");
        Operaio o2 = new Operaio("Test2", "Test");
        Operaio o3 = new Operaio("Test3", "Test");
        
        imp.assumiOperaio(o1);
        imp.assumiOperaio(o2);
        imp.assumiOperaio(o3);
        
        Condominio c = new Condominio("Test", 10, 9, 2, 2);
        imp.aggiungiRichiesta(c);
        imp.iniziaLavoro(0);
        
        ArrayList<Cantiere> cantieri = imp.getCantieri();
        assertEquals(o1, cantieri.get(0).getOperaiCoinvolti().get(0));
        assertEquals(o2, cantieri.get(0).getOperaiCoinvolti().get(1));
        assertEquals(o3, cantieri.get(0).getOperaiCoinvolti().get(2));
        assertEquals(true, cantieri.get(0).attivo());
        assertEquals(false, o1.disponibile());
        assertEquals(false, o2.disponibile());
        assertEquals(false, o3.disponibile());
    }

    /**
     * Test of terminaCantiere method, of class Impresa.
     */
    @Test
    public void testTerminaCantiere() {
        Impresa imp = new Impresa("Test.spa");
        Operaio o1 = new Operaio("Test1", "Test");
        Operaio o2 = new Operaio("Test2", "Test");
        Operaio o3 = new Operaio("Test3", "Test");
        
        imp.assumiOperaio(o1);
        imp.assumiOperaio(o2);
        imp.assumiOperaio(o3);
        
        Condominio c = new Condominio("Test", 10, 9, 2, 2);
        imp.aggiungiRichiesta(c);
        imp.iniziaLavoro(0);
        imp.terminaCantiere(0);
        
        ArrayList<Cantiere> cantieri = imp.getCantieri();
        assertEquals(false, cantieri.get(0).attivo());
        assertEquals(true, o1.disponibile());
        assertEquals(true, o2.disponibile());
        assertEquals(true, o3.disponibile());
    }
    
}
