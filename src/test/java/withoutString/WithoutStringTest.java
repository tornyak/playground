package withoutString;

import org.junit.Test;

import static org.junit.Assert.*;
/*
Given two strings, base and remove, return a version of the base string
where all instances of the remove string have been removed (not case sensitive).
You may assume that the remove string is length 1 or more.
Remove only non-overlapping instances, so with "xxx" removing "xx" leaves "x".

withoutString("Hello there", "llo") → "He there"
withoutString("Hello there", "e") → "Hllo thr"
withoutString("Hello there", "x") → "Hello there"
withoutString("THIS is a FISH", "iS") → "TH a FH"
*/

public class WithoutStringTest {

    @Test
    public void withoutString1() {
        String base="Hello there";
        String remove="llo";
        assertEquals("He there",WithoutString.withoutString(base,remove));
    }
    @Test
    public void withoutString2() {
        String base="Hello there";
        String remove="e";
        assertEquals("Hllo thr",WithoutString.withoutString(base,remove));
    }
    @Test
    public void withoutString3() {
        String base="Hello there";
        String remove="x";
        assertEquals("Hello there",WithoutString.withoutString(base,remove));
    }
    @Test
    public void withoutString4() {
        String base="Hellollo there";
        String remove="llo";
        assertEquals("He there",WithoutString.withoutString(base,remove));
    }
    @Test
    public void withoutString5() {
        String base="llollo";
        String remove="llo";
        assertEquals("",WithoutString.withoutString(base,remove));
    }
    @Test
    public void withoutString6() {
        String base="";
        String remove="llo";
        assertEquals("",WithoutString.withoutString(base,remove));
    }
    @Test
    public void withoutString7() {
        String base="THIS is a FISH";
        String remove="iS";
        assertEquals("TH  a FH",WithoutString.withoutString(base,remove));
    }
}