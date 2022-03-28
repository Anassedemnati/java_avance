package pk1;

public enum Jour {
	LUNDI,MARDI,MERCREDI,JEUDI,VENDREDI,SAMEDI,DIMANCHE;
	boolean travail=true;
	private Jour(){
		if(ordinal()>=5)
			travail=false;
	}
	public static void main(String[] args) {
		for (Jour j : Jour.values()) {
			System.out.println(j.name() + " " + j.travail);
			
		}
	}
}
