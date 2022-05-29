package pk1;

import java.util.function.Consumer;

public class Exercice2 {
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

    public static void main(String[] args) {
        Consumer<Apple> consumer = new Consumer<Apple>() {
            @Override
            public void accept(Apple apple) {
                System.out.println("An apple of "+apple.getWeight());
            }
        };
    }
    public static void taritment(Consumer<Apple> consumer){

    }



}
