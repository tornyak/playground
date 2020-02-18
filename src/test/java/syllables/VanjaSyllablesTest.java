package syllables;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class VanjaSyllablesTest {

    @Test
    public void getNumbSyllables() {

        assertEquals("Mrs",0,VanjaSyllables.getNumbSyllables("Mrs"));
        assertEquals("1",0,VanjaSyllables.getNumbSyllables("t"));

        assertEquals("segue",2,VanjaSyllables.getNumbSyllables("segue"));
        assertEquals("the",1,VanjaSyllables.getNumbSyllables("the"));
        assertEquals("fly",1,VanjaSyllables.getNumbSyllables("fly"));
        assertEquals("yes",1,VanjaSyllables.getNumbSyllables("yes"));
        assertEquals("cave",1,VanjaSyllables.getNumbSyllables("cave"));
        assertEquals("double",1,VanjaSyllables.getNumbSyllables("double"));


        assertEquals("contiguous",3,VanjaSyllables.getNumbSyllables("contiguous"));
        assertEquals("sleepy",2,VanjaSyllables.getNumbSyllables("sleepy"));
        assertEquals("obvious",2,VanjaSyllables.getNumbSyllables("obvious"));
        assertEquals("toga",2,VanjaSyllables.getNumbSyllables("toga"));
        assertEquals("yellow",2,VanjaSyllables.getNumbSyllables("yellow"));

        assertEquals("This",1,VanjaSyllables.getNumbSyllables("This"));
        assertEquals("is",1,VanjaSyllables.getNumbSyllables("is"));
        assertEquals("a",1,VanjaSyllables.getNumbSyllables("a"));
        assertEquals("test",1,VanjaSyllables.getNumbSyllables("test"));
        assertEquals("How",1,VanjaSyllables.getNumbSyllables("How"));
    }
}