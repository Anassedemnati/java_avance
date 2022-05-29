package ex2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Ex2 {
    public static void main(String[] args) {
        //Soient les objets :
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");

        List<Transaction> transactions = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );
        //1-Récupérer les transactions effectuées en 2011, trier le résultat en fonction de leur valeur(value) ;
        System.out.println("1-\tRécupérer les transactions effectuées en 2011, trier le résultat en fonction de leur valeur(value) ");
        List<Transaction> transactionsIn2011 = transactions.stream()
                .sorted(Comparator.comparing(Transaction::getValue))
                .filter(transaction -> transaction.getYear() == 2011)
                .toList();
        System.out.println(transactionsIn2011);
        //[Trader:Brian in Cambridge, year : 2011, value: 300, Trader:Raoul in Cambridge, year : 2011, value: 400]
        //2-	Récupérer toutes les villes (sans les doublons) dont les «traders » travaillent ;
        System.out.println("//2-\tRécupérer toutes les villes (sans les doublons) dont les «traders » travaillent ;");
        List<String> listevilleUnique = transactions.stream()
                .map(transaction -> transaction.getTrader().getCity())
                .distinct()
                .toList();
        System.out.println(listevilleUnique);
        //3-	Récupérer tous les « traders » résidant dans Cambridge, trier les en fonction du name ;
        System.out.println(" //3-\tRécupérer tous les « traders » résidant dans Cambridge, trier les en fonction du name ;");
        List<Transaction> transactionsFromCambridge = transactions.stream()
                .filter(transaction -> transaction.getTrader().getCity().equals("Cambridge"))
                .sorted((Transaction tr1, Transaction tr2) -> tr1.getTrader().getName().compareTo(tr2.getTrader().getName()))
                .toList();
        System.out.println(transactionsFromCambridge);
        //4-	Récupérer les noms des « traders » triés par l’ordre alphabétique ;
        System.out.println("4-\tRécupérer les noms des « traders » triés par l’ordre alphabétique ;");
        List<String> ListOftraderOrder = transactions.stream()
                .map(transaction -> transaction.getTrader().getName())
                .sorted()
                .toList();
        System.out.println(ListOftraderOrder);
        //5-	Y’a-t-il un trader résidant à Milan ?
        System.out.println("5-\tY’a-t-il un trader résidant à Milan ?");
        boolean Ifmilan = transactions.stream()
                .anyMatch(transaction -> transaction.getTrader().getCity().equals("Milan"));
        System.out.println("trader résidant à Milan "+Ifmilan);
        //6-	Renvoyer le maximum des transactions ;
        System.out.println("6-\tRenvoyer le maximum des transactions ;");
        Integer MaxTransaction = transactions.stream()
                .map(transaction -> transaction.getValue())
                .reduce(transactions.get(0).getValue(), (tr1, tr2) -> Math.max(tr1, tr2));
        System.out.println(MaxTransaction);
        //7-	Trouver la valeur minimale des transactions.
        System.out.println("Trouver la valeur minimale des transactions.");
        Integer MinTransaction = transactions.stream()
                .map(transaction -> transaction.getValue())
                .reduce(transactions.get(0).getValue(), (tr1, tr2) -> Math.min(tr1, tr2));
        System.out.println(MinTransaction);


    }


}
