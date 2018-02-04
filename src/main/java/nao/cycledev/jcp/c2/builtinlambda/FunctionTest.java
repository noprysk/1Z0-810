package nao.cycledev.jcp.c2.builtinlambda;

import java.util.function.Function;

public class FunctionTest {

  public static void test() {
    Function<String, Boolean> func = Boolean :: new;
    System.out.println(func.apply("TRUE"));
    System.out.println(func.apply("true"));
    System.out.println(func.apply("Java8"));
    System.out.println(func.apply(null));
  }

}
