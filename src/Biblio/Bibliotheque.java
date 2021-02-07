package Biblio;

public class Bibliotheque{
    private int nbOuvrages = 0;
    private final int nbOuvrageMax;
    public Ouvrage[] tabOuvrages;

    public Bibliotheque(int nbOuvrageMax){
        this.nbOuvrageMax = nbOuvrageMax;
        this.tabOuvrages = new Ouvrage[nbOuvrageMax];
    }

    public boolean ajouterOuvrage(String titre, String auteur, int nbExemplaireMax){
        if(nbOuvrages <= nbOuvrageMax){
            Ouvrage nouvelOuvrage = new Ouvrage(titre, auteur, nbExemplaireMax);
            this.tabOuvrages[nbOuvrages++] = nouvelOuvrage;
            return true;
        }
        return false;
    }

    private int selectionnerIndexOuvrage(String titre, String auteur){
        int finalI = -1;
        for(int i=0; i < nbOuvrages; i++){
            if (this.tabOuvrages[i].getTitre().equals(titre) && this.tabOuvrages[i].getAuteur().equals(auteur)){
                finalI = i;
                i = nbOuvrages;
            }
        }
        return finalI;
    }

    public boolean ajouterExemplaire(String titre, String auteur, String editeur, int anneeParution, String cote){
        Ouvrage ouvrage = rechercherOuvrage(titre, auteur);
        return ouvrage.ajouterExemplaire(cote, editeur, anneeParution);
    }

    public Ouvrage rechercherOuvrage(String titre, String auteur){
        int index = selectionnerIndexOuvrage(titre, auteur);
        if (index == -1){
            return null;
        }
        return tabOuvrages[index];
    }

    public void supprimerOuvrage(String titre, String auteur){
        int index = selectionnerIndexOuvrage(titre, auteur);
        if (index != -1){
            int j = index;
            while (j < nbOuvrages-1){
                tabOuvrages[j] = tabOuvrages[j+1];
                j++;
            }
            tabOuvrages[j] = null;
            nbOuvrages--;
        }
    }

    public String emprunterExemplaire(String titre, String auteur){
        Ouvrage ouvrage = rechercherOuvrage(titre, auteur);
        if (ouvrage != null){
            return ouvrage.emprunter();
        }
        return "Cet ouvrage n'est pas disponible !";
    }

    public boolean retournerExemplaire(String cote){
        boolean j = false;
        for(int i = 0; i < nbOuvrages && !j; i++){
            j = tabOuvrages[i].retourner(cote);
            i = nbOuvrages;
        }
        return j;
    }

}
