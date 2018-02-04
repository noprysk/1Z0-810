package nao.cycledev.jcp.c2.builtinlambda;

import java.util.function.Predicate;

public class PredicateTest {

  public static void test() {
    Predicate<String> pred = s -> s.length() > 5;
    System.out.println(pred.test("Java8 is good"));
    System.out.println(pred.test("Java"));
  }
}
