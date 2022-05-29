package pk1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
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
    //Stream c est une api avec plusieur interface
    //je peux modifier limiter le nombrte de resultat

    public static List<String> getLowCaloricDishesNamesStream (List<Dish> dishes) {
        Stream<String> listNamedishes = (Stream<String>) dishes.stream()
                .filter(d->d.getCalories()<400)
                .sorted(Comparator.comparing(Dish::getCalories))
                //.sorted()
                .map(d->d.getName())
                .collect(Collectors.toList());

        return (List<String>) listNamedishes;
    }

    public static void main(String[] args) {
        System.out.println(menu);
        System.out.println("*******************************************");
        System.out.println( getLowCaloricDishesNamesStream(menu));
    }

}
