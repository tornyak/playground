package collections;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.stream.IntStream;

public class ComputeIfAbsentTest {

    public static void main(String[] args) {

        // not thread safe
        test(new TreeMap());
        test(new HashMap<>());
        // Thread safe
        test(new ConcurrentHashMap<>());
        test(new ConcurrentSkipListMap<>());
        test(new Hashtable<>());
        test(Collections.synchronizedMap(new HashMap<>()));

        // Weak hash map - weak reference to key, strong reference to values

        // Thread set
        Set<Integer> set = new ConcurrentHashMap<Integer, Integer>().keySet();

        ConcurrentMap<Integer, Collection<String>> map = new ConcurrentHashMap<>();
        put(map, 1, "one");
        put(map, 1, "uno");
        put(map, 1, "eins");
        put(map, 1, "jedan");
        put(map, 1, "en");

    }

    private static void test(Map<Integer, Integer> map) {
        try {
            IntStream.range(0, 1_000_000).parallel().map(i -> map.put(i, i * i));
            System.out.println("Map size: " + map.size());
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }

    private static void put(Map<Integer, Collection<String>> map, int val, String name) {
        map.computeIfAbsent(val, key -> new ArrayList<>()).add(name);
    }
}
