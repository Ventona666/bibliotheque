package Biblio;

public class Exemplaire {
    private String cote;
    private boolean emprunte = false;
    private String editeur;
    private int anneeParution;

    public Exemplaire(String cote, String editeur, int anneeParution){
        this.cote = cote;
        this.editeur = editeur;
        this.anneeParution = anneeParution;
    }

    public String getCote(){
        return this.cote;
    }

    public boolean isEmprunte(){
        return emprunte;
    }

    public void emprunter(){
        emprunte = true;
    }

    public void retourner(){
        emprunte = false;
    }

}
