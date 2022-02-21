package progettinoingsoftware;

import java.util.ArrayList;

public class Azienda extends Mediator {

    private static Azienda istanza;                                             //per il pattern Singleton
    
    private ArrayList<Tecnico> tecnici = new ArrayList<>();
    private Responsabile responsabile;
    private ArrayList<Amministratore> amministratori = new ArrayList<>();

    // per una sorta di DB
    private ArrayList<Richiesta> richieste = new ArrayList<>();
    private ArrayList<Sopralluogo> sopralluoghiEffettuati = new ArrayList<>();
    private ArrayList<Offerta> offerte = new ArrayList<>();
    private ArrayList<Impresa> imprese = new ArrayList<>();

    private Azienda(String nome) {
        super(nome);
    }
    
    public static Azienda getIstanza() {
        if(istanza == null){
            istanza = new Azienda("Azienda.srl");
        }
        return istanza;
    }
    
    public void cancellaIstanza(){                                              // utilizzato per testare il Singleton
        istanza = null;                                                         // se non utilizzato da errore quando si
    }                                                                           // eseguono test in cascata perchè rimane
                                                                                // l'istanza attiva attraverso i test

    //Aggiungiamo i valori al semi DB
    public void assumiResponsabile(Responsabile r) {
        responsabile = r;
    }
    
    public Responsabile getResponsabile(){
        return responsabile;
    }

    public void aggiungiTecnico(Tecnico t) {
        tecnici.add(t);
    }
    
    public ArrayList<Tecnico> getTecnici(){
        return tecnici;
    }

    private void aggiungiAmministratore(Amministratore a) {
        amministratori.add(a);
    }
    
    public void aggiungiImpresa(Impresa i) {
        imprese.add(i);
    }
    
    public ArrayList<Richiesta> getRichieste(){
        return richieste;
    }
    
    public ArrayList<Offerta> getOfferte(){
        return offerte;
    }
    
    public ArrayList<Sopralluogo> getSopralluoghi(){
        return sopralluoghiEffettuati;
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

    // pattern Mediator
    // per Amministratore
    
    @Override
    public void generaRichiesta(Condominio c, Amministratore a) {

        if (!amministratori.contains(a)) {
            aggiungiAmministratore(a);
            richieste.add(new Richiesta(a, c));
        } else {
            if (!verificaSeEsiste(a, c)) {
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
            System.out.println();
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
            System.out.println();
        }
    }

    @Override
    public void revisionaOfferta(Amministratore a, Condominio c, boolean b) {
        for (int i = 0; i < offerte.size(); i++) {
            Offerta o = offerte.get(i);
            if (!o.revisionata() && o.getAmministratore() == a && o.getCondominio() == c) {
                o.setRevisionata();
                o.setAccettata(b);
            }
        }
    }

    // per Responsabile
    @Override
    public void consultaRichieste() {

        boolean flag = true;

        for (int i = 0; i < richieste.size(); i++) {
            if (richieste.get(i).revisionata() == false) {
                flag = false;
                System.out.println("Richiesta numero: " + i);
                richieste.get(i).stampaInfo();
                System.out.println();
            }
        }
        if (flag) {
            System.out.println("Non ci sono richieste da revisionare");
            System.out.println();
        }
    }

    @Override
    public void consultaTutteRichieste() {
        for (int i = 0; i < richieste.size(); i++) {
            System.out.println("Richiesta numero: " + i);
            richieste.get(i).stampaInfo();
            System.out.println();
        }
    }

    @Override
    public void revisionaRichiesta(int index, boolean b) {
        if (index < 0 || index > richieste.size()) {
            System.out.println("La richiesta selezionata non esiste");
            System.out.println();
        } else {
            if (richieste.get(index).revisionata()) {
                System.out.println("La richiesta selezionata è già stata revisionata");
            } else {
                richieste.get(index).revisiona(b);
                if (b) {
                    tecnici.get(selectTecnico()).aggiungiRichiestaSopralluogo(richieste.get(index).getCondominio());
                }
            }
        }
    }

    @Override
    public void consultaSopralluoghi() {

        boolean flag = true;

        for (int i = 0; i < sopralluoghiEffettuati.size(); i++) {
            if (sopralluoghiEffettuati.get(i).offerta() == false) {
                flag = false;
                System.out.println("Sopralluogo numero: " + i);
                sopralluoghiEffettuati.get(i).stampaInfo();
                System.out.println();
            }
        }
        if (flag) {
            System.out.println("Non sono stati effettuati altri sopralluoghi");
            System.out.println();
        }
    }

    @Override
    public void consultaTuttiSopralluoghi() {
        for (int i = 0; i < sopralluoghiEffettuati.size(); i++) {
            System.out.println("Sopralluogo numero: " + i);
            sopralluoghiEffettuati.get(i).stampaInfo();
            System.out.println();
        }
    }

    @Override
    public void faiOfferta(int index, int valoreOfferta) {
        if (index < 0 || index >= sopralluoghiEffettuati.size()) {
            System.out.println("Il sopralluogo selezionato non esiste");
            System.out.println();
        } else {
            if (sopralluoghiEffettuati.get(index).offerta()) {
                System.out.println("E' gia' stata effettuata un offerta relativa a questo sopralluogo");
            } else {
                Offerta offerta = new Offerta(sopralluoghiEffettuati.get(index).getCondominio(),
                        sopralluoghiEffettuati.get(index).getCondominio().amministratore, valoreOfferta);
                offerte.add(offerta);
                sopralluoghiEffettuati.get(index).getCondominio().amministratore.aggiungiOfferta(offerta);
                sopralluoghiEffettuati.get(index).setOfferta();
            }
        }
    }
    
    @Override
    public void consultaOfferte(){
        for (int i = 0; i < offerte.size(); i++) {
            System.out.println("Offerta numero: " + i);
            offerte.get(i).stampaInfo();
            System.out.println();
        }
    }
    
    @Override
    public void consultaImprese() {
        for (int i = 0; i < imprese.size(); i++) {
            System.out.println("Impresa numero: " + i);
            imprese.get(i).stampaInfo();
            System.out.println();
        }
    }
    
    @Override
    public void commissionaLavoro(int offIndex, int impIndex) {
        if(offIndex >= 0 && offIndex < offerte.size()){                                    
            if(offerte.get(offIndex).revisionata() && offerte.get(offIndex).accettata()){   //controllo se è revisionata e accettata
                if(impIndex >= 0 && impIndex < imprese.size()){
                    
                    imprese.get(impIndex).aggiungiRichiesta(offerte.get(offIndex).getCondominio()); //qua fa effettivamente il lavoro
                    
                } else {
                    System.out.println("L'impresa selezionata non esiste");
                    System.out.println();
                }
            } else {
                System.out.println("L'offerta selezionata non è valida");
                System.out.println();
            }
        } else {
            System.out.println("L'offerta selezionata non è valida");
            System.out.println();
        }
    }

    // per Tecnico
    private int selectTecnico() {
        int index = (int) Math.random() * tecnici.size();
        return index;
    }

    @Override
    public void inviaResponsoSopralluogo(Sopralluogo s) {
        sopralluoghiEffettuati.add(s);
    }

}
