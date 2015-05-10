package net.lilifei.basic;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Random;

import static org.junit.Assert.*;

/**
 * Created by Lifei on 15/5/5.
 */
public class SortTest {
    int countOfTestCases = 10;
    int lengthOfTestCase = 100;
    int rangeOfTestCase = 200;
    int[][] beforeSorted;
    int[][] expecteds;

    public SortTest() {
        this.beforeSorted = new int[countOfTestCases][lengthOfTestCase];
        this.expecteds = new int[countOfTestCases][lengthOfTestCase];
    }

    @Before
    public void setUp() throws Exception {
        Random rd = new Random();
        for (int i = 0; i < this.countOfTestCases; i++) {
            for (int j = 0; j < this.lengthOfTestCase; j++) {
                int rdInt = rd.nextInt(this.rangeOfTestCase) - 100;
                this.beforeSorted[i][j] = rdInt; // Range (-100, 100)
                this.expecteds[i][j] = rdInt;
            }
        }
        for (int i = 0; i < this.expecteds.length; i++) {
            Arrays.sort(this.expecteds[i]);
        }

    }

    @Test
    public void testInsertSort() throws Exception {
        for (int i = 0; i < this.beforeSorted.length; i++) {
            Sort.insertSort(this.beforeSorted[i]);
            assertArrayEquals(this.expecteds[i], this.beforeSorted[i]);
        }
    }

    @Test
    public void testInsertSortDescending() throws Exception {
        int[] actuals = {29, 120, 23, 55, 2, 3, -1, -33, -5};
        int[] expecteds = {120, 55, 29, 23, 3, 2, -1, -5, -33};
        Sort.insertSortDescending(actuals);
        assertArrayEquals(expecteds, actuals);
    }

    @Test
    public void testMergeSort() throws Exception {
        for (int i = 0; i < this.beforeSorted.length; i++) {
            Sort.mergeSort(this.beforeSorted[i]);
            assertArrayEquals(this.expecteds[i], this.beforeSorted[i]);
        }
    }

    @Test
    public void testMergeSortWithoutSentinels() throws Exception {
        for (int i = 0; i < this.beforeSorted.length; i++) {
            Sort.mergeSortWithoutSentinels(this.beforeSorted[i]);
            assertArrayEquals(this.expecteds[i], this.beforeSorted[i]);
        }
    }

    @Test
    public void testInsertSortRecursive() throws Exception {
        for (int i = 0; i < this.beforeSorted.length; i++) {
            Sort.insertSortRecursive(this.beforeSorted[i]);
            assertArrayEquals(this.expecteds[i], this.beforeSorted[i]);
        }
    }

    @Test
    public void testTwoSum() throws Exception {
        int[] testCase = {9, 8, -22, 0, 39, 11, -5, 27};
        int target1 = -14;
        int target2 = -97;
        assertTrue(Sort.twoSum(testCase, target1));
        assertTrue(!Sort.twoSum(testCase, target2));
    }

    @Test
    public void testCountOfInversions() throws Exception {
        for (int i = 0; i < this.beforeSorted.length; i++) {
            int[] A = this.beforeSorted[i];
            int actual = Sort.countOfInversions(A);
            int expected = 0;
            int lenA = A.length;
            for (int j = 0; j < (lenA - 1); j++) {
                for(int k = j + 1; k < lenA; k++) {
                    if(A[j] > A[k]) {
                        expected++;
                    }
                }
            }
            assertEquals(expected, actual);
        }
    }

    @Test
    public void testHeapSort() throws Exception {
        for (int i = 0; i < this.beforeSorted.length; i++) {
            Sort.heapSort(this.beforeSorted[i]);
            assertArrayEquals(this.expecteds[i], this.beforeSorted[i]);
        }
    }
}