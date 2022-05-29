package pk1;

import java.util.Arrays;
import java.util.List;

import java.util.stream.Stream;
import static java.util.Comparator.comparing;

public class Exercice1 {
	
	
	public static void main(String[] args) {
		
		List<Point> liste = Arrays.asList(
				new Point(4,9),
				new Point(-2,4),
				new Point(9,0),
				new Point(8,-3),
				new Point(2,8),
				new Point(-3,9),
				new Point(-4,5));
		
		Stream<Point> stream = liste.stream()
									.filter(p->p.getX()>=0)
									.sorted(comparing(Point::getX))
									
									;
		List<Point> l1 = stream.toList();
		l1.forEach(p->System.out.print("["+p.getX()+","+ p.getY()+"]"));
		
		//stream.forEach(System.out::print);
		
		System.out.println();
		Stream<Point> stream2 = liste.stream()
									.sorted(comparing(Point::calculerSomme));
									//.map(p-> "(abs = "+p.getX()+", ord = "+ p.getY()+")");
		List<Point> l2 = stream2.toList();
		l2.forEach(p->System.out.print("(abs = "+p.getX()+", ord = "+ p.getY()+")"));
		//stream2.forEach(System.out::print);
	
	}
	
}
