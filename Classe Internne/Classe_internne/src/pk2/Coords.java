package pk2;

public class Coords {
    private Pair[] tarjet={
            new Pair(5,3),
            new Pair(6,7),
            new Pair(2,3),
            new Pair(9,4)

    };
    public static Pair newPair(int x,int y){
        return new Pair(x,y);
    }
    public static class Pair{
        private int x,y;
         public Pair(int x,int y){
         this.x=x;
         this.y=y;
         }

        @Override
        public String toString() {
            return "Pair{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }
    }

    public static void main(String[] args) {
        Coords.Pair pair = new Pair(5,6);
        Coords.Pair pair1 = Coords.newPair(5,9);
        System.out.println(pair);
        System.out.println(pair1);

    }
}
