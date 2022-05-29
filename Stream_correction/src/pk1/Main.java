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
List<Point> liste = Arrays.asList(new Point(4,9),
		new Point(-2,4),
		new Point(9,0),
		new Point(8,-3),
		new Point(2,8),
		new Point(-3,9),
		new Point(-4,5));


traiteListe(liste, 
		point-> point.getX()>=0,
		//(p1,p2)->p1.getX()-p2.getX(),
		comparing(Point::getX),
		point-> System.out.print("["+point.getX()+","+ point.getY()+"]" )
		);
System.out.println("\n**********************************");

traiteListe(liste, 
		point-> true,
		//(p1,p2)->(p1.getX()+p1.getY())-(p2.getX()+p2.getY()),
		comparing(Point::calculerSomme),
		point-> System.out.print("(abs = "+point.getX()+", ord = "+ point.getY()+")" )
		
		
		);


	}

	
	
	public static void traiteListe (List<Point> liste, 
			Predicate<Point> predicate, 
			Comparator<Point> comparator, 
			Consumer<Point> consumer) {
		
		
		List<Point> newList = new ArrayList<Point>();
		liste.forEach(point->{
			if(predicate.test(point))
				newList.add(point);
		});
		
		newList.sort(comparator);
		
		//newList.forEach(consumer);
		newList.forEach(point->consumer.accept(point));
		
		
		
	}

}
