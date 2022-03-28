package pk1;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class HashMapEtudiant {
    private Map<String,Etudiant> map = new HashMap<>();
    String cin=null;
    public HashMapEtudiant() {
        for (int i = 0; i < 10; i++) {
            cin="cin"+(int)(Math.random()*1000);

            map.put(cin,new Etudiant("nom"+i,"prenom"+i,i,cin));
        }
        map.put("M605340",new Etudiant("Anass ","khaybe",6666,"M605340"));
    }
    //16.	Codez une fonction permettant d’afficher les étudiants (CIN => Etudiant) ;
    public void afficherCinEtudiant(){
        Set<Map.Entry<String,Etudiant>> set = map.entrySet();
        Iterator<Map.Entry<String,Etudiant>> it= set.iterator();
        while (it.hasNext()){
            Map.Entry<String,Etudiant> entry = it.next();
            System.out.println(entry.getKey()+"==>"+entry.getValue());
        }
    }
    public void afficherCin(){
        Set<String> set =map.keySet();
        Iterator<String> it = set.iterator();
        while (it.hasNext()){

            System.out.println(it.next());
        }
    }
    //14.	Codez une fonction permettant de rechercher un étudiant ;
    public boolean chercherExistenceEtudiant(Etudiant etudiant){

        return map.containsValue(etudiant);
    }
    //15.	Codez une fonction permettant de vérifier l’existence d’un CIN ;
    public boolean chercherExistenceCin(String cin){
        return map.containsKey(cin);
    }


    //19.	Codez une fonction permettant de renvoyer l’étudiant associé à un CIN spécifique ;
    public Etudiant findByCIN(String cin){

        for (Map.Entry<String, Etudiant> entry : map.entrySet()) {
            String s = entry.getKey();
            Etudiant etudiant = entry.getValue();
            if (s.equals(cin)){
                return etudiant;
            }
        }
        return null;
    }
    //corection
    public Etudiant renvoyerEtudiant(String cin){
        return map.get(cin);
    }

    //20. 	Codez une fonction permettant de trouver le CIN associé à un étudiant spécifique ;
    public String trouverEtudiant(Etudiant etudiant){
        for (Map.Entry<String, Etudiant> entry : map.entrySet()) {
            String s = entry.getKey();
            Etudiant _etudiant = entry.getValue();

            if (_etudiant.equals(etudiant)) {

                return _etudiant.getCIN();
            }

        }
        return "Etudiant intouvable";
    }
    //correction
    public String renvoyerCin(Etudiant etudiant){
       Set<Map.Entry<String,Etudiant>> set = map.entrySet();
       Iterator<Map.Entry<String,Etudiant>> it =set.iterator();
       while (it.hasNext())
       {
           Map.Entry<String , Etudiant> entry = it.next();
           if(entry.getValue() == etudiant)
           {
               return entry.getKey();
           }

       }
            return null;
    }
    //21.	Codez une fonction permettant d’ajouter un étudiant à la map ; *
    public void ajouterEtudiant(Etudiant etudiant){
        map.put(etudiant.getCIN(),etudiant);
    }


    //22. 	Codez une fonction permettant de supprimer un étudiant dans la map ;
    public void supprimerEtudiant(Etudiant etudiant){
        map.remove(etudiant);
    }
    //correction 1
    public boolean supprimerEtudiant1(Etudiant etudiant){
       return map.remove(etudiant.getCIN(),etudiant);
    }
    //correction 2
    public boolean supprimerEtudiant(String cin){
        return map.remove(cin)!= null;
    }
    //23 Codez une fonction permettant de joindre une map dans une autre ;
    public void joindreMap(Map<String,Etudiant> map){
        this.map.putAll(map);
    }
    public static void main(String[] args) {
        HashMapEtudiant mapsEtudiants = new HashMapEtudiant();
        mapsEtudiants.afficherCinEtudiant();
        System.out.println("***********************************");
        mapsEtudiants.afficherCin();
        System.out.println(mapsEtudiants.findByCIN("M605340"));
        System.out.println("fun trouverEtudiant => "+mapsEtudiants.trouverEtudiant(new Etudiant("Anass ","khaybe",6666,"M605340")));
    }

}
