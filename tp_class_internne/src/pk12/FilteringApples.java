package pk12;

import com.sun.xml.internal.bind.v2.TODO;

import java.util.*;
import java.util.function.BiPredicate;
import java.util.function.Predicate;
import static java.util.Comparator.comparing;

public class FilteringApples {
   private static List<Apple> apples = Arrays.asList(
           new Apple(150, Color.RED),
           new Apple(120, Color.GREEN),
           new Apple(50, Color.RED),
           new Apple(44, Color.GREEN)
   );

    public static void main(String[] args) {
        //comparateur
       /* Comparator<Apple> comparateur = new Comparator<Apple>() {
            @Override
            public int compare(Apple a1, Apple a2) {
                return a1.getWeight()-a2.getWeight();
            }
        };*/
        /*apples.sort(new Comparator<Apple>() {
            @Override
            public int compare(Apple a1, Apple a2) {
                return a1.getWeight()-a2.getWeight();
            }
        });*/
        /*for (Apple apple:apples) {
            System.out.println(apple);
        }*/


        Runnable runnable = new Runnable() {//on programation concurantielle
            @Override
            public void run() {
                System.out.println("ok");
            }
        };
        runnable= ()->System.out.println("ok");// la maime chose

        Comparator<Apple> comparateur = (Apple a1, Apple a2)->a1.getWeight()-a2.getWeight();
        //apples.sort(comparateur);
        apples.sort(comparing(Apple::getWeight)); //comparing c'est une methode static qui fait le sort selon un critaire


        apples.forEach(aplle-> System.out.println(aplle));
        System.out.println("******************************Green apples **********************************");
       /* Predicate<Apple> predicate = new Predicate<Apple>() {
            @Override
            public boolean test(Apple apple) {
                return apple.getColor()==Color.GREEN;
            }
        };*/
        List<Apple> greenApples= filtrer((Apple apple)->apple.getColor()==Color.GREEN);
        greenApples.forEach(apple -> System.out.println(apple));
        System.out.println("******************************RED apples **********************************");
        List<Apple> redApple =filtrer((Apple apple)->apple.getColor()==Color.RED);
        redApple.forEach(apple -> System.out.println(apple));
        System.out.println("******************************Heavy apples **********************************");
        List<Apple> heavyAplle= filtrer((Apple apple)->apple.getWeight()>=150);
        System.out.println("******************************filtere apples by params **********************************");
            List<Apple> redAplle= filtrer(new BiPredicate<Apple, Color>() {
                @Override
                public boolean test(Apple apple, Color color) {
                    return apple.getColor()==color;
                };
            },Color.RED);
        redAplle.forEach(apple -> System.out.println(apple));
        //TODO laynd same methode
    }




    public enum Color{
        RED,GREEN

    }
    public static class Apple {
        private int weight;
        private Color color;

        public Apple(int weight, Color color) {
            this.weight = weight;
            this.color = color;
        }

        public int getWeight() {
            return weight;
        }

        public void setWeight(int weight) {
            this.weight = weight;
        }

        public Color getColor() {
            return color;
        }

        public void setColor(Color color) {
            this.color = color;
        }

        @Override
        public String toString() {
            return "Apple{" +
                    "weight=" + weight +
                    ", color=" + color +
                    '}';
        }
    }
    public static List<Apple> filtrer(Predicate<Apple> predicate){
        List<Apple> newAplle=new ArrayList<>();
        apples.forEach(aplle->{
            if(predicate.test(aplle))
                newAplle.add(aplle);
        }
        );
        return newAplle;
    }
    public static List<Apple> filtrer(BiPredicate<Apple,Color> biPredicate,Color color) {
        List<Apple> newAplle=new ArrayList<>();
        apples.forEach(aplle->{
                    if(biPredicate.test(aplle,color))
                        newAplle.add(aplle);
                }
        );
        return newAplle;
    }
}
