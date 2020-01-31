package collections;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LotsOfNumbers {

    public static void main(String[] args) {
        int[] ints = ThreadLocalRandom.current().ints(10_000_000).toArray();
        List<Integer> integers = IntStream.of(ints).boxed().collect(Collectors.toList());

        for (int i = 0; i < 10; i++) {
            sortSequential(integers);
            sortParallel(integers);
            sortSequential(ints);
            sortParallel(ints);
        }
    }


    private static void sortSequential(List<Integer> integers) {
        ArrayList<Integer> clone = new ArrayList<>(integers);

        long time = System.nanoTime();
        try {
            clone.sort(null);
        } finally {
            time = System.nanoTime() - time;
            System.out.printf("list sequential time = %dms%n", (time / 1_000_000));
        }
    }

    private static void sortParallel(List<Integer> integers) {
        ArrayList<Integer> clone = new ArrayList<>(integers);

        long time = System.nanoTime();
        try {
            parallelSort(clone, null);
        } finally {
            time = System.nanoTime() - time;
            System.out.printf("list parallel time = %dms%n", (time / 1_000_000));
        }
    }

    private static <E> void parallelSort(List<E> list, Comparator<? super E> c) {
        Object[] a = list.toArray();
        Arrays.parallelSort(a, (Comparator) c);
        ListIterator<E> i = list.listIterator();
        for (Object e : a) {
            i.next();
            i.set((E) e);
        }
    }

    private static void sortSequential(int[] ints) {
        int[] clone = ints.clone();

        long time = System.nanoTime();
        try {
            Arrays.sort(clone);
        } finally {
            time = System.nanoTime() - time;
            System.out.printf("array sequential time = %dms%n", (time / 1_000_000));
        }
    }

    private static void sortParallel(int[] ints) {
        int[] clone = ints.clone();

        long time = System.nanoTime();
        try {
            Arrays.parallelSort(clone);
        } finally {
            time = System.nanoTime() - time;
            System.out.printf("parallel time = %dms%n", (time / 1_000_000));
        }
    }
}
