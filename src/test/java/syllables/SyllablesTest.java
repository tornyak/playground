package syllables;

import org.junit.Test;

import static org.junit.Assert.*;

public class SyllablesTest {

    @Test
    public void getNumbSyllables() {


        assertEquals("Mrs",0,Syllables.getNumbSyllables("Mrs"));
        assertEquals("1",0,Syllables.getNumbSyllables("t"));

        assertEquals("segue",2,Syllables.getNumbSyllables("segue"));
        assertEquals("the",1,Syllables.getNumbSyllables("the"));
        assertEquals("fly",1,Syllables.getNumbSyllables("fly"));
        assertEquals("yes",1,Syllables.getNumbSyllables("yes"));
        assertEquals("cave",1,Syllables.getNumbSyllables("cave"));
        assertEquals("double",1,Syllables.getNumbSyllables("double"));


        assertEquals("contiguous",3,Syllables.getNumbSyllables("contiguous"));
        assertEquals("sleepy",2,Syllables.getNumbSyllables("sleepy"));
        assertEquals("obvious",2,Syllables.getNumbSyllables("obvious"));
        assertEquals("toga",2,Syllables.getNumbSyllables("toga"));
        assertEquals("yellow",2,Syllables.getNumbSyllables("yellow"));

        assertEquals("This",1,Syllables.getNumbSyllables("This"));
        assertEquals("is",1,Syllables.getNumbSyllables("is"));
        assertEquals("a",1,Syllables.getNumbSyllables("a"));
        assertEquals("test",1,Syllables.getNumbSyllables("test"));
        assertEquals("How",1,Syllables.getNumbSyllables("How"));

/*
16

"This is a test.  How many???  "
		        + "Senteeeeeeeeeences are here... there should be 5!  Right?"
 */



    }
}