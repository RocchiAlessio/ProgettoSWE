package progettinoingsoftware.UseExample;
import progettinoingsoftware.*;

/**
 *
 * @author Alessio Rocchi
 */

// Un'Impresa con 3 operai riceve 2 richieste ed inizia il lavoro sul condominio specificato dalla prima
// e poi prova a iniziare un lavoro sul condominio della seconda non riuscendoci per la mancanza di personale
// disponibileù

public class Example_2 {
     public static void main(String[] args) {
         
        Impresa imp = new Impresa("Example.spa");
        Operaio o1 = new Operaio("Example", "1");
        Operaio o2 = new Operaio("Example", "2");
        Operaio o3 = new Operaio("Example", "3");
        
        Condominio c1 = new Condominio("Example 4", 10, 9, 2, 2);
        Condominio c2 = new Condominio("Example 5", 10, 9, 2, 2);
        
        imp.assumiOperaio(o1);
        imp.assumiOperaio(o2);
        imp.assumiOperaio(o3);
        
        // All'azienda arriva una richiesta per il Condominio Example 4 e 5
        imp.aggiungiRichiesta(c1);
        imp.aggiungiRichiesta(c2);
        
        // L'azienda visualizza i suoi operai disponibili
        System.out.println("Operai disponibili prima del Inizio del lavoro: ");
        imp.stampaOperaiDisponibili();
        
        // L'azienda inizia un lavoro sulla prima richiesta di lavoro e poi visualizza
        // gli operai disponibili
        imp.iniziaLavoro(0);
        System.out.println("Operai disponibili a lavoro in corso: ");
        imp.stampaOperaiDisponibili();
        
        // Prova ad aprire un altro cantiere fallendo e ricevendo il messaggio di errore
        System.out.println("Prova ad iniziare un altro cantiere: ");
        imp.iniziaLavoro(0);
        
        // L'azienda visualizza i cantieri attivi
        System.out.println("Cantieri attivi: ");
        imp.stampaCantieriAttivi();
        
     }
}
