package pk4;

import java.util.Comparator;

public class Employe {
    private String nom;
    private int nbAnnee;
    private double salaireBase;

    public Employe(String nom, int nbAnnee, double salaireBase) {
        this.nom = nom;
        this.nbAnnee = nbAnnee;
        this.salaireBase = salaireBase;
    }

    @Override
    public String toString() {
        return "Employe{" +
                "nom='" + nom + '\'' +
                ", nbAnnee=" + nbAnnee +
                ", salaire=" + calculerSalaire() +
                '}';
    }

    public double calculerSalaire(){
        return salaireBase*(1+(double)nbAnnee/10);
    }

    public static void main(String[] args) {
        Employe employe = new Employe("Anasse",5,8000);
        Employe diricteur = new Employe("Amine",10,2000){
            @Override
            public double calculerSalaire(){
                return super.calculerSalaire()+15000;
            }

            @Override
            public String toString() {
                return super.toString();
            }
        };
        Comparator<Employe> comparator = new Comparator<Employe>() {
            @Override
            public int compare(Employe e1, Employe e2) {
               if (e1.calculerSalaire()>e2.calculerSalaire()) {
                   return 1;
               }
               if (e1.calculerSalaire()==e2.calculerSalaire()){
                   return 0;
               }
               return -1;
            }
        };

        System.out.println(employe);
    }
}
