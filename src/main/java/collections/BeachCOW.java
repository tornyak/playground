package collections;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class BeachCOW {
    public static void main(String[] args) {
        List<String> items = new CopyOnWriteArrayList<>();
        Collections.addAll(items, "suncream", "mask", "towel", "rage", "razor", "rabbit", "apple");
        for (Iterator<String> it = items.iterator(); it.hasNext(); ) {
            String item = it.next();
            if (item.startsWith("ra")) {
                items.remove(item);
            }
        }
        System.out.println(items);
    }
}
