package nao.cycledev.jcp.c4.parallelstream;

import java.util.stream.LongStream;
import java.util.stream.Stream;

public class ParallelStream {

    private static void sum(long n) {
        long start = System.currentTimeMillis();
        long sum = Stream
                .iterate(1L, i -> i +1)
                .limit(n)
                .reduce(0L, Long::sum);

        System.out.println("Duration (ms): " + (System.currentTimeMillis() - start));
        System.out.println(sum);
    }

    private static void sumIterative(long n) {
        long start = System.currentTimeMillis();
        long sum = 0L;
        for (long i = 1L; i <= n; i++) {
            sum += i;
        }

        System.out.println("Duration (ms): " + (System.currentTimeMillis() - start));
        System.out.println(sum);
    }

    private static void sumParallel(long n) {
        long start = System.currentTimeMillis();
        long sum = Stream
                .iterate(1L, i -> i +1)
                .limit(n)
                .parallel()
                .reduce(0L, Long::sum);

        System.out.println("Duration (ms): " + (System.currentTimeMillis() - start));
        System.out.println(sum);
    }

    private static void rangeSum(long n) {
        long start = System.currentTimeMillis();
        long sum = LongStream
                .rangeClosed(1, n)
                .reduce(0L, Long::sum);
        System.out.println("Duration (ms): " + (System.currentTimeMillis() - start));
        System.out.println(sum);
    }

    private static void rangeParallelSum(long n) {
        long start = System.currentTimeMillis();
        long sum = LongStream
                .rangeClosed(1, n)
                .parallel()
                .reduce(0L, Long::sum);
        System.out.println("Duration (ms): " + (System.currentTimeMillis() - start));
        System.out.println(sum);
    }

    public static void test(int n) {
        System.out.println("Java 8 sum: ");
        sum(n);

        System.out.println();
        System.out.println("Iterative sum: ");
        sumIterative(n);

        System.out.println();
        System.out.println("Parallel sum: ");
        sumParallel(n);

        System.out.println();
        System.out.println("Range sum: ");
        rangeSum(n);

        System.out.println();
        System.out.println("Range parallel sum: ");
        rangeParallelSum(n);
    }

}
