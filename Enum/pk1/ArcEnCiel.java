package pk1;

public enum ArcEnCiel {

	ROUGE, ORANGE, JAUNE, VERT, BLEU, INDIGO, VIOLET;
	public static ArcEnCiel suivant(ArcEnCiel a) {
		int pos = (a.ordinal()+1)%ArcEnCiel.values().length;
		
		return ArcEnCiel.values()[pos];
	}
	public static void main(String[] args) {
		System.out.println(suivant(ArcEnCiel.VIOLET));
	}
}
