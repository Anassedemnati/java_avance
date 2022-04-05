package pk2;

public class Externe {
    private int i =5;
    private static int cpt = 0;
    Interne interne = new Interne();
    public static class Interne{
        public void afficher(){
            //System.out.println(i);
            System.out.println(cpt);
        }
    }

    public static void main(String[] args) {
        Externe.Interne interne = new Interne();
    }



}
