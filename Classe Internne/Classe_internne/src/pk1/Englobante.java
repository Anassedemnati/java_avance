package pk1;

public class Englobante {
    Internne internne = new Internne();
    private int i=5;
    public void afficher(){
        System.out.println( i+": i");
    }
    public class Internne{
        private int k=i;

        public void afficher(){
            System.out.println(this);
            System.out.println(Englobante.this);
        }
    }

    public static void main(String[] args) {
        Englobante englobante = new Englobante();
        Englobante.Internne internne = englobante.new Internne();
        internne.afficher();
    }



}
