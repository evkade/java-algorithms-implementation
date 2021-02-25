package com.jwetherell.algorithms.data_structures.test;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.jwetherell.algorithms.data_structures.HashMap;
import com.jwetherell.algorithms.data_structures.test.common.JavaMapTest;
import com.jwetherell.algorithms.data_structures.test.common.MapTest;
import com.jwetherell.algorithms.data_structures.test.common.Utils;
import com.jwetherell.algorithms.data_structures.test.common.Utils.TestData;

public class HashMapTests {

    @Test
    public void testHashMap() {
        TestData data = Utils.generateTestData(1000);

        String mapName = "ProbingHashMap";
        HashMap<Integer,String> map = new HashMap<Integer,String>(HashMap.Type.PROBING);
        java.util.Map<Integer,String> jMap = map.toMap();

        assertTrue(MapTest.testMap(map, Integer.class, mapName, data.unsorted, data.invalid));
        assertTrue(JavaMapTest.testJavaMap(jMap, Integer.class, mapName, data.unsorted, data.sorted, data.invalid));

        mapName = "LinkingHashMap";
        map = new HashMap<Integer,String>(HashMap.Type.CHAINING);
        jMap = map.toMap();

        assertTrue(MapTest.testMap(map, Integer.class, mapName, data.unsorted, data.invalid));
        assertTrue(JavaMapTest.testJavaMap(jMap, Integer.class, mapName, data.unsorted, data.sorted, data.invalid));
        
        final int SMALL_SIZE = 10;
        final int STRESS_FACTOR = 100;
        map = new HashMap<>(HashMap.Type.PROBING, SMALL_SIZE);
        sizeStressTest(map, SMALL_SIZE, STRESS_FACTOR);
        assertTrue(map.size() > SMALL_SIZE);
        map = new HashMap<>(HashMap.Type.CHAINING, SMALL_SIZE);
        sizeStressTest(map, SMALL_SIZE, STRESS_FACTOR);
        assertTrue(map.size() > SMALL_SIZE);
    }

    private void sizeStressTest(HashMap<Integer, String> map, int size, int factor) {
        for (int i = 0; i < size * factor; i++) {
            map.put(i, null);
        }
    }
}
