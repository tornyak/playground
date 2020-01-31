package collections;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LotsOfNumbersAsSet {

    public static void main(String[] args) {
        int[] ints = ThreadLocalRandom.current().ints(10_000_000).toArray();


        Set<Integer> hashSet;
        long time = System.nanoTime();
        try {
            hashSet = IntStream
                    .of(ints).boxed()
                    .collect(Collectors.toCollection(HashSet::new));
            System.out.println(hashSet.size());
        } finally {
            time = System.nanoTime() - time;
            System.out.printf("HashSet time = %dms%n", (time / 1_000_000));
        }

        Set<Integer> treeSet;
        time = System.nanoTime();
        try {
            treeSet = IntStream
                    .of(ints).boxed()
                    .collect(Collectors.toCollection(TreeSet::new));
            System.out.println(treeSet.size());
        } finally {
            time = System.nanoTime() - time;
            System.out.printf("TreeSet time = %dms%n", (time / 1_000_000));
        }


        time = System.nanoTime();
        try {
            long total = 0;
            for (int val : ints) {
                if (hashSet.contains(val)) {
                    total += val;
                }
            }
        } finally {
            time = System.nanoTime() - time;
            System.out.printf("HashSet lookup time = %dms%n", (time / 1_000_000));
        }

        time = System.nanoTime();
        try {
            long total = 0;
            for (int val : ints) {
                if (treeSet.contains(val)) {
                    total += val;
                }
            }
        } finally {
            time = System.nanoTime() - time;
            System.out.printf("TreeSet lookup time = %dms%n", (time / 1_000_000));
        }

        // Addd also for ConcurrentSkipListSet
    }

}
