package pk1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import static java.util.Comparator.comparing;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Point> listPoint = Arrays.asList(new Point(1, -4), new Point(4, 9), new Point(-3, -4), new Point(2, 2),
				new Point(8, 6), new Point(3, 3), new Point(-4, -4)

		);
		
		traiteListe(listPoint,
				point -> point.getX()>=0 ,
				(p1,p2)->p1.getX()-p2.getX(),
				point-> System.out.print
				("["+point.getX()+","+point.getY()+"]" ));
		// version 2
		// comparing methode static
		System.out.println("**********************************");
		traiteListe(listPoint,
				point -> point.getX()>=0 ,
				comparing(Point::getX),
				point-> System.out.print
				("["+point.getX()+","+point.getY()+"]" ));
		System.out.println("**********************************");
		
		traiteListe(listPoint,
				point -> true,
				(p1,p2)->(p1.getX()+p1.getY())-
				(p2.getX()+p2.getY()),
				point-> System.out.print
				("(abs ="+ point.getX() +"," +"ord ="+point.getY()+")"  ));

	}

	public static void traiteListe(List<Point> liste, Predicate<Point> predicate, Comparator<Point> comp,
			Consumer<Point> consumer) {
		// predicate filtree
		List<Point> newlist = new ArrayList<Point>();
		liste.forEach(point -> {
			if (predicate.test(point))
				newlist.add(point);

		});
		// trie
		newlist.sort(comp);
		// affichage

		newlist.forEach(consumer);

	}

}
