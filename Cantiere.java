package progettinoingsoftware;

import java.util.ArrayList;

public class Cantiere {
    
    private ArrayList<Operaio> operaiCoinvolti = new ArrayList<>();
    private Data dataInizio;
    private Data dataFine;
    private boolean aperto = true;

    public Cantiere(ArrayList<Operaio> operaiCoinvolti, Data dataInizio) {
        this.operaiCoinvolti = operaiCoinvolti;
        this.dataInizio = dataInizio;
    }
}
