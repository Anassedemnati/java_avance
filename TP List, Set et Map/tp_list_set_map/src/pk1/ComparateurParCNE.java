package pk1;

import java.util.Comparator;

public class ComparateurParCNE implements Comparator<Etudiant> {
    @Override
    public int compare(Etudiant o1, Etudiant o2) {
        return o1.CNE-o2.CNE;
    }

    @Override
    public Comparator<Etudiant> reversed() {
        return Comparator.super.reversed();
    }
}
