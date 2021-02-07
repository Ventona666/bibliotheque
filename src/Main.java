import Biblio.Bibliotheque;

public class Main {
    public static void main(String args[]){
        System.out.println("On créé un objet Bibliotheque qui peut contenir au maximum 100 ouvrages.");
        Bibliotheque biblio = new Bibliotheque(100);
        System.out.println("On ajoute comme ouvrage Le Cid de Corneille, il pourra y avoir 10 exemplaires.");
        System.out.println("Ajout réussi : " + biblio.ajouterOuvrage("Le Cid", "Corneille", 10));
        System.out.println("On ajoute comme ouvrage Alice au pays des meveilles de Carroll, il pourra y avoir 10 exemplaires.");
        System.out.println("Ajout réussi : " + biblio.ajouterOuvrage("Alice au pays des meveilles", "Carroll", 10));
        System.out.println("On ajoute 2 exemplaires du Cid de l'éditeur Hachette, un datant de 2003 et l'autre de 2005");
        System.out.println("Ajout 1 réussi : " + biblio.ajouterExemplaire("Le Cid", "Corneille", "Hachette", 2003, "Hac03"));
        System.out.println("Ajout 2 réussi : " + biblio.ajouterExemplaire("Le Cid", "Corneille", "Hachette", 2005, "Hac05"));
        System.out.println("On ajoute 1 exemplaire d'Alice au pays des meveilles de Carroll de l'éditeur Nathan datant de 2011");
        System.out.println("Ajout 1 réussi : " + biblio.ajouterExemplaire("Alice au pays des meveilles", "Carroll", "Nathan", 2011, "Nat11"));
        System.out.println("Recherche de l'ouvrage Le Cid de Corneille : " + biblio.rechercherOuvrage("Le Cid", "Corneille"));
        System.out.println("On emprunte un exemplaire du Cid de Corneille, voici sa cote : " + biblio.emprunterExemplaire("Le Cid", "Corneille"));
        System.out.println("On emprunte un exemplaire du Cid de Corneille, voici sa cote : " + biblio.emprunterExemplaire("Le Cid", "Corneille"));
        System.out.println("On emprunte un exemplaire du Cid de Corneille, voici le message d'erreur : " + biblio.emprunterExemplaire("Le Cid", "Corneille"));
        System.out.println("On retourne l'exemplaire du Cid de Corneille ayant pour cote Hac05. Retour réussi : " + biblio.retournerExemplaire("Hac05"));
        System.out.println("On retourne l'exemplaire du Cid de Corneille ayant pour cote Hac03. Retour réussi : " + biblio.retournerExemplaire("Hac03"));
        System.out.println("On supprime Le Cid de Corneille de la bibliothèque.");
        biblio.supprimerOuvrage("Le Cid", "Corneille");
        System.out.println("On tente d'emprunter un exemplaire du Cid de Corneille, voici l'erreur : " + biblio.emprunterExemplaire("Le Cid", "Corneille"));
    }
}
