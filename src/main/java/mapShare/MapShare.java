package mapShare;

import java.util.Map;

/*
Modify and return the given map as follows: if the key "a" has a value,
set the key "b" to have that same value. In all cases remove the key "c", leaving the rest of the map unchanged.

mapShare({"a": "aaa", "b": "bbb", "c": "ccc"}) → {"a": "aaa", "b": "aaa"}
mapShare({"b": "xyz", "c": "ccc"}) → {"b": "xyz"}
mapShare({"a": "aaa", "c": "meh", "d": "hi"}) → {"a": "aaa", "b": "aaa", "d": "hi"}
 */
public class MapShare {

    public static Map<String, String> mapShare(Map<String, String> map) {
        String aVal = map.get("a");
        if (aVal != null) map.put("b", aVal);
        map.remove("c");
        return map;
    }

}
