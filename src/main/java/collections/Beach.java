package collections;

import java.util.*;

public class Beach {
    public static void main(String[] args) {
        Vector<String> items = new Vector<>();
        Collections.addAll(items, "suncream", "mask", "towel", "rage", "razor", "rabbit", "apple");
        Enumeration<String> en = items.elements();
        while (en.hasMoreElements()) {
            String item = en.nextElement();
            //if(item.startsWith("ra")) items.remove(item); // will skip razor when rage removed
        }


        Iterator<String> it = items.iterator();
        while (it.hasNext()) {
            String item = it.next();
            // if(item.startsWith("ra")) items.remove(item); // concurrent modification exception
        }

        for (String item : items) {
            // if(item.startsWith("ra")) items.remove(item); // concurrent modification exception
        }

        it = items.iterator();
        while (it.hasNext()) {
            String item = it.next();
            if (item.startsWith("ra")) it.remove();
        }


        ArrayList<String> grainList = new ArrayList<>();
        for (int grains = 1000; grains <= 10_000_000; grains *= 2) {
            long time = System.nanoTime();
            try {
                for (int i = 0; i < grains; i++) {
                    grainList.add("grain_of_sand");
                }
                it = grainList.iterator();
                while (it.hasNext()) {
                    String item = it.next();
                    if (item.equals("grain_of_sand")) it.remove();
                }
                // java8 much much faster :-)
                grainList.removeIf(item -> item.equals("grain_of_sand"));
                System.out.println(items);
            } finally {
                time = System.nanoTime() - time;
                System.out.printf("grains %d time = %dms%n", grains, (time / 1_000_000));
            }
        }
    }
}
