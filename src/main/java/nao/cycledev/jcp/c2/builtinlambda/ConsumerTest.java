package nao.cycledev.jcp.c2.builtinlambda;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class ConsumerTest {

  private static void processList(List<String> list, Consumer<String> cons) {
    for (String item : list) {
      cons.accept(item);
    }
  }

  public static void test() {
    Consumer<String> c = s -> System.out.print(String.format("%s ", s));
    List<String> l = Arrays.asList("Java", "8", "is", "great", "!");
    processList(l, c);
  }
}
