package progettinoingsoftware;

import java.util.ArrayList;

public class Tecnico extends Persona {

    ArrayList<Condominio> richiesteSopralluogo = new ArrayList<>();

    public Tecnico(String nome, String cognome, Mediator azienda) {
        super(nome, cognome, azienda);
    }

    public void stampaInfo() {
        System.out.println("Nome: " + nome);
        System.out.println("Cognome: " + cognome);
    }

    public void aggiungiRichiestaSopralluogo(Condominio c) {
        richiesteSopralluogo.add(c);
    }

    public void consultaRichieste() {
        if (richiesteSopralluogo.size() == 0) {
            System.out.println("Non ci sono richieste di Sopralluogo");
            System.out.println();
        } else {
            for (int i = 0; i < richiesteSopralluogo.size(); i++) {
                System.out.println("Richiesta " + i + ":");
                richiesteSopralluogo.get(i).stampaInfo();
                System.out.println();
            }
        }
    }
    
    public void faiSopralluogo(int index){
        if (index >= richiesteSopralluogo.size() || index < 0){
            System.out.println("La richiesta selezionata non è valida");
            System.out.println();
        } else {
            int numFoto = (int) Math.random() * 10 + 10;
            ArrayList<Foto> foto = importaFoto(numFoto);
            Sopralluogo sopralluogo = new Sopralluogo(this, richiesteSopralluogo.get(index), new Data(), foto);
            azienda.inviaResponsoSopralluogo(sopralluogo);
            richiesteSopralluogo.remove(index);
        }
    }
    
    private ArrayList<Foto> importaFoto(int numFoto){
        ArrayList<Foto> foto = new ArrayList<>();
        for(int i=0; i<numFoto; i++){
            foto.add(new Foto(new Data()));
        }
        return foto;
    }
}
