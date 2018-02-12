package nao.cycledev.jcp;

import nao.cycledev.jcp.c4.parallelstream.ParallelStream;

public class MainApp {
  public static void main(String[] args) {
    ParallelStream.test(10_000_000);
  }
}
