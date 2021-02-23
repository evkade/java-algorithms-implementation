package com.jwetherell.algorithms.data_structures.test;

import static org.junit.Assert.assertTrue;

import java.util.Collection;

import org.junit.Test;

import com.jwetherell.algorithms.data_structures.BinarySearchTree;
import com.jwetherell.algorithms.data_structures.SplayTree;
import com.jwetherell.algorithms.data_structures.test.common.JavaCollectionTest;
import com.jwetherell.algorithms.data_structures.test.common.TreeTest;
import com.jwetherell.algorithms.data_structures.test.common.Utils;
import com.jwetherell.algorithms.data_structures.test.common.Utils.TestData;

public class SplayTreeTests {
	
	private class DataStruct{
		boolean[] bools;
		public DataStruct(int size) {
			this.bools = new boolean[size];
		}
		 
		
		public void addBooleans(boolean[] arg) {
			for(int i = 0; i < bools.length; i++) {
				if(arg[i]) {
					this.bools[i] = arg[i];
					continue;
				} else {
					continue;
				}
			}
		}
		
		public int size() {
			return bools.length;
		}
		
		
		
	}

    @Test
    public void testSplayTree() {
        TestData data = Utils.generateTestData(1000);
        
        
        

        String bstName = "Splay Tree";
        BinarySearchTree<Integer> bst = new SplayTree<Integer>();
        //fel på dennna nedan
        bst.boolArray = new boolean[31];
        DataStruct struct = new DataStruct(bst.boolArray.length);
      
       struct.addBooleans(bst.boolArray);
        boolean[] boolArray = struct.bools;
       
        String s = "";
        for(int i = 0; i < boolArray.length; i++ ) {
        	if( boolArray[i] == true) {
        		s += String.format(" Branch %d : true \n", i + 1);
        	} else {
        		s += String.format(" Branch %d : false \n", i + 1);
        	}
        }
        
        System.out.println(s);
        System.out.println("FIFHEOUHFIHFEF");
        
     
        Collection<Integer> bstCollection = bst.toCollection();

        assertTrue(TreeTest.testTree(bst, Integer.class, bstName,
                                     data.unsorted, data.invalid));

        
       struct.addBooleans(bst.boolArray);
       

        
        
        

        
        assertTrue(JavaCollectionTest.testCollection(bstCollection, Integer.class, bstName,
                                                     data.unsorted, data.sorted, data.invalid));
        struct.addBooleans(bst.boolArray);
        boolArray = struct.bools;
        s = "";
        for(int i = 0; i < boolArray.length; i++ ) {
        	if( boolArray[i] == true) {
        		s += String.format(" Branch %d : true \n", i + 1);
        	} else {
        		s += String.format(" Branch %d : false \n", i + 1);
        	}
        }
        System.out.println(s);
        
       
    }

}
