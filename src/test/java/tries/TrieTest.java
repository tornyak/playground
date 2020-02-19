package tries;

import org.junit.Test;
import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class TrieTest {
    @Test
    public void putTest() {
        Trie<Integer> trie=new Trie<>();

        int counter=0;
        trie.put("she",counter++);
        trie.put("sells",counter++);
        trie.put("sea",counter++);
        trie.put("shells",counter++);
        trie.put("by",counter++);
        trie.put("the",counter++);
        trie.put("sea",counter++);
        trie.put("shore",counter++);
        trie.keys().forEach(System.out::println);

        int value= trie.get("sea");
        assertEquals(6,value);
    }

    @Test
    public void deleteTest() {
        Trie<Integer> trie=new Trie<>();

        int counter=0;
        trie.put("she",counter++);
        trie.put("sells",counter++);
        trie.put("sea",counter++);
        trie.put("shells",counter++);
        trie.put("by",counter++);
        trie.put("the",counter++);
        trie.put("sea",counter++);
        trie.put("shore",counter++);
        trie.keys().forEach(System.out::println);

        trie.delete("sea");
        trie.keys().forEach(System.out::println);
    }


}