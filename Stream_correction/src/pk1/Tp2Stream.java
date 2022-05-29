package pk1;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;
import static java.util.Comparator.comparing;
import static pk1.Dish.menu;

public class Tp2Stream {

	public static void main(String[] args) {
// 1-	Filtrer les objets Dish de type « Vegetarian » ;
System.out.println("Dish de type « Vegetarian »");

			menu.stream()
				//.filter(d->d.isVegetarian())
				.filter(Dish::isVegetarian)
				.forEach(System.out::println);;

// 2-	Trier la liste des dishes, puis filtrer les objets Dish suivant Calories < 320 ;
				
				System.out.println("\nDish triés , filtrés en fct des calories");
				menu.stream()
				.sorted(comparing(Dish::getCalories))
				.filter(d->d.getCalories()<400)
				.forEach(System.out::println);
				
				
// 3-	Utiliser la méthode takeWhile() pour filtrer la liste (Calories> 300);
				System.out.println("\ntacke while , condition : calories<400");
				menu.stream()
				.sorted(comparing(Dish::getCalories))
				.takeWhile(d->d.getCalories()<400)
				.forEach(System.out::println);
				
		// 4-	Utiliser la méthode dropWhile() pour filtrer la liste (Calories> 300);		
				
				System.out.println("\ndrop while , condition : calories<400");
				menu.stream()
				.sorted(comparing(Dish::getCalories))
				.dropWhile(d->d.getCalories()<400)
				.forEach(System.out::println);
				
				
				
				
			//5-	Filter la liste des objets Dish, puis utiliser la fonction skip;	
				System.out.println("\nskip");
				menu.stream()
				.filter(d->d.getCalories()<400)
				.skip(1)
				.forEach(System.out::println);
				
				
				//6-	Utiliser la fonction anyMatch pour vérifier l’existence d’un objet Dish de type Vegetarian ;
				
				
				System.out.println("\nObjet Dish de type Vegetarian ? " + menu.stream()
				.anyMatch(Dish::isVegetarian));
				
				// 7-	Utiliser la fonction allMatch pour s’assurer que tous les objets Dish ont des calories<1000 ;
				
				System.out.println("\ntous les objets Dish ont des calories<1000 ? " + menu.stream()
				.allMatch(d->d.getCalories()<1000));
				
				// 8-	Utiliser la fonction noneMatch pour s’assurer qu’aucun objet Dish n’a pas de calories>=1000
				System.out.println("\naucun objets Dish n'a pas des calories>=1000 ? " + menu.stream()
				.noneMatch(d->d.getCalories()>=1000));
				
				
				
				// 9-
				
				List<Integer> numbers = Arrays.asList(3, 4, 5, 1, 2); 
				
				int somme = numbers.stream()
									.reduce(0, (a1,a2) -> Integer.sum(a1, a2));
				System.out.println("Somme : " + somme);
				
				int max = numbers.stream().reduce(numbers.get(0), (a1,a2)->Math.max(a1, a2));
				System.out.println("Max : " + max);

				int min = numbers.stream().reduce(numbers.get(0), (a1,a2)->Math.min(a1, a2));
				System.out.println("Min : "+ min);
				
				
				List<Integer> listCal = menu.stream()
						.map(d->d.getCalories())
						.toList();
				
				int sommeCal = listCal.stream()
						.reduce(0, (c1,c2)->Integer.sum(c1, c2));
				
				System.out.println("somme cal :"+ sommeCal );

				
	}

}
