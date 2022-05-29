package pk1;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class Exercice1 {

	public static void main(String[] args) {
		System.out.println("************Question 1************");
		Consumer<Integer> consumer = new Consumer<Integer>() {
			@Override
			public void accept(Integer t) {
				System.out.println(t);
			}

		};
		
		
		Consumer<Integer> consumer2 = t->System.out.println(t);
		consumer2 = System.out::println;
		int i = 5;
		consumer.accept(i);
		consumer2.accept(i);
		
		
		System.out.println("************Question 2************");
		List<Integer> listeInt = Arrays.asList(4,8,3,6,9,5);
		afficher(listeInt, System.out::println);
		System.out.println("************Question 3************");
		afficher(listeInt, k->System.out.print(k*2+" "));
	}
	
	
	public static void afficher(List<Integer> liste, 
			Consumer<Integer> consumer) {
		liste.forEach(consumer);
		//liste.forEach(i->consumer.accept(i));
		
		
	}

}
