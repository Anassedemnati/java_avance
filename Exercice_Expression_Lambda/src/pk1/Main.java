package pk1;

import java.awt.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class Main {

    public class Point {

        private int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        @Override
        public String toString() {
            return "Point [x=" + x + ", y=" + y + "]";
        }

        public void affiche() {
            System.out.print(" [ " + x + ", " + y + "] ");
        }
    }

    public static void main(String[] args) {

    }
    /*public static void traiteListe(List<Point> liste, Predicate<Point> predicate, Comparator<Point> comp, Consumer<Point> aff){
        List<Point> newliste = new ArrayList<>();
        liste.
    }*/
}
