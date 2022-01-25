package progettinoingsoftware;

import java.util.ArrayList;

public class Amministratore extends Persona {

    private ArrayList<Condominio> condominio = new ArrayList<>();
    private ArrayList<Offerta> offerte = new ArrayList<>();

    public Amministratore(String nome, String cognome, Mediator azienda) {
        super(nome, cognome, azienda);
    }

    public void aggiungiCondominio(Condominio c) {
        condominio.add(c);
    }

    public void aggiungiOfferta(Offerta o) {
        offerte.add(o);
    }

    public void stampaInfo() {
        System.out.println("Nome: " + nome);
        System.out.println("Cognome: " + cognome);
    }

    public void stampaCondomini() {
        for (int i = 0; i < condominio.size(); i++) {
            System.out.println("Numero " + i + " :");
            condominio.get(i).stampaInfo();
            System.out.println();
        }
    }

    public void faiRichiesta(int index) {
        if (index < 0 || index > condominio.size()) {
            System.out.println("Condominio selezionato non è valido");
        } else {
            azienda.generaRichiesta(condominio.get(index), this);
        }
    }

    public void consultaRichieste() {
        azienda.consultaRichieste(this);
    }

    public void consultaRichieste(int index) {
        azienda.consultaRichieste(condominio.get(index));
    }

    public void consultaOfferte() {

        int num = 0;

        for (int i = 0; i < offerte.size(); i++) {
            if (!offerte.get(i).revisionata()) {
                num++;
                System.out.println("Offerta numero " + i + ":");
                offerte.get(i).stampaInfo();
                System.out.println();
            }
        }

        if (num == 0) {
            System.out.println("Non ci sono nuove Offerte");
            System.out.println();
        }
    }

    public void consultaTutteOfferte() {
        for (int i = 0; i < offerte.size(); i++) {
            System.out.println("Offerta numero " + i + ":");
            offerte.get(i).stampaInfo();
            System.out.println();

        }
    }

    public void revisionaOfferta(int index, boolean accetto) {
        if (index < 0 || index >= offerte.size() || offerte.get(index).revisionata()) {
            System.out.println("L'offerta selezionata non è valida");
        } else {
            offerte.get(index).setAccettata(accetto);
            offerte.get(index).setRevisionata();
            // TODO metti che l'offerta risulta in quella maniera anche in azienda
        }
    }
}
