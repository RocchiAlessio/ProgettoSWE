package progettinoingsoftware;

import java.util.ArrayList;

public class Cantiere {
    
    private ArrayList<Operaio> operaiCoinvolti = new ArrayList<>();
    private Condominio condominio;
    private Data dataInizio;
    private Data dataFine;
    private boolean attivo = true;

    public Cantiere(ArrayList<Operaio> operaiCoinvolti, Condominio condominio, Data dataInizio) {
        this.operaiCoinvolti = operaiCoinvolti;
        this.condominio = condominio;
        this.dataInizio = dataInizio;
    }
    
    public ArrayList<Operaio> getOperaiCoinvolti(){
        return operaiCoinvolti;
    }
    
    public boolean attivo(){
        return attivo;
    }
    
    public void terminaCantiere(){
        attivo = false;
        dataFine = new Data();
    }
    
    public void stampaInfo(){
        System.out.println("Cantiere su: ");
        condominio.stampaInfo();
        System.out.print("dal ");
        dataInizio.stampaInfo();
        if(attivo){
            System.out.println("Ancora in corso");
        } else {
            System.out.print("al ");
            dataFine.stampaInfo();
        }
        System.out.println();
    }
}
