package pk1;

import java.util.Iterator;

public class Eleve {
	public Eleve(String nom, int[] note) {
		this.nom = nom;
		this.note = note;
		determinerAdmissibilite();
	}
	private String nom;
	private int[] note;
	private Admissibilite adm;
	
	public enum Admissibilite{
		 N ("non admis",0,10), P ("passable",10,12), AB ( "Assez bien",12,14), B ("Bien",14,16), TB ("Très bien",16,21);
		private final String adm;
		private final int min, max;
	private Admissibilite(String adm, int min, int max) {
		this.adm=adm;
		this.min=min;
		this.max=max;
	}
	
	}
	public double calculerMoyenne() {
		double som=0;
		for (int i : note) {
			som+=i;
		}
		return som/note.length;
	}
	public void determinerAdmissibilite() {
		double moyenne= calculerMoyenne();
		for (Admissibilite adm1 : Admissibilite.values()) {
			if(moyenne >= adm1.min && moyenne <adm1.max) {
				this.adm=adm1;
				return ;
			}
		}
	}
	@Override
	public String toString() {
		return "Eleve [nom=" + nom + ", adm=" + adm + ", calculerMoyenne()=" + calculerMoyenne() + "]";
	}
	
	
}
