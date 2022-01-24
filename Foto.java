package progettinoingsoftware;

public class Foto {
    
    private Data data;

    public Foto(Data data) {
        this.data = data;
    }
    
    public void stampaInfo(){
        System.out.println("effettuata in data: ");
        data.stampaInfo();
    }
}
