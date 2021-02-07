package Biblio;

public class Ouvrage {
    private int nbExemplaires = 0;
    private final int nbExemplaireMax;
    private String titre;
    private String auteur;
    private Exemplaire [] tabExemplaire;

    public Ouvrage(String titre, String auteur, int nbExemplaireMax){
        this.titre = titre;
        this.auteur = auteur;
        this.nbExemplaireMax = nbExemplaireMax;
        this.tabExemplaire = new Exemplaire [this.nbExemplaireMax];
    }

    public String getAuteur(){
        return auteur;
    }

    public String getTitre(){
        return titre;
    }

    public boolean ajouterExemplaire(String cote, String editeur, int anneeParution){
        if(this.nbExemplaires <= this.nbExemplaireMax){
            this.tabExemplaire[nbExemplaires] = new Exemplaire(cote, editeur, anneeParution);
            this.nbExemplaires ++;
            return true;
        }
        return false;
    }

    public String emprunter(){
        for(int i = nbExemplaires; i > 0; i--){
            if (!tabExemplaire[i-1].isEmprunte()){
                tabExemplaire[i-1].emprunter();
                return tabExemplaire[i-1].getCote();
            }
        }
        return "Plus d'exemplaire disponible !";
    }

    private Exemplaire chercherCote(String cote){
        Exemplaire exemplaire = null;
        for(int i = 0; i < nbExemplaires; i++){
            if(tabExemplaire[i].getCote().equals(cote)){
                exemplaire = tabExemplaire[i];
                i = nbExemplaires + 1;
            }
        }
        return exemplaire;
    }

    public boolean retourner(String cote){
        Exemplaire exemplaire = chercherCote(cote);
        if (exemplaire != null){
            exemplaire.retourner();
            return true;
        }
        return false;
    }
}
