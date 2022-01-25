package progettinoingsoftware;

import java.util.ArrayList;

public class Sopralluogo {
    
    private Tecnico tecnico;
    private Condominio condominio;
    private Data data;
    private ArrayList<Foto> foto = new ArrayList<>();
    private boolean offerta = false;

    public Sopralluogo(Tecnico tecnico, Condominio condominio, Data data, ArrayList<Foto> foto) {
        this.tecnico = tecnico;
        this.condominio = condominio;
        this.data = data;
        this.foto = foto;
    }
    
    public void stampaInfo(){
        System.out.print("Sopralluogo effettuato in data: ");
        data.stampaInfo();
        System.out.print("sul condominio: ");
        condominio.stampaInfo();
        System.out.println("dal tecnico: ");
        tecnico.stampaInfo();
    }
    
    public void setOfferta(){
        this.offerta = true;
    }
    
    public boolean offerta(){
        return offerta;
    }
    
    public Condominio getCondominio(){
        return condominio;
    }
}
