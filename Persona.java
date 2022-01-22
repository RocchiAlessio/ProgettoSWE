package progettinoingsoftware;

public abstract class Persona {
    
    protected String nome;
    protected String cognome;
    protected Mediator azienda;

    public Persona(String nome, String cognome, Mediator azienda) {
        this.nome = nome;
        this.cognome = cognome;
        this.azienda = azienda;
    }
}
