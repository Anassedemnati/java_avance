package pk1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;
import static java.util.Comparator.comparing;

import static pk1.Dish.menu;

public class MenuDishes {
	  public static List<String> getLowCaloricDishesNames (List<Dish> dishes) {
		    List<Dish> lowCaloricDishes = new ArrayList<>();
		    for (Dish d : dishes) {
		      if (d.getCalories() < 400) {
		        lowCaloricDishes.add(d);
		      }
		    }
		    List<String> lowCaloricDishesName = new ArrayList<>();
		    Collections.sort(lowCaloricDishes, new Comparator<Dish>() {
		      @Override
		      public int compare(Dish d1, Dish d2) {
		        return Integer.compare(d1.getCalories(), d2.getCalories());
		      }
		    });
		    for (Dish d : lowCaloricDishes) {
		      lowCaloricDishesName.add(d.getName());
		    }
		    return lowCaloricDishesName;
		  }

	  public static List<String> getLowCaloricDishesNamesStream (List<Dish> dishes) {
		  List<String> listeStream = dishes.stream()
				  						.filter(d->d.getCalories()<400)
				  						.sorted(comparing(Dish::getCalories))
										//.sorted((d1,d2)->d1.getCalories()-d2.getCalories())
										.map(d->d.getName())
										.toList()

										;

		  
		  return listeStream;
	  }
	public static void main(String[] args) {

System.out.println("**********************Menu**************************");
menu.forEach(System.out::println);
System.out.println("**********************lowCaloricDishesName**************************");
List<String> liste1 = getLowCaloricDishesNamesStream(menu);
liste1.forEach(System.out::println);

	}

}
