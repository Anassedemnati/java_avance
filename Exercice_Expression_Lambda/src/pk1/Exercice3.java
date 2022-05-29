package pk1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class Exercice3 {
    public static void main(String[] args) {
        List<Integer> integerList = Arrays.asList(4,5,5,6,0,3);
        System.out.println(integerList);
        ajouter4(integerList,i->i+4);
        System.out.println(integerList);
        ajouter4(integerList,i->i*i);
        System.out.println(integerList);

        List<String> stringList = Arrays.asList("Emsi","EmsiO","EmsiA","EmsiR","EmsiTH","EmsiAG","");
        //List<Integer> lesTailles= map(stringList,s->s.length());
        List<Integer> lesTailles= map(stringList,String::length);
        System.out.println(stringList);
        System.out.println(lesTailles);


    }
    public static void ajouter4(List<Integer> list , Function<Integer,Integer> function){
        for (int i = 0; i < list.size(); i++) {

            //list.set(i, list.get(i)+4);
            list.set(i, function.apply(list.get(i)));
        }

    }
    public static List<Integer> map(List<String> list,Function<String,Integer> function){
        List<Integer> newList = new  ArrayList<Integer>();
        list.forEach(s-> newList.add(function.apply(s))
        );
        return newList;
    }
}
