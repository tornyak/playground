package collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ListTest {

    public static void main(String[] args) {
        List<String> immutableSeasons = List.of("summer", "winter", "spring", "autumn");
        List<String> temp = new ArrayList<>(immutableSeasons);
        List<String> unmodifiableSeasons = Collections.unmodifiableList(temp);

        test(immutableSeasons);
        test(List.copyOf(temp));   // copyOf() added in Java 10
        test(unmodifiableSeasons);
        test(Arrays.asList("summer", "winter", "spring", "autumn"));
        test(temp);
        test(unmodifiableSeasons);


        // RandomAccess interface - since 1.4 constant time lookup support
    }

    public static void test(List<String> seasons) {
        System.out.println(seasons.getClass().getCanonicalName());
        try {
            seasons.add("really hot");
            System.out.println("add worked");
        } catch (UnsupportedOperationException e) {
        }

        try {
            seasons.set(0, "really hot");
            System.out.println("set worked");
        } catch (UnsupportedOperationException e) {
        }
        try {
            seasons.remove(0);
            System.out.println("remove worked");
        } catch (UnsupportedOperationException e) {
        }
        System.out.println(seasons);
        System.out.println();
    }

}
