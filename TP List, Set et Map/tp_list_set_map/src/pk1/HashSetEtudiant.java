package pk1;

import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class HashSetEtudiant {
    Set<Etudiant> etudiantSet = new HashSet<>();
    public HashSetEtudiant() {
        for (int i = 0; i < 10; i++) {
            etudiantSet.add(new Etudiant("nom"+i,"prenom"+i,(int)(Math.random()*1000),"Cin"+(int)(Math.random()*1000)));
        }

    }
    public void ajouterEtudiant(Etudiant etu){
        if (etu==null)return;
        etudiantSet.add(etu);


    }
    //fonction permettant de vérifier l’existence d’un étudiant ;
    public Boolean existeEtudiant(Etudiant etu){
        return etudiantSet.contains(etu);
    }


    //	Codez une fonction permettant d’afficher les étudiants (utilisez un iterateur) ;
    public void afficherEtudiant(){
        for (Iterator<Etudiant> i = etudiantSet.iterator(); i.hasNext(); )
            System.out.println(i.next());

    }
    //	Codez une fonction permettant de supprimer un étudiant;
    public void supprimerEtudiant(Etudiant etu){
        if (etu==null)return;
        etudiantSet.remove(etu);
    }
    public void vider(){
        etudiantSet.clear();
    }


    public static void main(String[] args) {
        Etudiant etu = new Etudiant("nomzz","prenomzz",(int)(Math.random()*1000),"Cin"+(int)(Math.random()*1000));
        HashSetEtudiant etudiantsSet =new HashSetEtudiant();
        etudiantsSet.afficherEtudiant();
        etudiantsSet.vider();
        etudiantsSet.ajouterEtudiant(etu);
        etudiantsSet.afficherEtudiant();



    }
}
