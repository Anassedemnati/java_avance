package pk1;

import java.util.*;

public class TreeMapEtudiant {
    private SortedMap<String,Etudiant> CinTreeMap = new TreeMap<>();
    //9.	Déclarez une deuxième TreeHashMap (CneTreeMap)  qui permet de trier les pairs (CNE, Etudiant) en fonction de la CNE.
    private SortedMap<Integer,Etudiant> CneTreeMap = new TreeMap<>();

    String cin = null;
    public TreeMapEtudiant() {

        for (int i = 0; i < 10; i++) {
            cin="cin"+(int)(Math.random()*1000);

            CinTreeMap.put(cin,new Etudiant("nom"+i,"prenom"+i,i,cin));
        }
        CinTreeMap.put("M605340",new Etudiant("Anass ","Demnati",6666,"M605340"));
    }
    //4.	Codez une fonction permettant d’afficher les étudiants (triés par CIN) ;
    public  void afficherParCin ()
    {
        Set<Map.Entry<String,Etudiant>> set = CinTreeMap.entrySet();
        Iterator<Map.Entry<String,Etudiant>> it= set.iterator();
        while (it.hasNext()){
            Map.Entry<String,Etudiant> entry = it.next();
            System.out.println(entry.getKey()+"==>"+entry.getValue());
        }
    }
    //2.	Codez une fonction permettant de rechercher le premier étudiant ;
public Etudiant firstStudent()
{
    return CinTreeMap.get(CinTreeMap.firstKey());

}
//3.	Codez une fonction permettant de rechercher le dernier étudiant ;
    public Etudiant dernierEtudiant(){
        return CinTreeMap.get(CinTreeMap.lastKey());
    }
    //5.	Codez une fonction permettant de retourner les étudiants dont les CINs sont
    // strictement inférieures à celle fournie en premier paramètre et
    // supérieures ou égales à celle fournie en second paramètre ;
    public  SortedMap<String,Etudiant> EntreDeuxValeurs(String cle1,String cle2)
    {
        return CinTreeMap.subMap(cle1,cle2);
    }
    //6.	Codez une fonction permettant de retourner
    // les étudiants dont les CINs sont
    // supérieures ou égales à celle fournie en paramètre
    public SortedMap<String,Etudiant> Supperieur(String cinMin)
    {
        return CinTreeMap.tailMap(cinMin);
    }
    //7.	Codez une fonction permettant de retourner les étudiants dont les CINs sont strictement inférieures à celle fournie en paramètre ;
    public SortedMap<String,Etudiant> Inferieur(String cinMax)
    {
        return CinTreeMap.headMap(cinMax);
    }
    //8.	Codez une fonction permettant de retourner le comparateur utilisé dans la TreeMap ;
    public Comparator renvoyerComparator()
    {
        return CinTreeMap.comparator();
    }
//10.	Codez une fonction permettant de trouver le CIN associé à un étudiant spécifique ;
public String chercherExistenceCin(Etudiant etudiant){
    Set<Map.Entry<String,Etudiant>> set = CinTreeMap.entrySet();
    Iterator<Map.Entry<String,Etudiant>> it =set.iterator();
    Map.Entry<String , Etudiant> entry = null;
    while (it.hasNext())
    {
        entry =it.next();

        if(entry.getValue() == etudiant)
        {
            return entry.getKey();
        }
        return null;
    }
    return null;
}
//11.	Codez une fonction permettant d’ajouter un étudiant à la map ;
public void ajouterEtudiant(Etudiant etudiant){
    CinTreeMap.put(etudiant.getCIN(),etudiant);
}
//12.	Codez une fonction permettant de supprimer un étudiant dans la map ;
public void supprimerEtudiant(Etudiant etudiant){
    CinTreeMap.remove(etudiant);
}
//13.	Codez une fonction permettant de joindre une map dans une autre.
    public boolean supprimerEtudiant1(Etudiant etudiant){
        return CinTreeMap.remove(etudiant.getCIN(),etudiant);
    }
    //14 Codez une fonction permettant de joindre une map dans une autre ;
    public void joindreMap(Map<String,Etudiant> map){
        this.CinTreeMap.putAll(map);
    }
    public static void main(String[] args) {
        TreeMapEtudiant treeMapEtudiant = new TreeMapEtudiant();
        treeMapEtudiant.afficherParCin();
        System.out.println("***********************************");
        System.out.println( treeMapEtudiant.firstStudent());
        System.out.println("-------------------------------------");
        System.out.println("dernierEtudiant  "+treeMapEtudiant.dernierEtudiant());
        System.out.println("-------------------------------------");
        System.out.println("firstStudent  "+treeMapEtudiant.firstStudent());
       // System.out.println(treeMapEtudiant.("M605340"));
        System.out.println("fun trouverEtudiant => "+treeMapEtudiant.chercherExistenceCin(new Etudiant("Anass ","Demnati",6666,"M605340")));

    }
}
