package pk1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

public class Exercice3 {

	public static void main(String[] args) {
System.out.println("**************Question 1********************");
		List<Integer> liste = Arrays.asList(4, 8, 5, 3, 6, 9);
		System.out.println(liste);

		ajouter4(liste, k -> k + 4);
		System.out.println(liste);
		
		List<String> listeString=Arrays.asList("saad","youssef","karim");
		List<Integer> listeInteger=map(listeString,s->s.length());
		List<Integer> listeInteger1=map(listeString,String::length);
		
		System.out.println(listeString);
		System.out.println(listeInteger);
		
		Map<Color,String> colorToString=map2(color->color.name().toLowerCase());
		System.out.println(colorToString);
	}	
	
	public static enum Color { RED, GREEN}
	
	public static Map<Color,String> map2(Function<Color,String> function){
		Map<Color,String> map=new HashMap<Color, String>();
		
		for(Color color: Color.values()) {
			map.put(color, function.apply(color));
			
		}
		return  map;
		
	}
	

	public static void ajouter4(List<Integer> liste, 
			Function<Integer, Integer> function) {

		for (int i = 0; i < liste.size(); i++) {
			liste.set(i, function.apply(liste.get(i)));
		}

	}
	
	public static List<Integer> map(List<String> listeString, 
			Function <String,Integer> function) {
		List<Integer> liste = new ArrayList<Integer>();
		
		listeString.forEach(s ->liste.add(function.apply(s)) );
		
		return liste;
		
		
		
	}

}
