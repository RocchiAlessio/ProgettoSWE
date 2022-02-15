package progettinoingsoftware;

public class Operaio extends Persona{

    private boolean disponibile = true;
    
    public Operaio(String nome, String cognome) {
        super(nome, cognome);
    }
    
    public void stampaInfo() {
        System.out.println("Nome: " + nome);
        System.out.println("Cognome: " + cognome);
        if(!disponibile)
            System.out.println("Non Disponibile");
    }
    
    public boolean disponibile(){
        return disponibile;
    }
    
    public void setDisponibile(boolean disp){
        this.disponibile = disp;
    }
}
