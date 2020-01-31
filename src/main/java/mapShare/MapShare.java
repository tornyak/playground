package mapShare;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/*
Modify and return the given map as follows: if the key "a" has a value,
set the key "b" to have that same value. In all cases remove the key "c", leaving the rest of the map unchanged.

mapShare({"a": "aaa", "b": "bbb", "c": "ccc"}) → {"a": "aaa", "b": "aaa"}
mapShare({"b": "xyz", "c": "ccc"}) → {"b": "xyz"}
mapShare({"a": "aaa", "c": "meh", "d": "hi"}) → {"a": "aaa", "b": "aaa", "d": "hi"}
 */
public class MapShare {

    public static Map<String, String> mapShare(Map<String, String> map) {

        String a = "a";
        String b = "b";
        String c = "c";

        HashMap <String, String> newMap = new HashMap<>();
        Set <Map.Entry<String, String>> set = map.entrySet();

        for (Map.Entry<String, String> s:set) {
            newMap.put(s.getKey(),s.getValue());
        }

        if (newMap.containsKey(a)) {
            if (newMap.containsKey(b)) newMap.replace(b, newMap.get(a));
            else newMap.put(b, newMap.get(a));
        }

        if (newMap.containsKey(c)) newMap.remove(c);

        return newMap;
    }

}
