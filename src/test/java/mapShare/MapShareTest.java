package mapShare;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.Map;

import static org.junit.Assert.*;
/*
Modify and return the given map as follows: if the key "a" has a value,
set the key "b" to have that same value. In all cases remove the key "c", leaving the rest of the map unchanged.

mapShare({"a": "aaa", "b": "bbb", "c": "ccc"}) → {"a": "aaa", "b": "aaa"}
mapShare({"b": "xyz", "c": "ccc"}) → {"b": "xyz"}
mapShare({"a": "aaa", "c": "meh", "d": "hi"}) → {"a": "aaa", "b": "aaa", "d": "hi"}
*/

public class MapShareTest {

    @Test
    public void mapShare1() {
        Map<String, String> map = Map.of("a", "aaa", "b", "bbb", "c", "ccc");
        Map<String, String> expected = Map.of("a", "aaa", "b", "aaa");
        Map<String, String> mapReturn = MapShare.mapShare(map);

        //1. Test equal, ignore order
        assertThat(mapReturn, is(expected));
        //2. Test size
        assertThat(mapReturn.size(), is(2));
    }

    @Test
    public void mapShare2() {
        Map<String, String> map = Map.of( "b", "xzy", "c", "ccc");
        Map<String, String> expected = Map.of( "b", "xzy");
        Map<String, String> mapReturn = MapShare.mapShare(map);

        //1. Test equal, ignore order
        assertThat(mapReturn, is(expected));
        //2. Test size
        assertThat(mapReturn.size(), is(1));
    }

    @Test
    public void mapShare3() {
        Map<String, String> map = Map.of("a", "aaa", "c", "meh", "d", "hi");
        Map<String, String> expected = Map.of("a", "aaa", "b", "aaa", "d", "hi");
        Map<String, String> mapReturn = MapShare.mapShare(map);

        //1. Test equal, ignore order
        assertThat(mapReturn, is(expected));
        //2. Test size
        assertThat(mapReturn.size(), is(3));
    }

}