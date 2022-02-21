package progettinoingsoftware;

import java.util.ArrayList;

public class Impresa {

    private String nome;
    private ArrayList<Operaio> operai = new ArrayList<>();
    private ArrayList<Cantiere> cantieri = new ArrayList<>();
    private ArrayList<Condominio> richieste = new ArrayList<>();

    public Impresa(String nome) {
        this.nome = nome;
    }

    public Impresa(String nome, ArrayList<Operaio> operai) {
        this.nome = nome;
        this.operai = operai;
    }
    
    public ArrayList<Operaio> getOperai(){
        return operai;
    }
    
    public ArrayList<Condominio> getRichieste(){
        return richieste;
    }
    
    public ArrayList<Cantiere> getCantieri(){
        return cantieri;
    }

    public void stampaInfo() {
        System.out.println(nome);
        System.out.println("con operai disponibili: " + getNumOperaiDisponibili());
    }

    //Metodi per il management degli operai
    public void assumiOperaio(Operaio o) {
        operai.add(o);
    }

    public void licenziaOperaio(int index) {
        if (index < 0 || index >= operai.size()) {
            System.out.println("L'operaio Selezionato non esiste");
        } else {
            operai.remove(index);
        }
    }

    public void stampaOperaiDisponibili() {
        boolean flag = true;
        for (int i = 0; i < operai.size(); i++) {
            if (operai.get(i).disponibile()) {
                System.out.println("Operaio numero " + i + ":");
                operai.get(i).stampaInfo();
                System.out.println();
                flag = false;
            }
        }

        if (flag) {
            System.out.println("Non ci sono Operai Disponibili");
            System.out.println();
        }
    }

    public void stampaOperai() {

        for (int i = 0; i < operai.size(); i++) {
            System.out.println("Operaio numero " + i + ":");
            operai.get(i).stampaInfo();
            System.out.println();
        }
    }

    public int getNumOperaiDisponibili() {
        int num = 0;
        for (int i = 0; i < operai.size(); i++) {
            if (operai.get(i).disponibile()) {
                num++;
            }
        }
        return num;
    }

    //Metodi per il management delle Richieste
    public void aggiungiRichiesta(Condominio c) {
        richieste.add(c);
    }

    public void consultaRichieste() {
        boolean flag = true;
        for (int i = 0; i < richieste.size(); i++) {
            System.out.println("Richiesta " + i + ":");
            richieste.get(i).stampaInfo();
            System.out.println();
            flag = false;
        }

        if (flag) {
            System.out.println("Non ci sono nuove richieste");
            System.out.println();
        }
    }

    //Metodi per il management dei cantieri
    private ArrayList<Operaio> scegliOperai(int necessari) {
        ArrayList<Operaio> operaiScelti = new ArrayList<>();
        int scelti = 0;
        for (int i = 0; scelti < necessari; i++) {
            if (operai.get(i).disponibile()) {
                scelti++;
                operai.get(i).setDisponibile(false);
                operaiScelti.add(operai.get(i));
            }
        }
        return operaiScelti;
    }

    public void iniziaLavoro(int index) {
        if (index < 0 || index >= richieste.size()) {
            System.out.println("La richiesta selezionata non esiste");
            System.out.println();
        } else {
            if (richieste.get(index).getTotaleUnita() / 3 > getNumOperaiDisponibili()) {
                System.out.println("Non ci sono abbastanza operai per iniziare un cantiere");
                System.out.println();
            } else {
                int necessari = (int) richieste.get(index).getTotaleUnita() / 3;
                ArrayList<Operaio> operai = scegliOperai(necessari);
                Cantiere cantiere = new Cantiere(operai, richieste.get(index), new Data());
                cantieri.add(cantiere);
            }
        }
    }

    public void stampaCantieri() {
        for (int i = 0; i < cantieri.size(); i++) {
            System.out.println("Cantiere " + i + ":");
            cantieri.get(i).stampaInfo();
            System.out.println();
        }
    }

    public void stampaCantieriAttivi() {
        boolean flag = true;
        for (int i = 0; i < cantieri.size(); i++) {
            if (cantieri.get(i).attivo()) {
                System.out.println("Cantiere " + i + ":");
                cantieri.get(i).stampaInfo();
                System.out.println();
                flag = false;
            }
        }
        if (flag) {
            System.out.println("Non ci sono cantieri attivi");
            System.out.println();
        }
    }

    public void terminaCantiere(int index) {
        if (index < 0 || index >= cantieri.size()) {
            System.out.println("Il cantieri selezionato non esiste");
            System.out.println();
        } else {
            if (!cantieri.get(index).attivo()) {
                System.out.println("Il cantieri selezionato non è in corso");
                System.out.println();
            } else {
                cantieri.get(index).terminaCantiere();
                ArrayList<Operaio> operaiCoinvolti = cantieri.get(index).getOperaiCoinvolti();

                for (int i = 0; i < operaiCoinvolti.size(); i++) {
                    for (int j = 0; j < operai.size(); j++) {
                        if (operai.get(j).equals(operaiCoinvolti.get(i))) {
                            operai.get(j).setDisponibile(true);
                        }
                    }
                }

            }
        }
    }
}
