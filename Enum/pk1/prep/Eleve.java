package pk1.prep;


import java.sql.Array;
import java.util.Arrays;

/*

On veut établir les résultats d’examen d’un ensemble d’élèves.
        Chaque élève est représenté par un objet de type Eleve, comportant les champs suivants :
        le nom de l’élève (type String),
        son admissibilité à l’examen,
        sous forme d’une valeur d’un type énuméré comportant les valeurs
        suivantes : N (non admis), P (passable), AB ( Assez bien), B (Bien), TB (Très bien).
        Un tabeau (type int) contenant trois notes;
        Les méthodes : toString(),
        calculerMoyenne() qui permet de calculer la moyenne des trois notes;
         et deternimerAdminissibilite() qui permet d’attribuer convenablement le champ d’admissibilité, suivant les règles usuelles :
        – moyenne < 10 : Non admis
        – 10 <= moyenne <12 : Passable
        – 12 <= moyenne <14 : Assez bien
        – 14 <= moyenne <16 : Bien
        – 16 <= moyenne : Très bien
*/
public class Eleve {
    private String nom ;
    private int[] notes;
    private Admissibilite adm;


    public enum Admissibilite{

        N ("non admis",0,10), P ("passable",10,12), AB ( "Assez bien",12,14), B ("Bien",14,16), TB ("Très bien",16,21);
        private String signification;
        private final int min,max;

        Admissibilite(String signification, int min, int max) {
            this.signification = signification;
            this.min = min;
            this.max = max;
        }
    }

    @Override
    public String toString() {
        return "Eleve{" +
                "nom='" + nom + '\'' +
                ", notes=" + Arrays.toString(notes) +
                ", admissibilite=" + adm +
                '}';
    }
    public double  calculerMoyenne(){
        double some=0;
        for (double note:notes) {
            some+=note;
        }
        return some/notes.length;
    }
    public void deternimerAdminissibilite(){
        double moy=calculerMoyenne();
        for (Admissibilite i:adm.values()) {
            if (moy>=i.min && moy< i.max){
                adm=i;
                return;
            }
        }
    }

    public Eleve(String nom, int[] notes) {
        this.nom = nom;
        this.notes = notes;
    }


    public static void main(String[] args) {
        Eleve Anasse = new Eleve("Anasse",(new int[]{12,14,19}));
        System.out.println(Anasse);
        Anasse.deternimerAdminissibilite();
        System.out.println(Anasse);
    }
}
