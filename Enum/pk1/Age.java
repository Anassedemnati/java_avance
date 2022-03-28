package pk1;

import java.util.EnumSet;
import java.util.Iterator;

public enum Age {
	ADULTE,JEUNE(18),MURE(30),AGEE(50),VIEUX(70); // fianl static
	 final private int annee;
	 
	 private Age() {
		 annee=15;
	 }
	 
	 private Age(int annee) {
		 this.annee=annee;
	 }
	 
	 @Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.name()+" "+this.ordinal();
	}
	
	public static void main(String[] args) {
		Age age= Age.AGEE;
		Age age1=JEUNE;
		String s = Age.JEUNE.name();
		String s1="MURE";
		Age age3=Age.valueOf(s1);
		
		
		Age[] ages = Age.values();
		EnumSet<Age> ages2 = EnumSet.allOf(Age.class);
		
		
		System.out.println(Age.MURE.name());
		System.out.println(Age.JEUNE);
		System.out.println(age3.name());
		
		System.out.println("\n**************************");
		for (Age age2 : ages) {
			System.out.println(age2.name());
		}
		
		
		System.out.println("\n**************************");

		for (Iterator<Age> iterator = ages2.iterator(); iterator.hasNext();) {
			Age age2 =  iterator.next();
			System.out.println(age2);
			
		}
		
		ages2.remove(Age.ADULTE);
		ages2.remove(Age.JEUNE);

		
		System.out.println("\n**************************");

		for (Iterator<Age> iterator = ages2.iterator(); iterator.hasNext();) {
			Age age2 =  iterator.next();
			System.out.println(age2);
			
		}
		
	}

}
