package collections;

import java.util.Properties;

public class PropertiesTest {
    public static void main(String[] args) {
        Properties p = new Properties();
        p.put(1, "one");
        p.put(2, "one");

        p.forEach((k, v) -> {
            if ((int) k < 3) {
                p.put(3, "three"); // It extends a hashtable but from java9 internally it uses ConcurrentHashMap, before it would throw exception but not anymore
            }
        });
    }
}
