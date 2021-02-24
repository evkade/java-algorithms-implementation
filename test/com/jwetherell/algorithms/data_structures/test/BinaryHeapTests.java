package com.jwetherell.algorithms.data_structures.test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import org.junit.Test;

import com.jwetherell.algorithms.data_structures.BinaryHeap;
import com.jwetherell.algorithms.data_structures.test.common.JavaCollectionTest;
import com.jwetherell.algorithms.data_structures.test.common.HeapTest;
import com.jwetherell.algorithms.data_structures.test.common.Utils;
import com.jwetherell.algorithms.data_structures.test.common.Utils.TestData;

import static org.junit.Assert.*;

public class BinaryHeapTests {

    @Test
    public void testMinHeap() {
        ArrayList<HashMap<Integer, Integer>>  testBranchLogs = new ArrayList<>();
        TestData data = Utils.generateTestData(2500);

        String aNameMin = "Min-Heap [array]";
        BinaryHeap.BinaryHeapArray<Integer> aHeapMin = new BinaryHeap.BinaryHeapArray<Integer>(BinaryHeap.Type.MIN);
        Collection<Integer> aCollectionMin = aHeapMin.toCollection();
        assertTrue(HeapTest.testHeap(BinaryHeap.Type.MIN, aHeapMin, Integer.class, aNameMin,  
                                     data.unsorted, data.sorted, data.invalid));
        assertTrue(JavaCollectionTest.testCollection(aCollectionMin, Integer.class, aNameMin,
                                                     data.unsorted, data.sorted, data.invalid));

        BinaryHeap.BinaryHeapArray<Integer> aHeapNull = new BinaryHeap.BinaryHeapArray<Integer>(BinaryHeap.Type.MIN);
        aHeapNull.add(10);
        aHeapNull.add(11);
        aHeapNull.clear();
        assertNull(aHeapNull.getHeadValue()); // we expect null here

        String tNameMin = "Min-Heap [tree]";
        BinaryHeap.BinaryHeapTree<Integer> tHeapMin = new BinaryHeap.BinaryHeapTree<Integer>(BinaryHeap.Type.MIN);
        Collection<Integer> tCollectionMin = tHeapMin.toCollection();
        assertTrue(HeapTest.testHeap(BinaryHeap.Type.MIN, tHeapMin, Integer.class, tNameMin,
                                     data.unsorted, data.sorted, data.invalid));
        assertTrue(JavaCollectionTest.testCollection(tCollectionMin, Integer.class, tNameMin,
                                                     data.unsorted, data.sorted, data.invalid));
        testBranchLogs.add(tHeapMin.getHeapDownBranchLog());

        BinaryHeap.BinaryHeapTree<Integer> tHeapNull = new BinaryHeap.BinaryHeapTree<Integer>(BinaryHeap.Type.MIN);
        tHeapNull.add(10);
        tHeapNull.add(11);
        tHeapNull.clear();
        assertNull(tHeapNull.getHeadValue()); // we expect null here

        BinaryHeap.BinaryHeapTree<Integer> tHeapEqual = new BinaryHeap.BinaryHeapTree<Integer>(BinaryHeap.Type.MIN);
        tHeapEqual.add(10);
        tHeapEqual.add(11);
        tHeapEqual.add(9);
        tHeapEqual.add(10);
        tHeapEqual.add(11);
        tHeapEqual.remove(9);
        assertEquals(10, tHeapEqual.getHeadValue());
        testBranchLogs.add(tHeapEqual.getHeapDownBranchLog());

        // write the test branch coverage to the console
        System.out.println(testBranchLogs.size());
        printLogCoverage(testBranchLogs);

    }

    @Test
    public void testMaxHeap() {
        ArrayList<HashMap<Integer, Integer>>  testBranchLogs = new ArrayList<>();
        TestData data = Utils.generateTestData(2500);

        String aNameMax = "Max-Heap [array]";
        BinaryHeap.BinaryHeapArray<Integer> aHeapMax = new BinaryHeap.BinaryHeapArray<Integer>(BinaryHeap.Type.MAX);
        Collection<Integer> aCollectionMax = aHeapMax.toCollection();
        assertTrue(HeapTest.testHeap(BinaryHeap.Type.MAX, aHeapMax, Integer.class, aNameMax, 
                                     data.unsorted, data.sorted, data.invalid));
        assertTrue(JavaCollectionTest.testCollection(aCollectionMax, Integer.class, aNameMax,
                                                 data.unsorted, data.sorted, data.invalid));

        BinaryHeap.BinaryHeapArray<Integer> aHeapNull = new BinaryHeap.BinaryHeapArray<Integer>(BinaryHeap.Type.MAX);
        aHeapNull.add(10);
        aHeapNull.add(11);
        aHeapNull.clear();
        assertNull(aHeapNull.getHeadValue()); // we expect null here

        String lNameMax = "Max-Heap [tree]";
        BinaryHeap.BinaryHeapTree<Integer> tHeapMax = new BinaryHeap.BinaryHeapTree<Integer>(BinaryHeap.Type.MAX);
        Collection<Integer> tCollectionMax = tHeapMax.toCollection();
        assertTrue(HeapTest.testHeap(BinaryHeap.Type.MAX, tHeapMax, Integer.class, lNameMax, 
                                     data.unsorted, data.sorted, data.invalid));
        assertTrue(JavaCollectionTest.testCollection(tCollectionMax, Integer.class, lNameMax,
                                                 data.unsorted, data.sorted, data.invalid));
        testBranchLogs.add(tHeapMax.getHeapDownBranchLog());

        BinaryHeap.BinaryHeapTree<Integer> tHeapNull = new BinaryHeap.BinaryHeapTree<Integer>(BinaryHeap.Type.MAX);
        tHeapNull.add(10);
        tHeapNull.add(11);
        tHeapNull.clear();
        assertNull(tHeapNull.getHeadValue()); // we expect null here

        // write the test branch coverage to the console
        printLogCoverage(testBranchLogs);
    }

    private void printLogCoverage(ArrayList<HashMap<Integer, Integer>> testBranchLogs) {
        for(HashMap<Integer, Integer> log : testBranchLogs) {
            System.out.println('{');
            for(int branch : log.keySet()) {
                System.out.print(String.format("  %d: %d\n", branch, log.getOrDefault(branch, 0)));
            }
            System.out.println('}');
        }
    }
}
