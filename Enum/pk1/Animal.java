package pk1;

public enum Animal {
	CHAT, CHIEN, CHEVAL, POISSON, GIRAFE;
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.name() + " " + this.ordinal();
	}
	
	
	
	public static void main(String[] args) {
		Animal a=Animal.CHAT;
		Animal a2=Animal.CHIEN;
		System.out.println(a.toString());
		Animal a3=Animal.valueOf("CHEVAL");
		System.out.println(a3.toString());

		for (Animal a4 : Animal.values()) {
			System.out.println(a4.name());

		}
		System.out.println(a.compareTo(a3));
	}
}
