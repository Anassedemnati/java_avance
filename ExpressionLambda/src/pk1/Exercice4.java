package pk1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.IntPredicate;

public class Exercice4 {

	//predicate filtre 
	public static void afficher(int[] t,
			IntPredicate intPredicate) {
		List<Integer> list=new ArrayList<>();
		for (int i:t) {
				if(intPredicate.test(i)) {
					list.add(i);
				}
			
		}
		
		System.out.println(list);
		
	}
	
	
	public static void main(String[] args) {
		int [] tables= {1,-2,5,66,-9,10,22};
		// class annoymre
		afficher(tables,new IntPredicate() {
			
			@Override
			public boolean test(int value) {
				// TODO Auto-generated method stub
				return value>=0;
			}
		});
		//lambda
		afficher(tables,value->value>=0);
		// chiffre pair
		afficher(tables,value->value%2==0);
		
		
	}

}
