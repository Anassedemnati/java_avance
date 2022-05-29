package pk1;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static pk1.Dish.menu;
public class Ex1 {

    public static void main(String[] args) {
        //1-Filtrer les objets Dish de type « Vegetarian »
        System.out.println("1-Filtrer les objets Dish de type « Vegetarian »");
        List<Dish> dishesVegan = menu.stream().filter(dish -> dish.isVegetarian()).toList();
        System.out.println(dishesVegan);
        //2-	Trier la liste des dishes, puis filtrer les objets Dish suivant Calories < 320 ;
        System.out.println("2-\tTrier la liste des dishes, puis filtrer les objets Dish suivant Calories < 320 ;");
        List<Dish> dishesCalInf320 = menu.stream()
                .sorted(Comparator.comparing(Dish::getCalories))
                .filter(dish -> dish.getCalories() < 320)
                .toList();
        System.out.println(dishesCalInf320);
        //3-	Utiliser la méthode takeWhile() pour filtrer la liste (Calories> 300);
        System.out.println("//3-\tUtiliser la méthode takeWhile() pour filtrer la liste (Calories> 300);");
        List<Dish> dishesTakeWhileSup300 = menu.stream()
                .sorted(Comparator.comparing(Dish::getCalories))
                .takeWhile(dish -> dish.getCalories() > 300)//result []
                .toList();
        System.out.println(dishesTakeWhileSup300);
        //4-	Utiliser la méthode dropWhile() pour filtrer la liste (Calories> 300);
        System.out.println(" //4-\tUtiliser la méthode dropWhile() pour filtrer la liste (Calories> 300);");
        List<Dish> dishesDropWhileSup300 = menu.stream()
                .sorted(Comparator.comparing(Dish::getCalories))
                .dropWhile(dish -> dish.getCalories() > 300)//result [season fruit, rice, chicken, prawns, salmon, french fries, pizza, beef, pork]
                .toList();
        System.out.println(dishesDropWhileSup300);
        //5-	Filter la liste des objets Dish, puis utiliser la fonction skip;
        System.out.println("5-\tFilter la liste des objets Dish, puis utiliser la fonction skip");
        List<Dish> dishesSkip = menu.stream()
                .filter(dish -> dish.isVegetarian())
                .skip(2)
                .toList();
        System.out.println(dishesSkip);
        //6-	Utiliser la fonction anyMatch pour vérifier l’existence d’un objet Dish de type Vegetarian ;
        System.out.println("6-\tUtiliser la fonction anyMatch pour vérifier l’existence d’un objet Dish de type Vegetarian ;");
        boolean isVegan = menu.stream().sorted(Comparator.comparing(Dish::getCalories))
                .anyMatch(dish -> dish.isVegetarian());
        System.out.println("vérifier l’existence d’un objet Dish de type Vegetarian  "+isVegan);
        //7-	Utiliser la fonction allMatch pour s’assurer que tous les objets Dish ont des calories<1000 ;
        boolean allMatchInf1000 = menu.stream()
                .allMatch(dish -> dish.getCalories() < 1000);
        System.out.println("s’assurer que tous les objets Dish ont des calories<1000 "+allMatchInf1000);
        //8-	Utiliser la fonction noneMatch pour s’assurer qu’aucun objet Dish n’a pas de calories>=1000 ;
        boolean noneMatchCalSupOrEqual1000 = menu.stream()
                .noneMatch(dish -> dish.getCalories() >= 1000);
        System.out.println("s’assurer qu’aucun objet Dish n’a pas de calories>=1000 "+noneMatchCalSupOrEqual1000 );
        //9-	Soit la liste :  List<Integer> numbers = Arrays.asList(3, 4, 5, 1, 2); et à l’aide de la fonction reduce déclarée dans les Streams,
        List<Integer> numbers = Arrays.asList(3, 4, 5, 1, 2);
        //a.	Calculer la somme de numbers ;
        Integer somme = numbers.stream()
                .reduce(0, (n1, n2) -> n1 + n2);
        System.out.println("somme "+somme);
        //b.	Renvoyer la valeur maximale de cette liste ;
        Integer max = numbers.stream()
                .reduce(numbers.get(0), (n1, n2) -> Math.max(n1, n2));
        System.out.println("max "+max);
        //c.	Renvoyer la valeur minimale de cette liste ;
        Integer min = numbers.stream()
                .reduce(numbers.get(0), (n1, n2) -> Math.min(n1, n2));
        System.out.println("min "+min);
        //10-	à l’aide de la fonction reduce, calculer la somme des calories de la liste menu.
        System.out.println("//10-\tà l’aide de la fonction reduce, calculer la somme des calories de la liste menu.");
        Integer sommeCal = menu.stream().map(dish -> dish.getCalories()).reduce(0, (cal1, cal2) -> cal1 + cal2);
        System.out.println("la somme des calories de la liste : "+sommeCal+" cal");

    }
}
