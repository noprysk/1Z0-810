package nao.cycledev.jcp.c2.builtinlambda;

import lombok.ToString;

import java.util.function.Supplier;

@ToString
class Book {
  private String title;
  private String auther;

  public Book(String title, String auther) {
    this.title = title;
    this.auther = auther;
  }
}

public class SupplierTest {

  public static void test() {
    Supplier<Book> s1 = () -> new Book("book1", "auther1");
    Supplier<Book> s2 = () -> new Book("book2", "auther2");

    System.out.println(s1.get());
    System.out.println(s2.get());
  }
}
