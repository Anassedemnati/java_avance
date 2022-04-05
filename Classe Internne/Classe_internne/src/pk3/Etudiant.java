package pk3;

public class Etudiant implements Comparable<Etudiant>,Cloneable{
    String nom;
    String prenom;
    int CNE;
    String CIN;

    public Etudiant(String nom, String prenom, int CNE, String CIN) {
        this.nom = nom;
        this.prenom = prenom;
        this.CNE = CNE;
        this.CIN = CIN;
    }

    @Override
    public String toString() {
        return "Etudiant{" +
                "nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", CNE=" + CNE +
                ", CIN='" + CIN + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Etudiant){
            Etudiant etudiant = (Etudiant) obj;
           return etudiant.getCIN()==this.getCIN();
        }
        return false;
    }

    @Override
    protected Etudiant clone() {
        Etudiant etudiant ;
        try {
            etudiant=(Etudiant) super.clone();
            return etudiant;
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int hashCode() {

        return this.getCIN().hashCode();
    }
    @Override
    public int compareTo(Etudiant o) {

          return this.CIN.compareTo(o.CIN);
    }
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public Integer getCNE() {
        return CNE;
    }

    public void setCNE(Integer CNE) {
        this.CNE = CNE;
    }

    public String getCIN() {
        return CIN;
    }

    public void setCIN(String CIN) {
        this.CIN = CIN;
    }


}
