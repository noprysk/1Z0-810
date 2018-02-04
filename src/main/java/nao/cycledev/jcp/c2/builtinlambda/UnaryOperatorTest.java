package nao.cycledev.jcp.c2.builtinlambda;

import java.util.function.UnaryOperator;

public class UnaryOperatorTest {

  public static void test() {
    UnaryOperator<String> un = s -> s + " is great!";
    System.out.println(un.apply("test"));
  }
}
