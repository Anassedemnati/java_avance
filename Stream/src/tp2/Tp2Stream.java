package tp2;

import pk1.Dish;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class Tp2Stream {

public static void main(String[] args) {
    //1-1-	Filtrer les objets Dish de type « Vegetarian » ;
    System.out.println("1-1-Filtrer les objets Dish de type « Vegetarian » ;");
    Dish.menu.stream()
           // .filter(d->d.isVegetarian())
            .filter(Dish::isVegetarian)
            .forEach(System.out::println);//final methods in stream
            ;
    //2-Trier la liste des dishes, puis filtrer les objets Dish suivant Calories < 320 ;
    System.out.println("2-Trier la liste des dishes, puis filtrer les objets Dish suivant Calories < 320 ;");
    Dish.menu.stream()
            .sorted(Comparator.comparing(Dish::getCalories))
            .filter(d->d.getCalories()<400)
            .forEach(System.out::println);
    //3-	Utiliser la méthode takeWhile() pour filtrer la liste (Calories> 300);
    System.out.println("3-Utiliser la méthode takeWhile() pour filtrer la liste (Calories< 400);");
    //takeWhile() je recupere les objet tant que la condition et vrai
    //120 ,320 ,800 takeWhile(d->d.getCal()<400) -->> 120,320
    //Dish.menu.stream().takeWhile();




    //6-	Utiliser la fonction anyMatch pour vérifier l’existence d’un objet Dish de type Vegetarian ;
    System.out.println("objet dish de type vegetaian ? "+Dish.menu.stream()
            .anyMatch(Dish::isVegetarian));
    System.out.println("tous les objets Dish ont des calories<1000  ? "+Dish.menu.stream()
            .allMatch(d->d.getCalories()<1000));
 System.out.println("aucun objet Dish n’a pas de calories>=1000   ? "+Dish.menu.stream()
            .noneMatch(d->d.getCalories()>=1000));

//9-	Soit la liste :  List<Integer> numbers = Arrays.asList(3, 4, 5, 1, 2); et à l’aide de la fonction reduce déclarée dans les Streams,
    List<Integer> numbers = Arrays.asList(3, 4, 5, 1, 2);
    int somme = numbers.stream()
            .reduce(1,(a1,a2)->a1*a2);
    System.out.println("somme "+somme);
    //b.	Renvoyer la valeur maximale de cette liste ;
    int max = numbers.stream()
            .reduce(numbers.get(0),(a1,a2)->Math.max(a1,a2));
        System.out.println("MAx number "+max);
    int min = numbers.stream()
            .reduce(numbers.get(0),(a1,a2)->Math.min(a1,a2));
    System.out.println("MIN number "+min);



}



}
