package pk1;

import java.util.ArrayList;
import java.util.List;
import java.util.function.IntPredicate;

public class exercice4 {
    //pridicate filter
    public static void afficher(int[] tab,IntPredicate intPredicate){
        List<Integer> newList = new ArrayList<>();
        for (int i : tab){
            if (intPredicate.test(i)){
                newList.add(i);
            }
        }
        System.out.println(newList);
    }


    public static void main(String[] args) {
        int[] tab = {1,5,9,10,89,2};
        afficher(tab, new IntPredicate() {
            @Override
            public boolean test(int value) {
                return value>=0;
            }
        });
        afficher(tab,value->value>=0);
        System.out.println("----------------------aficher le nombre paire----------------------");
        afficher(tab,value->value%2==0);
    }



}
