package progettinoingsoftware;

import java.util.ArrayList;

public class Azienda extends Mediator {

    private ArrayList<Tecnico> tecnici = new ArrayList<>();
    private Responsabile responsabile;
    private ArrayList<Amministratore> amministratori = new ArrayList<>();

    // per una sorta di DB
    private ArrayList<Richiesta> richieste = new ArrayList<>();

    public Azienda(String nome) {
        super(nome);
    }

    public void assumiResponsabile(Responsabile r) {
        responsabile = r;
    }

    public void aggiungiTecnico(Tecnico t) {
        tecnici.add(t);
    }

    private void aggiungiAmministratore(Amministratore a) {
        amministratori.add(a);
    }

    private boolean verificaSeEsiste(Amministratore a, Condominio c) {
        for (int i = 0; i < richieste.size(); i++) {
            if (richieste.get(i).getAmministratore() == a && richieste.get(i).getCondominio() == c
                    && !richieste.get(i).revisionata()) {
                return true;
            }
        }
        return false;
    }

    //pattern Mediator
    //per Amministratore
    @Override
    public void generaRichiesta(Condominio c, Amministratore a) {

        if (!amministratori.contains(a)) {
            aggiungiAmministratore(a);
            richieste.add(new Richiesta(a, c));
        } else {
            if(!verificaSeEsiste(a, c)){
                richieste.add(new Richiesta(a, c));
            }
        }
    }

    @Override
    public void consultaRichieste(Amministratore a) {
        int num = 0;

        for (int i = 0; i < richieste.size(); i++) {
            if (richieste.get(i).getAmministratore() == a) {
                num++;
                System.out.println("Richiesta numero: " + i);
                richieste.get(i).stampaInfo();
                System.out.println();
            }
        }
        if (num == 0) {
            System.out.println("Non ci sono richieste effettuate");
        }
    }

    @Override
    public void consultaRichieste(Condominio c) {
        int num = 0;

        for (int i = 0; i < richieste.size(); i++) {
            if (richieste.get(i).getCondominio() == c) {
                num++;
                System.out.println("Richiesta numero: " + i);
                richieste.get(i).stampaInfo();
                System.out.println();
            }
        }
        if (num == 0) {
            System.out.println("Non ci sono richieste effettuate per questo condominio");
        }
    }

    //per Responsabile
    @Override
    public void consultaRichieste() {

        int num = 0;

        for (int i = 0; i < richieste.size(); i++) {
            if (richieste.get(i).revisionata() == false) {
                num++;
                System.out.println("Richiesta numero: " + i);
                richieste.get(i).stampaInfo();
                System.out.println();
            }
        }
        if (num == 0) {
            System.out.println("Non ci sono richieste da revisionare");
        }
    }

    @Override
    public void revisionaRichiesta(int index, boolean b) {
        if (index < 0 || index > richieste.size()) {
            System.out.println("La richiesta selezionata non esiste");
        } else {
            if (richieste.get(index).revisionata()) {
                System.out.println("La richiesta selezionata è già stata revisionata");
            } else {
                richieste.get(index).revisiona(b);
            }
        }
    }

}
