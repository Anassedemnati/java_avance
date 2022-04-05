package pk1;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Sequence {
    private int[] array;
    public class SubSequence{
        public SubSequence(int lenght){
            if(lenght<=0)throw new IllegalArgumentException("la taille doit etre strictemet positive");
            array= new int[lenght];
            for (int i = 0; i < array.length; i++) {
                array[i]= (int) (Math.random()*1000);
            }

        }
        public int intAt(int index){
            if (index<0||index>=array.length)throw new IllegalArgumentException();
            return array[index];
        }
        public void afficher(){
            System.out.println(Arrays.toString(array));
        }



    }

    public static void main(String[] args) {
        Sequence sequence =new Sequence();
        Sequence.SubSequence subSequence = sequence.new SubSequence(15);
        subSequence.afficher();
        System.out.println(subSequence.intAt(2));
    }

}
