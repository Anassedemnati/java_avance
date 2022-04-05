package pk1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class FilteringApples{
   private static List<Apple> apples = Arrays.asList(
           new Apple(150,Color.RED),
           new Apple(120,Color.GREEN),
           new Apple(50,Color.RED),
           new Apple(44,Color.GREEN)
   );



    public static void main(String[] args) {
        //8-	Dans la fonction main, trier la liste apples ;
        /*Comparator<Apple> comparator = new Comparator<Apple>() {
            //class anonyme
            @Override
            public int compare(Apple a1, Apple a2) {
                return a1.getWeight()-a2.getWeight();
            }
        };*/
        //apples.sort(comparator);//sort with Aplle comparator
        apples.sort(new Comparator<Apple>() {
            //class anonyme
            @Override
            public int compare(Apple a1, Apple a2) {
                return a1.getWeight()-a2.getWeight();
            }
        });//sort with Aplle comparator

        for (Apple apple:apples) {
            System.out.println(apple);
        }
        //---------------------------------- Question 9----------------------------------------//
        System.out.println("\n****************************** green Apples ******************************\n");
        for (Apple ap:filterGreenApples()) {
            System.out.println(ap);
        }
        //---------------------------------- Question 10----------------------------------------//
        System.out.println("\n******************************  heavy Apples  ******************************\n");
        for (Apple ap:filterApplesByWeight(100)) {
            System.out.println(ap);
        }
        System.out.println("\n******************************  v2 heavy Apples  ******************************\n");
        for (Apple ap:(filter(new Apple.AppleWeightPredicate()))) {
            System.out.println(ap);
        }
        //---------------------------------- Question 11----------------------------------------//
        System.out.println("\n******************************  RED Apples  ******************************\n");
        for (Apple ap:filterApplesByColors(Color.RED)) {
            System.out.println(ap);
        }
        //---------------------------------- Question 16----------------------------------------//
        System.out.println("\n******************************  v2 GREEN Apples  ******************************\n");
        for (Apple ap:filter(new Apple.AppleColorPredicate())) {
            System.out.println(ap);
        }
        System.out.println("\n******************************  v2 filter Apples by color and weight ******************************\n");
        for (Apple ap:filter(new Apple.AppleRedAndHeavyPredicatepermettant())) {
            System.out.println(ap);
        }
        System.out.println("\n******************************  V classe anonyme ******************************\n");
        System.out.println("\n******************************  RED Apples classe anonyme  ******************************\n");
        for (Apple ap:filter(new Apple.ApplePredicate() {
            @Override
            public boolean test(Apple apple) {
                return apple.getColor()==Color.RED;
            }
        })) {
            System.out.println(ap);
        }
        System.out.println("\n******************************  filter Apples by color and weight classe anonyme  ******************************\n");
        for (Apple ap:filter(new Apple.ApplePredicate() {
            @Override
            public boolean test(Apple apple) {
                return apple.getColor()==Color.RED && apple.getWeight()>=150;
            }
        })) {
            System.out.println(ap);
        }
        System.out.println("\n******************************   heavy Apples classe anonyme ******************************\n");
        for (Apple ap:(filter(new Apple.ApplePredicate() {
            @Override
            public boolean test(Apple apple) {
                return apple.getWeight()>=150;
            }
        }))) {
            System.out.println(ap);
        }
    }
    //9-	Déclarer une méthode filterGreenApples permettant
    // de renvoyer les objets Apple ayant GREEN comme couleur, tester la méthode dans la fonction main;
    public static List<Apple> filterGreenApples(){
        List<Apple> applesGren = new ArrayList<Apple>();
        for (Apple apple:apples) {
            if (apple.getColor()==Color.GREEN){
                applesGren.add(apple);
            }

        }
        return applesGren;
    }
    //---------------------------------- Question 10----------------------------------------//
    //10-	Déclarer une méthode filterApplesByWeight permettant de renvoyer les objets Apple
    // ayant une poids donné en paramètre, tester la méthode dans la fonction main;
    public static List<Apple> filterApplesByWeight(int weight){
        List<Apple> applesheavy = new ArrayList<Apple>();
        for (Apple apple:apples) {
            if (apple.getWeight()>=weight){
                applesheavy.add(apple);
            }

        }
        return applesheavy;
    }
    //---------------------------------- Question 11----------------------------------------//
    //11-	Déclarer une méthode filterApplesByColor permettant de renvoyer
    // les objets Apple ayant une couleur donnée en paramètre, tester la méthode dans la fonction main;
    public static List<Apple> filterApplesByColors(Color color){
        List<Apple> apples = new ArrayList<Apple>();
        for (Apple apple:apples) {
            if (apple.getColor()==color){
                apples.add(apple);
            }

        }
        return apples;
    }
    public enum Color{
        RED,GREEN

    }
    public static class Apple{
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
        //interface fonctionnelle
        ////---------------------------------- Question 12----------------------------------------//
        public interface ApplePredicate extends Predicate<Apple>{

        }
        //---------------------------------- Question 13----------------------------------------//
        public static class AppleWeightPredicate implements ApplePredicate{

            @Override
            public boolean test(Apple apple) {
                return apple.getWeight()>=150;
            }
        }
        //---------------------------------- Question 14----------------------------------------//
        //14-	Déclarer une classe static AppleColorPredicate
        // permettant de tester si color de la classe Apple est égale à GREEN ;
        public static class AppleColorPredicate implements ApplePredicate{

            @Override
            public boolean test(Apple apple) {
                return apple.getColor()==Color.GREEN;
            }
        }
        //---------------------------------- Question 15----------------------------------------//
        //15-	Déclarer une classe static AppleRedAndHeavyPredicatepermettant
        // de tester si color de la classe Apple est égale à RED et si son poids dépasse 150 ;
        public static class AppleRedAndHeavyPredicatepermettant implements ApplePredicate{

            @Override
            public boolean test(Apple apple) {
                return apple.getColor()==Color.RED && apple.getWeight()>=150  ;
            }

        }

    }
    //---------------------------------- Question 16----------------------------------------//
    //16-	Déclarer une méthode filter permettant de renvoyer
    // les objets Apples vérifiant une condition passée en paramètre;
    public static List<Apple> filter(Apple.ApplePredicate applePredicate){
        List<Apple> apples2 = new ArrayList<>();
        for (Apple ap:apples) {
            if (applePredicate.test(ap)){
                apples2.add(ap);
            }

        }
        return apples2;
    }

    public static List<Apple> filter(Predicate predicate){
        List<Apple> apples2 = new ArrayList<>();
        for (Apple ap:apples) {
            if (predicate.test(ap)){
                apples2.add(ap);
            }

        }
        return apples2;
    }
}
