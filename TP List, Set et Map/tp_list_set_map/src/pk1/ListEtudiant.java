package pk1;

import java.util.*;

public class ListEtudiant {
    private List<Etudiant> etudiants =new ArrayList<>();

    public ListEtudiant() {
        for (int i = 0; i < 10; i++) {
            etudiants.add(new Etudiant("nom"+i,"prenom"+i,(int)(Math.random()*1000),"Cin"+(int)(Math.random()*1000)));
        }

    }
    public void ajouterEtudiant(Etudiant etu){
        if (etu==null)return;
            etudiants.add(etu);


    }
    //fonction permettant de vérifier l’existence d’un étudiant ;
    public Boolean existeEtudiant(Etudiant etu){
        return etudiants.contains(etu);
        }


    //	Codez une fonction permettant d’afficher les étudiants (utilisez un iterateur) ;
    public void afficherEtudiant(){
        for (Iterator<Etudiant> i = etudiants.iterator(); i.hasNext(); )
            System.out.println(i.next());

    }
    //	Codez une fonction permettant de supprimer un étudiant;
    public void supprimerEtudiant(Etudiant etu){
        if (etu==null)return;
        etudiants.remove(etu);
    }
    //	 Codez une fonction permettant de trier la Liste ;
    public void trierListe(){
        //sort
        Collections.sort(etudiants,new ComparateurParCNE());
    }

    public static void main(String[] args) {
        ListEtudiant etudiants =new ListEtudiant();
        etudiants.afficherEtudiant();
        etudiants.trierListe();
        System.out.println("************************");
        etudiants.afficherEtudiant();

    }
}
