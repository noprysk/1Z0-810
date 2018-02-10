package nao.cycledev.jcp.c3.filtercollections;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class TransactionOperationsTest {

    private List<Transaction> transactions;

    @Before
    public void setUp(){
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario","Milan");
        Trader alan = new Trader("Alan","Cambridge");
        Trader brian = new Trader("Brian","Cambridge");

        transactions = Arrays.asList(
            new Transaction(brian, 2011, 300),
            new Transaction(raoul, 2012, 1000),
            new Transaction(raoul, 2011, 400),
            new Transaction(mario, 2012, 710),
            new Transaction(mario, 2012, 700),
            new Transaction(alan, 2012, 950)
        );
    }

    @Test
    public void test() {

        List<Transaction> trans = transactions.stream()
                .filter(t -> t.getYear() == 2011)
                .sorted(Comparator.comparingInt(Transaction::getValue))
                .collect(Collectors.toList());

        System.out.println("1. Find all for 2011 year: " + trans);
        System.out.println("---------------------------------");

        List<String> cities = transactions.stream()
                .map(t -> t.getTrader().getCity())
                .distinct()
                .collect(Collectors.toList());
        System.out.println("2. Cities: " + cities);
        System.out.println("---------------------------------");

        List<Trader> traders = transactions.stream()
                .map(Transaction::getTrader)
                .filter(t -> t.getCity().equalsIgnoreCase("Cambridge"))
                .distinct()
                .sorted(Comparator.comparing(Trader::getName))
                .collect(Collectors.toList());
        System.out.println("3. Traders from Cambridge: " + traders);
        System.out.println("---------------------------------");

        String names = transactions.stream()
                .map(Transaction::getTrader)
                .map(Trader::getName)
                .distinct()
                .sorted()
                .collect(Collectors.joining(", "));
        System.out.println("4. Traders names: " + names);
        System.out.println("---------------------------------");


        Boolean isMilan = transactions.stream()
                .anyMatch(t -> t.getTrader().getCity().equalsIgnoreCase("Milan"));

        System.out.println("5. Are any from Milan: " + isMilan);
        System.out.println("---------------------------------");

        String values = transactions.stream()
                .filter(t -> t.getTrader().getCity().equalsIgnoreCase("Cambridge"))
                .map(t -> String.valueOf(t.getValue()))
                .collect(Collectors.joining(", "));
        System.out.println("6. Trans values: " + values);
        System.out.println("---------------------------------");

        Optional<Transaction> transaction = transactions.stream()
                .max(Comparator.comparingInt(Transaction::getValue));
        System.out.print("7. Highest transaction : ");
        transaction.ifPresent(System.out::println);
        System.out.println("---------------------------------");

        Optional<Transaction> transactionMin = transactions.stream()
                .min(Comparator.comparingInt(Transaction::getValue));
        System.out.print("8. Minimum transaction : ");
        transactionMin.ifPresent(System.out::println);
        System.out.println("---------------------------------");
    }

}