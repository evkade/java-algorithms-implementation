package com.jwetherell.algorithms.data_structures.test;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertEquals;


import java.util.Collection;

import org.junit.Test;

import com.jwetherell.algorithms.data_structures.Trie;
import com.jwetherell.algorithms.data_structures.test.common.JavaCollectionTest;
import com.jwetherell.algorithms.data_structures.test.common.TreeTest;
import com.jwetherell.algorithms.data_structures.test.common.Utils;
import com.jwetherell.algorithms.data_structures.test.common.Utils.TestData;

public class TrieTests {

    @Test
    public void testTrie() {
        TestData data = Utils.generateTestData(1000);

        String bstName = "Trie";
        Trie<String> bst = new Trie<String>();
        Collection<String> bstCollection = bst.toCollection();

        assertTrue(TreeTest.testTree(bst, String.class, bstName,
                                     data.unsorted, data.invalid));
        assertTrue(JavaCollectionTest.testCollection(bstCollection, String.class, bstName,
                                                     data.unsorted, data.sorted, data.invalid));

        // test checking that adding an already existing word in the Trie returns null
        Trie<String> trie = new Trie<String>();
    }

    // tests some previously unchecked corner cases in the Trie class
    @Test
    public void testTrieCornerCases() {

        // test adding already existing word => returns null
        Trie<String> trie = new Trie<>();
        trie.add("Hello");
        assertFalse(trie.add("Hello"));

        // test clearing the Trie => size = 0
        trie.clear();
        assertEquals(0, trie.size());

        // test removing in empty tree => returns null
        assertNull(trie.remove("Hello"));
    }

    // tests printing out the Trie to a String
    @Test
    public void testTrieToString() {
        // test printing out the Trie to a String
        Trie<String> trie = new Trie<>();
        trie.add("Hello");
        trie.add("Bram");
        trie.add("House");
        trie.add("Hout");
        System.out.println(trie.toString());
        // Check the standard output, it should look like the right Trie
    }

    // note: I also wanted to test the TriePrinter class directly
    // but it has protected access

}
