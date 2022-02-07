package progettinoingsoftware;

import java.util.ArrayList;

public class Impresa {
    
    private String nome;
    private ArrayList<Operaio> operai = new ArrayList<>();
    private ArrayList<Cantiere> cantieri = new ArrayList<>();
    private boolean disponibile = true;

    public Impresa(String nome) {
        this.nome = nome;
    }

    public Impresa(String nome, ArrayList<Operaio> operai){
        this.nome = nome;
        this.operai = operai;
    }
    
    public void stampaOperaiDisponibili(){
        boolean flag = true;
        for(int i=0; i<operai.size(); i++){
            if(operai.get(i).disponibile()){
                operai.get(i).stampaInfo();
                System.out.println();
                flag = false;
            }
        }
        
        if(flag){
            System.out.println("Non ci sono Operai Disponibili");
            System.out.println();
        }
    }
    
    public void stampaOperai(){
        
        for(int i=0; i<operai.size(); i++){
            if(operai.get(i).disponibile()){
                operai.get(i).stampaInfo();
                System.out.println();
            }
        }
    }
    
    public void assumiOperaio(Operaio o){
        operai.add(o);
    }
    
    public void licenziaOperaio(int index){
        if(index < 0 || index >= operai.size()){
            System.out.println("L'operaio Selezionato non esiste");
        } else {
            operai.remove(index);
        }     
    }
    
    public int getOperaiDisponibili(){
        int num = 0;
        for(int i=0; i<operai.size(); i++){
            if(operai.get(i).disponibile()){
                operai.get(i).stampaInfo();
                System.out.println();
                num++;
            }
        }
        return num;
    }
    
    public ArrayList<Operaio> scegliOperai(int numero){
        ArrayList<Operaio> operaiScelti = new ArrayList<>();
        int scelti = 0;
        
        for(int i=0; scelti < numero; i++){
            if(operai.get(i).disponibile()){
                operaiScelti.add(operai.get(i));
                scelti++;
            }
        }
        return operaiScelti;
    }
    
    public void iniziaLavoro(Condominio c){
        int numUnita = c.getTotaleUnita();
        if(numUnita / 3 > getOperaiDisponibili()){
            System.out.println("Non ci sono abbastanza operai per iniziare il cantiere");
        } else {
            ArrayList<Operaio> operaiScelti = scegliOperai(numUnita / 3);
            Cantiere cantiere = new Cantiere(operaiScelti, new Data());
            cantieri.add(cantiere);
        }
    }
}
