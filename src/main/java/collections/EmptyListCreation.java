package collections;

import java.util.ArrayList;

public class EmptyListCreation {
    private static volatile Object leak;

    // run with -verbose:gc -Xmx1g -Xms1g
    // JCTools - fast collections
    public static void main(String[] args) {
        System.gc();
        for (int i = 0; i < 10_000_000; i++) {
            leak = new ArrayList<>();
        }
        System.gc();
    }
}
