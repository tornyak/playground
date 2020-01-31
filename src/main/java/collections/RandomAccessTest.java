package collections;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.RandomAccess;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RandomAccessTest {

    public static void main(String[] args) {
        RandomAccess[] ra = {
                new ArrayList<>(),
                new CopyOnWriteArrayList<>()
        };

        List<Integer> largeList = IntStream.range(0, 10_000_000).boxed().collect(Collectors.toCollection(ArrayList::new));
        List<Integer> largeLinkedList = IntStream.range(0, 10_000_000).boxed().collect(Collectors.toCollection(LinkedList::new));
        List<Integer> largeCopyOnWriteList = new CopyOnWriteArrayList<>(largeList);

        measureRandomAccessTime(largeList);
        measureRandomAccessTime(largeCopyOnWriteList);
        measureRandomAccessTime(largeLinkedList);
    }

    public static void measureRandomAccessTime(List<Integer> list) {
        long time = System.nanoTime();
        try {
            long total = 0;
            for (int i = 0; i < 1_000; i++) {
                total += list.get(5_000_001);
            }
            System.out.println("total = " + total);
        } finally {
            time = System.nanoTime() - time;
            System.out.printf("time = %dms%n", (time / 1_000_000));
        }
    }
}
